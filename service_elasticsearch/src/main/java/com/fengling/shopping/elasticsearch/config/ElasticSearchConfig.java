package com.fengling.shopping.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

    public static final RequestOptions COMMON_OPTIONS;
    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        COMMON_OPTIONS =builder.build();
    }
    @Bean
    public RestHighLevelClient searchConfig() {
        RestClientBuilder http = RestClient.builder(
                new HttpHost("192.168.56.10", 9200, "http"));
        RestHighLevelClient client = new RestHighLevelClient(http);
        return client;
    }

//    @Bean
//    public ElasticsearchClient transportSearchConfig() {
//        RestClient restClient = RestClient.builder(
//                new HttpHost("192.168.56.10", 9200, "http")).build();
//        ElasticsearchTransport transport = new RestClientTransport(
//                restClient, new JacksonJsonpMapper());
//        ElasticsearchClient client = new ElasticsearchClient(transport);
//        return client;
//    }


}
