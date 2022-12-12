package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.QrtzSchedulerStateDao;
import com.fengling.shopping.ware.entity.QrtzSchedulerStateEntity;
import com.fengling.shopping.ware.service.QrtzSchedulerStateService;


@Service("qrtzSchedulerStateService")
public class QrtzSchedulerStateServiceImpl extends ServiceImpl<QrtzSchedulerStateDao, QrtzSchedulerStateEntity> implements QrtzSchedulerStateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzSchedulerStateEntity> page = this.page(
                new Query<QrtzSchedulerStateEntity>().getPage(params),
                new QueryWrapper<QrtzSchedulerStateEntity>()
        );

        return new PageUtils(page);
    }

}