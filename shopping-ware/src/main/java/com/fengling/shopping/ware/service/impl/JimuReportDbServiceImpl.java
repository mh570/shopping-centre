package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JimuReportDbDao;
import com.fengling.shopping.ware.entity.JimuReportDbEntity;
import com.fengling.shopping.ware.service.JimuReportDbService;


@Service("jimuReportDbService")
public class JimuReportDbServiceImpl extends ServiceImpl<JimuReportDbDao, JimuReportDbEntity> implements JimuReportDbService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JimuReportDbEntity> page = this.page(
                new Query<JimuReportDbEntity>().getPage(params),
                new QueryWrapper<JimuReportDbEntity>()
        );

        return new PageUtils(page);
    }

}