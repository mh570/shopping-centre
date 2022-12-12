package com.fengling.shopping.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.common.utils.PageUtils;
import com.fengling.shopping.coupon.entity.SeckillPromotionEntity;

import java.util.Map;

/**
 * 
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:27:14
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

