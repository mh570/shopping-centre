package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysSmsTemplateDao;
import com.fengling.shopping.ware.entity.SysSmsTemplateEntity;
import com.fengling.shopping.ware.service.SysSmsTemplateService;


@Service("sysSmsTemplateService")
public class SysSmsTemplateServiceImpl extends ServiceImpl<SysSmsTemplateDao, SysSmsTemplateEntity> implements SysSmsTemplateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysSmsTemplateEntity> page = this.page(
                new Query<SysSmsTemplateEntity>().getPage(params),
                new QueryWrapper<SysSmsTemplateEntity>()
        );

        return new PageUtils(page);
    }

}