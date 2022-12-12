package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JimuReportDbParamDao;
import com.fengling.shopping.ware.entity.JimuReportDbParamEntity;
import com.fengling.shopping.ware.service.JimuReportDbParamService;


@Service("jimuReportDbParamService")
public class JimuReportDbParamServiceImpl extends ServiceImpl<JimuReportDbParamDao, JimuReportDbParamEntity> implements JimuReportDbParamService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JimuReportDbParamEntity> page = this.page(
                new Query<JimuReportDbParamEntity>().getPage(params),
                new QueryWrapper<JimuReportDbParamEntity>()
        );

        return new PageUtils(page);
    }

}