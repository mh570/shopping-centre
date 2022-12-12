package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysFillRuleDao;
import com.fengling.shopping.ware.entity.SysFillRuleEntity;
import com.fengling.shopping.ware.service.SysFillRuleService;


@Service("sysFillRuleService")
public class SysFillRuleServiceImpl extends ServiceImpl<SysFillRuleDao, SysFillRuleEntity> implements SysFillRuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysFillRuleEntity> page = this.page(
                new Query<SysFillRuleEntity>().getPage(params),
                new QueryWrapper<SysFillRuleEntity>()
        );

        return new PageUtils(page);
    }

}