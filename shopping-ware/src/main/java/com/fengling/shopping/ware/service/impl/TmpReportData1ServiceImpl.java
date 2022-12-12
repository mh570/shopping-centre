package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.TmpReportData1Dao;
import com.fengling.shopping.ware.entity.TmpReportData1Entity;
import com.fengling.shopping.ware.service.TmpReportData1Service;


@Service("tmpReportData1Service")
public class TmpReportData1ServiceImpl extends ServiceImpl<TmpReportData1Dao, TmpReportData1Entity> implements TmpReportData1Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TmpReportData1Entity> page = this.page(
                new Query<TmpReportData1Entity>().getPage(params),
                new QueryWrapper<TmpReportData1Entity>()
        );

        return new PageUtils(page);
    }

}