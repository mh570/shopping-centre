package com.fengling.shopping.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.common.utils.PageUtils;
import com.fengling.shopping.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:24:58
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

