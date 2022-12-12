package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.TmpReportDataIncomeDao;
import com.fengling.shopping.ware.entity.TmpReportDataIncomeEntity;
import com.fengling.shopping.ware.service.TmpReportDataIncomeService;


@Service("tmpReportDataIncomeService")
public class TmpReportDataIncomeServiceImpl extends ServiceImpl<TmpReportDataIncomeDao, TmpReportDataIncomeEntity> implements TmpReportDataIncomeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TmpReportDataIncomeEntity> page = this.page(
                new Query<TmpReportDataIncomeEntity>().getPage(params),
                new QueryWrapper<TmpReportDataIncomeEntity>()
        );

        return new PageUtils(page);
    }

}