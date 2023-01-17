package com.fengling.shopping.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.fengling.shopping.elasticsearch.config.ElasticSearchConfig;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ServiceElasticsearchApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void searchData() throws Exception {
        //1.创建索引请求
        SearchRequest searchRequest = new SearchRequest();
        //2.指定索引
        searchRequest.indices("xxx");
        //3.指定DSL 检索条件
        //SearchSourceBuilder sourceBuilder(里面封装的查询条件)
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //3.1构建检索条件
//        searchSourceBuilder.query();
//        searchSourceBuilder.from();
//        searchSourceBuilder.size();
//        searchSourceBuilder.aggregation();
        searchSourceBuilder.query(QueryBuilders.matchQuery("field", "xxx"));
        //创建聚合条件
        //1.查看值分布聚合
        TermsAggregationBuilder agg1 = AggregationBuilders.terms("Aggname").field("AggField").size(10);
        //将聚合条件加入到查询条件中
        searchSourceBuilder.aggregation(agg1);
        searchRequest.source(searchSourceBuilder);
        //4.执行检索 拿到数据
        SearchResponse searchResponse = client.search(searchRequest, ElasticSearchConfig.COMMON_OPTIONS);
        //5.分析结果（Json串）
        //获取所有查到的数据
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            String string = hit.getSourceAsString();
//            XXClass xxClass =  JSON.parseObject(string,XXClass.class);
//            System.out.println("xxClass"+xxClass);
        }
//    }
        //获取检索到的分析信息
        Aggregations aggregations = searchResponse.getAggregations();
        Terms aggName = aggregations.get("AggName");
        for (Terms.Bucket bucket : aggName.getBuckets()) {
            String keyAsString = bucket.getKeyAsString();
            System.out.println("年龄"+keyAsString+bucket.getDocCount());
        }
    }


    @Test
    public void contextLoads() {
        IndexRequest indexRequest = new IndexRequest("user");
        indexRequest.id("1");
        User user = new User();
        user.setAge(121);
        user.setName("万达");
        user.setGender("摸鱼快乐");
        String s = JSON.toJSONString(user);
        System.out.println(s);
        indexRequest.source(s, XContentType.JSON);
        try {
            IndexResponse index = client.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);
            System.out.println(index);
            System.out.println(index.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Data
    class User {
        private String name;
        private Integer age;
        private String gender;
    }

}
