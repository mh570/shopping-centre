package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JeecgMonthlyGrowthAnalysisDao;
import com.fengling.shopping.ware.entity.JeecgMonthlyGrowthAnalysisEntity;
import com.fengling.shopping.ware.service.JeecgMonthlyGrowthAnalysisService;


@Service("jeecgMonthlyGrowthAnalysisService")
public class JeecgMonthlyGrowthAnalysisServiceImpl extends ServiceImpl<JeecgMonthlyGrowthAnalysisDao, JeecgMonthlyGrowthAnalysisEntity> implements JeecgMonthlyGrowthAnalysisService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JeecgMonthlyGrowthAnalysisEntity> page = this.page(
                new Query<JeecgMonthlyGrowthAnalysisEntity>().getPage(params),
                new QueryWrapper<JeecgMonthlyGrowthAnalysisEntity>()
        );

        return new PageUtils(page);
    }

}