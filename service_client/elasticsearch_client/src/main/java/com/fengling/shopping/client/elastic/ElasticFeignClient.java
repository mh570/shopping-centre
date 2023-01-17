package com.fengling.shopping.client.elastic;

import com.fengling.common.to.es.SkuEsModel;
import com.fengling.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("shopping-elasticsearch")
public interface ElasticFeignClient {

    @PostMapping("/search/save/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModelList);

}
