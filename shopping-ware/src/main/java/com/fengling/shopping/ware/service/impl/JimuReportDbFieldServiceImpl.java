package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JimuReportDbFieldDao;
import com.fengling.shopping.ware.entity.JimuReportDbFieldEntity;
import com.fengling.shopping.ware.service.JimuReportDbFieldService;


@Service("jimuReportDbFieldService")
public class JimuReportDbFieldServiceImpl extends ServiceImpl<JimuReportDbFieldDao, JimuReportDbFieldEntity> implements JimuReportDbFieldService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JimuReportDbFieldEntity> page = this.page(
                new Query<JimuReportDbFieldEntity>().getPage(params),
                new QueryWrapper<JimuReportDbFieldEntity>()
        );

        return new PageUtils(page);
    }

}