package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JimuReportDataSourceDao;
import com.fengling.shopping.ware.entity.JimuReportDataSourceEntity;
import com.fengling.shopping.ware.service.JimuReportDataSourceService;


@Service("jimuReportDataSourceService")
public class JimuReportDataSourceServiceImpl extends ServiceImpl<JimuReportDataSourceDao, JimuReportDataSourceEntity> implements JimuReportDataSourceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JimuReportDataSourceEntity> page = this.page(
                new Query<JimuReportDataSourceEntity>().getPage(params),
                new QueryWrapper<JimuReportDataSourceEntity>()
        );

        return new PageUtils(page);
    }

}