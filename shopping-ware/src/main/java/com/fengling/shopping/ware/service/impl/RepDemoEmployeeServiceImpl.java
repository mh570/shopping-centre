package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.RepDemoEmployeeDao;
import com.fengling.shopping.ware.entity.RepDemoEmployeeEntity;
import com.fengling.shopping.ware.service.RepDemoEmployeeService;


@Service("repDemoEmployeeService")
public class RepDemoEmployeeServiceImpl extends ServiceImpl<RepDemoEmployeeDao, RepDemoEmployeeEntity> implements RepDemoEmployeeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RepDemoEmployeeEntity> page = this.page(
                new Query<RepDemoEmployeeEntity>().getPage(params),
                new QueryWrapper<RepDemoEmployeeEntity>()
        );

        return new PageUtils(page);
    }

}