package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysCategoryDao;
import com.fengling.shopping.ware.entity.SysCategoryEntity;
import com.fengling.shopping.ware.service.SysCategoryService;


@Service("sysCategoryService")
public class SysCategoryServiceImpl extends ServiceImpl<SysCategoryDao, SysCategoryEntity> implements SysCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysCategoryEntity> page = this.page(
                new Query<SysCategoryEntity>().getPage(params),
                new QueryWrapper<SysCategoryEntity>()
        );

        return new PageUtils(page);
    }

}