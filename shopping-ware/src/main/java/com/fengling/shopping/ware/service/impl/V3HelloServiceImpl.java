package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.V3HelloDao;
import com.fengling.shopping.ware.entity.V3HelloEntity;
import com.fengling.shopping.ware.service.V3HelloService;


@Service("v3HelloService")
public class V3HelloServiceImpl extends ServiceImpl<V3HelloDao, V3HelloEntity> implements V3HelloService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<V3HelloEntity> page = this.page(
                new Query<V3HelloEntity>().getPage(params),
                new QueryWrapper<V3HelloEntity>()
        );

        return new PageUtils(page);
    }

}