package com.fengling.shopping.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.common.utils.PageUtils;
import com.fengling.shopping.product.entity.AttrEntity;
import com.fengling.shopping.product.vo.AttrGroupRelationVo;
import com.fengling.shopping.product.vo.AttrRespVo;
import com.fengling.shopping.product.vo.AttrVo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:24:58
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrList(Long catelogId, Map<String, Object> params, String attrType);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttrById(AttrVo attr);

    List<AttrEntity> attrRelationAttr(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVo[] attrGroupRelationVo);


    PageUtils getNoRelationAttr(Long attrgroupId, Map<String, Object> params);

}

