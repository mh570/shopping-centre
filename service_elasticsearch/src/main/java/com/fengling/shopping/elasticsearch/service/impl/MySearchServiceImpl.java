package com.fengling.shopping.elasticsearch.service.impl;

import com.fengling.shopping.elasticsearch.config.ElasticSearchConfig;
import com.fengling.shopping.elasticsearch.constant.EsConstant;
import com.fengling.shopping.elasticsearch.service.MySearchService;
import com.fengling.shopping.elasticsearch.vo.SearchParam;
import com.fengling.shopping.elasticsearch.vo.SearchResult;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Service
public class MySearchServiceImpl implements MySearchService {

    //TODO 经典ElasticSearch查询
    @Autowired
    private RestHighLevelClient client;

    @Override
    public SearchResult getListHtml(SearchParam searchParam) {
        SearchResult searchResult = null;

        SearchRequest searchRequest = buildSearchRequest(searchParam);

        try {
            //4.执行检索 拿到数据
            SearchResponse search = client.search(searchRequest, ElasticSearchConfig.COMMON_OPTIONS);
            //处理数据
            searchResult = buildSearchResult(search);
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
            query.filter(QueryBuilders.termQuery("catalogId", searchParam.getBrandId()));
        }
        if (searchParam.getBrandId() != null && searchParam.getBrandId().size() > 0) {
            query.filter(QueryBuilders.termsQuery("brandId", searchParam.getBrandId()));
        }
        query.filter(QueryBuilders.termsQuery("hasStock", searchParam.getHasStock() == 1));
        if(StringUtils.hasText(searchParam.getSkuPrice())){
            RangeQueryBuilder skuPrice = QueryBuilders.rangeQuery("skuPrice");
            String[] s = searchParam.getSkuPrice().split("_");
            if (s.length == 2) {
                skuPrice.gte(s[0]).lte(s[1]);
            }else if (s.length == 1){
                if ()
            }
            query.filter(skuPrice);
        }

        //封装查询query数据到searchSourceBuilder
        searchSourceBuilder.query(query);
        //创建聚合条件


//        TermsAggregationBuilder agg1 = AggregationBuilders.terms("Aggname").field("AggField").size(10);
//        searchSourceBuilder.aggregation(agg1);


        //将聚合条件加入到查询条件中
        SearchRequest searchRequest = new SearchRequest(new String[]{EsConstant.PRODUCT_INDEX}, searchSourceBuilder);
        return searchRequest;
    }


    private SearchResult buildSearchResult(SearchResponse search) {

        return null;
    }


}
