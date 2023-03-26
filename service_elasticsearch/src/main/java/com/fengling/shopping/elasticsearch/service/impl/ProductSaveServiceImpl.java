package com.fengling.shopping.elasticsearch.service.impl;

import com.alibaba.fastjson.JSON;
import com.fengling.common.to.es.SkuEsModel;
import com.fengling.shopping.elasticsearch.config.ElasticSearchConfig;
import com.fengling.shopping.elasticsearch.constant.EsConstant;
import com.fengling.shopping.elasticsearch.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductSaveServiceImpl implements ProductSaveService {

    @Autowired
    private RestHighLevelClient client;

    @Override
    public boolean productStatusUp(List<SkuEsModel> skuEsModelList) throws IOException {

        //1.创建索引请求
        BulkRequest bulkRequest = new BulkRequest();
        for (SkuEsModel skuEsModel :
                skuEsModelList) {
            IndexRequest indexRequest = new IndexRequest(EsConstant.PRODUCT_INDEX);
            indexRequest.id(skuEsModel.getSkuId().toString());
            indexRequest.source(JSON.toJSONString(skuEsModel), XContentType.JSON);

            bulkRequest.add(indexRequest);
        }


        //4.执行什么检索 拿到数据
        BulkResponse bulk = client.bulk(bulkRequest, ElasticSearchConfig.COMMON_OPTIONS);

        System.out.println(JSON.toJSONString(bulk)+"拿到ddddd数据");
        boolean b = bulk.hasFailures();
        System.out.println(b+"boolean");
//        if (b == true) {
            List<String> collect = Arrays.stream(bulk.getItems()).map(BulkItemResponse::getId).collect(Collectors.toList());
            log.info("商品成功{}", collect);
//        }
        return b;


    }
}
