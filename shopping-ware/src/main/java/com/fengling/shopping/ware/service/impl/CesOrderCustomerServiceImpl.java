package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.CesOrderCustomerDao;
import com.fengling.shopping.ware.entity.CesOrderCustomerEntity;
import com.fengling.shopping.ware.service.CesOrderCustomerService;


@Service("cesOrderCustomerService")
public class CesOrderCustomerServiceImpl extends ServiceImpl<CesOrderCustomerDao, CesOrderCustomerEntity> implements CesOrderCustomerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CesOrderCustomerEntity> page = this.page(
                new Query<CesOrderCustomerEntity>().getPage(params),
                new QueryWrapper<CesOrderCustomerEntity>()
        );

        return new PageUtils(page);
    }

}