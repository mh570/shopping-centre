package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JimuReportMapDao;
import com.fengling.shopping.ware.entity.JimuReportMapEntity;
import com.fengling.shopping.ware.service.JimuReportMapService;


@Service("jimuReportMapService")
public class JimuReportMapServiceImpl extends ServiceImpl<JimuReportMapDao, JimuReportMapEntity> implements JimuReportMapService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JimuReportMapEntity> page = this.page(
                new Query<JimuReportMapEntity>().getPage(params),
                new QueryWrapper<JimuReportMapEntity>()
        );

        return new PageUtils(page);
    }

}