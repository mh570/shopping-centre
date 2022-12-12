package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.RepDemoDxtjDao;
import com.fengling.shopping.ware.entity.RepDemoDxtjEntity;
import com.fengling.shopping.ware.service.RepDemoDxtjService;


@Service("repDemoDxtjService")
public class RepDemoDxtjServiceImpl extends ServiceImpl<RepDemoDxtjDao, RepDemoDxtjEntity> implements RepDemoDxtjService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RepDemoDxtjEntity> page = this.page(
                new Query<RepDemoDxtjEntity>().getPage(params),
                new QueryWrapper<RepDemoDxtjEntity>()
        );

        return new PageUtils(page);
    }

}