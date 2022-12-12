package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysCheckRuleDao;
import com.fengling.shopping.ware.entity.SysCheckRuleEntity;
import com.fengling.shopping.ware.service.SysCheckRuleService;


@Service("sysCheckRuleService")
public class SysCheckRuleServiceImpl extends ServiceImpl<SysCheckRuleDao, SysCheckRuleEntity> implements SysCheckRuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysCheckRuleEntity> page = this.page(
                new Query<SysCheckRuleEntity>().getPage(params),
                new QueryWrapper<SysCheckRuleEntity>()
        );

        return new PageUtils(page);
    }

}