package com.fengling.shopping.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.common.utils.PageUtils;
import com.fengling.shopping.product.entity.AttrGroupEntity;
import com.fengling.shopping.product.vo.AttrGroupWithAttrsVo;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:24:58
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);

    List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId);

}

