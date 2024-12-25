package com.fengling.shopping.elasticsearch.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fengling.common.to.SkuHasStockVo;
import com.fengling.common.to.es.SkuEsModel;
import com.fengling.common.utils.R;
import com.fengling.shopping.client.product.ProductFeignClient;
import com.fengling.shopping.elasticsearch.config.ElasticSearchConfig;
import com.fengling.shopping.elasticsearch.constant.EsConstant;
import com.fengling.shopping.elasticsearch.service.MySearchService;
import com.fengling.shopping.elasticsearch.vo.AttrResponseVo;
import com.fengling.shopping.elasticsearch.vo.BrandVo;
import com.fengling.shopping.elasticsearch.vo.SearchParam;
import com.fengling.shopping.elasticsearch.vo.SearchResult;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.nested.ParsedNested;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MySearchServiceImpl implements MySearchService {

    //TODO 经典ElasticSearch查询
    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private ProductFeignClient productFeignClient;


    @Override
    public SearchResult getListHtml(SearchParam searchParam) {
        SearchResult searchResult = null;

        SearchRequest searchRequest = buildSearchRequest(searchParam);

        try {
            //4.执行检索 拿到数据
            SearchResponse search = client.search(searchRequest, ElasticSearchConfig.COMMON_OPTIONS);
            //处理数据
            searchResult = buildSearchResult(search, searchParam);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchResult;

    }

    //条件
    private SearchRequest buildSearchRequest(SearchParam searchParam) {
        //3.1构建检索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder query = QueryBuilders.boolQuery();

        if (StringUtils.hasText(searchParam.getKeyword())) {
            query.must(QueryBuilders.matchQuery("skuTitle", searchParam.getKeyword()));
        }
        if (searchParam.getCatalog3Id() != null) {
            query.filter(QueryBuilders.termQuery("catalogId", searchParam.getCatalog3Id()));
        }
        if (searchParam.getBrandId() != null && searchParam.getBrandId().size() > 0) {
            query.filter(QueryBuilders.termsQuery("brandId", searchParam.getBrandId()));
        }
        if (searchParam.getAttrs() != null && searchParam.getAttrs().size() > 0) {

            for (String attr : searchParam.getAttrs()) {
                BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
                String[] s = attr.split("_");
                String attrId = s[0];
                String[] split = s[1].split(";");
                queryBuilder.must(QueryBuilders.termQuery("attrs.attrId", attrId));
                queryBuilder.must(QueryBuilders.termQuery("attrs.attrValue", split));
                NestedQueryBuilder attrs = QueryBuilders.nestedQuery("attrs", queryBuilder, ScoreMode.None);
                query.filter(attrs);
            }

        }
        if (searchParam.getHasStock() != null) {
            query.filter(QueryBuilders.termsQuery("hasStock", searchParam.getHasStock() == 1));
        }


        if (StringUtils.hasText(searchParam.getSkuPrice())) {

            RangeQueryBuilder skuPrice = QueryBuilders.rangeQuery("skuPrice");
            String[] s = searchParam.getSkuPrice().split("_");
            if (s.length == 2) {
                skuPrice.gte(s[0]).lte(s[1]);
            } else if (s.length == 1) {
                if (searchParam.getSkuPrice().startsWith("_")) {
                    skuPrice.lte(s[0]);
                }
                if (searchParam.getSkuPrice().endsWith("_")) {
                    skuPrice.gte(s[0]);
                }
            }
            query.filter(skuPrice);
        }

        //封装查询query数据到searchSourceBuilder
        searchSourceBuilder.query(query);
        //创建聚合条件


        if (StringUtils.hasText(searchParam.getSort())) {
            String[] split = searchParam.getSort().split("_");
            SortOrder asc = split[1].equalsIgnoreCase("asc") ? SortOrder.ASC : SortOrder.DESC;
            searchSourceBuilder.sort(split[0], asc);
        }
        if (searchParam.getPageNum() != null) {
            searchSourceBuilder.from((searchParam.getPageNum() - 1) * EsConstant.PRODUCT_PAGESIZE);
        }

        searchSourceBuilder.size(EsConstant.PRODUCT_PAGESIZE);

        if (StringUtils.hasText(searchParam.getKeyword())) {
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.field("skuTitle");
            highlightBuilder.preTags("<b style='color:red'");
            highlightBuilder.postTags("</b>");
            searchSourceBuilder.highlighter(highlightBuilder);
        }


        TermsAggregationBuilder agg1 = AggregationBuilders.terms("brand_agg");
        agg1.field("brandId").size(50);
        agg1.subAggregation(AggregationBuilders.terms("brand_name_agg").field("brandName").size(10));
        //zhu
        agg1.subAggregation(AggregationBuilders.terms("brand_img_agg").field("brandImg.keyword").size(1));
        searchSourceBuilder.aggregation(agg1);


        TermsAggregationBuilder agg2 = AggregationBuilders.terms("catalog_agg").field("catalogId").size(20);
        agg2.subAggregation(AggregationBuilders.terms("catalog_name_agg").field("catalogName").size(1));
        searchSourceBuilder.aggregation(agg2);

        NestedAggregationBuilder agg3 = AggregationBuilders.nested("attr_agg", "attrs");
        TermsAggregationBuilder attr_id_agg = AggregationBuilders.terms("attr_id_agg").field("attrs.attrId").size(10);
        attr_id_agg.subAggregation(AggregationBuilders.terms("attr_name_agg").field("attrs.attrName.keyword").size(1));
        attr_id_agg.subAggregation(AggregationBuilders.terms("attr_value_agg").field("attrs.attrValue").size(50));
        agg3.subAggregation(attr_id_agg);
        searchSourceBuilder.aggregation(agg3);


        System.out.println(searchSourceBuilder.toString());

        //将聚合条件加入到查询条件中
        SearchRequest searchRequest = new SearchRequest(new String[]{EsConstant.PRODUCT_INDEX}, searchSourceBuilder);


        return searchRequest;
    }


    private SearchResult buildSearchResult(SearchResponse search, SearchParam searchParam) {
        SearchResult searchResult = new SearchResult();


        SearchHits hits = search.getHits();
        SearchHit[] hits1 = hits.getHits();
        List<SkuEsModel> list = new ArrayList<>();
        for (SearchHit hit :
                hits1) {
            String sourceAsString = hit.getSourceAsString();
            SkuEsModel skuEsModel = JSON.parseObject(sourceAsString, SkuEsModel.class);
            if (StringUtils.hasText(searchParam.getKeyword())) {
                HighlightField skuTitle = hit.getHighlightFields().get("skuTitle");
                String string = skuTitle.getFragments()[0].string();
                skuEsModel.setSkuTitle(string);
            }
            list.add(skuEsModel);
        }
        searchResult.setProducts(list);
        ParsedLongTerms catalog_agg = search.getAggregations().get("catalog_agg");
        List<SearchResult.CatalogVo> catalogVos = new ArrayList<>();
        List<? extends Terms.Bucket> buckets = catalog_agg.getBuckets();
        for (Terms.Bucket bucket :
                buckets) {
            SearchResult.CatalogVo catalogVo = new SearchResult.CatalogVo();
            catalogVo.setCatalogId(Long.valueOf(bucket.getKeyAsString()));
            ParsedStringTerms catalog_name_agg = bucket.getAggregations().get("catalog_name_agg");
            String keyAsString = catalog_name_agg.getBuckets().get(0).getKeyAsString();
            catalogVo.setCatalogName(keyAsString);
            catalogVos.add(catalogVo);
        }
        searchResult.setCatalogVos(catalogVos);
        ParsedLongTerms brand_agg = search.getAggregations().get("brand_agg");
        List<? extends Terms.Bucket> buckets1 = brand_agg.getBuckets();
        List<SearchResult.BrandVo> brandVos = new ArrayList<>();
        for (Terms.Bucket bucket :
                buckets1) {
            SearchResult.BrandVo brandVo = new SearchResult.BrandVo();
            long l = bucket.getKeyAsNumber().longValue();
            brandVo.setBrandId(l);
            ParsedStringTerms brand_img_agg = bucket.getAggregations().get("brand_img_agg");
            if (brand_img_agg.getBuckets().size() > 0 && brand_img_agg.getBuckets() != null) {
                String keyAsStringImg = brand_img_agg.getBuckets().get(0).getKeyAsString();
                brandVo.setBrandImg(keyAsStringImg);
            }

            ParsedStringTerms name_agg = bucket.getAggregations().get("brand_name_agg");
            if (name_agg.getBuckets().size() > 0 && name_agg.getBuckets() != null) {
                String name = name_agg.getBuckets().get(0).getKeyAsString();
                brandVo.setBrandName(name);
            }


            brandVos.add(brandVo);
        }
        searchResult.setBrandVos(brandVos);
        ParsedNested attr_agg = search.getAggregations().get("attr_agg");
        ParsedLongTerms attr_id_agg = attr_agg.getAggregations().get("attr_id_agg");
        List<? extends Terms.Bucket> buckets2 = attr_id_agg.getBuckets();
        List<SearchResult.AttrVo> attrVos = new ArrayList<>();
        for (Terms.Bucket bucket :
                buckets2) {
            SearchResult.AttrVo attrVo = new SearchResult.AttrVo();

            long l = bucket.getKeyAsNumber().longValue();
            attrVo.setAttrId(l);
            ParsedStringTerms name_agg = bucket.getAggregations().get("attr_name_agg");
            String name = name_agg.getBuckets().get(0).getKeyAsString();
            ParsedStringTerms value_agg = bucket.getAggregations().get("attr_value_agg");
            List<String> collect = value_agg.getBuckets().stream().map(item -> {
                String keyAsString = item.getKeyAsString();
                return keyAsString;
            }).collect(Collectors.toList());
            attrVo.setAttrName(name);
            attrVo.setAttrValue(collect);

            attrVos.add(attrVo);
        }

        searchResult.setAttrVos(attrVos);


        Long totalHits = hits.getTotalHits().value;
        int aa = (int) (totalHits % EsConstant.PRODUCT_PAGESIZE == 0 ? totalHits / EsConstant.PRODUCT_PAGESIZE : (totalHits / EsConstant.PRODUCT_PAGESIZE + 1));
        searchResult.setTotalPages(aa);
        searchResult.setTotal(totalHits);
        searchResult.setPageNum(searchParam.getPageNum());

        List<Integer> pageNavs = new ArrayList<>();
        for (int i = 0; i < aa; i++) {
            pageNavs.add(i);

        }
        searchResult.setPageNavs(pageNavs);


        if (searchParam.getAttrs() != null && searchParam.getAttrs().size() > 0) {
            List<SearchResult.NavVo> collect = searchParam.getAttrs().stream().map(item -> {
                SearchResult.NavVo navVo = new SearchResult.NavVo();

                String[] s = item.split("_");
                String s1 = s[0];

                navVo.setNavValue(s[1]);

                R attrsInfo = productFeignClient.getAttrsInfo(Long.valueOf(s1));
                searchResult.getAttrIds().add(Long.valueOf(s1));
                if (attrsInfo.getCode() == 0) {
                    AttrResponseVo data = attrsInfo.getData("attr", new TypeReference<AttrResponseVo>() {
                    });
                    navVo.setNavName(data.getAttrName());
                } else {
                    navVo.setNavName(s[0]);
                }

//                //2、取消了这个面包屑以后，我们要跳转到哪个地方，将请求的地址url里面的当前置空
//                //拿到所有的查询条件，去掉当前
                String replace = getreplaceString(searchParam, item, "attrs");


                navVo.setLink("http://search.fengling.com/list.html?" + replace);

                return navVo;
            }).collect(Collectors.toList());



            searchResult.setNavs(collect);
        }

        if(searchParam.getBrandId() != null && searchParam.getBrandId().size() > 0) {

            List<SearchResult.NavVo> navs = searchResult.getNavs();
            SearchResult.NavVo navVo = new SearchResult.NavVo();
            navVo.setNavName("品牌");
            R infos = productFeignClient.infos(searchParam.getBrandId());
            if (infos.getCode() == 0) {
                List<BrandVo> brandId = infos.getData("brand", new TypeReference<List<BrandVo>>() {
                });
                String replace = "";
                StringBuffer stringBuffer = new StringBuffer();
                for (BrandVo brand:
                     brandId) {
                    stringBuffer.append(brand.getName() + ";");
                     replace = getreplaceString(searchParam, brand.getBrandId() + "", "brandId");

                }
                navVo.setLink("http://search.fengling.com/list.html?" + replace);
                navVo.setNavValue(stringBuffer.toString());
            }

            navs.add(navVo);
            searchResult.setNavs(navs);

        }



        return searchResult;
    }

    private String getreplaceString(SearchParam searchParam, String values, String keys) {
        String encode = null;
        try {
            encode = URLEncoder.encode(values, "UTF-8");
            encode.replace("+", "%20");  //浏览器对空格的编码和Java不一样，差异化处理
            //浏览器对空格的编码和Java不一样，差异化处理
            //浏览器对空格的编码和Java不一样，差异化处理
            //浏览器对空格的编码和Java不一样，差异化处理
            //浏览器对空格的编码和Java不一样，差异化处理
            //浏览器对空格的编码和Java不一样，差异化处理
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String queryString = searchParam.get_queryString();
//                keyword=%E5%AE%9E%E6%89%93%E5%AE%9E&attrs=15_%E5%97%A1%E5%97%A1%E5%97%A1
//                                                          15_%E5%97%A1%E5%97%A1%E5%97%A1
//                keyword=%E5%AE%9E%E6%89%93%E5%AE%9E
        String replace = queryString.replace("&" + keys + "=" + encode, "");
        return replace;
    }


}
