package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JimuReportDao;
import com.fengling.shopping.ware.entity.JimuReportEntity;
import com.fengling.shopping.ware.service.JimuReportService;


@Service("jimuReportService")
public class JimuReportServiceImpl extends ServiceImpl<JimuReportDao, JimuReportEntity> implements JimuReportService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JimuReportEntity> page = this.page(
                new Query<JimuReportEntity>().getPage(params),
                new QueryWrapper<JimuReportEntity>()
        );

        return new PageUtils(page);
    }

}