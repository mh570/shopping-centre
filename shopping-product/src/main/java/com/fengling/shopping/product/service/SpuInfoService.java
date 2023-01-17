package com.fengling.shopping.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.common.utils.PageUtils;
import com.fengling.shopping.product.entity.SpuInfoDescEntity;
import com.fengling.shopping.product.entity.SpuInfoEntity;
import com.fengling.shopping.product.vo.SpuSaveVo;

import java.util.Map;

/**
 * spu
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:24:58
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo saveVo);

    void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity);


    PageUtils queryPageCondition(Map<String, Object> params);

    void up(Long spuId);
}

