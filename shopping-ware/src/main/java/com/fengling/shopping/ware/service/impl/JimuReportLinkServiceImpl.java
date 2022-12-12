package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JimuReportLinkDao;
import com.fengling.shopping.ware.entity.JimuReportLinkEntity;
import com.fengling.shopping.ware.service.JimuReportLinkService;


@Service("jimuReportLinkService")
public class JimuReportLinkServiceImpl extends ServiceImpl<JimuReportLinkDao, JimuReportLinkEntity> implements JimuReportLinkService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JimuReportLinkEntity> page = this.page(
                new Query<JimuReportLinkEntity>().getPage(params),
                new QueryWrapper<JimuReportLinkEntity>()
        );

        return new PageUtils(page);
    }

}