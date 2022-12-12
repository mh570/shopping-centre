package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.QrtzFiredTriggersDao;
import com.fengling.shopping.ware.entity.QrtzFiredTriggersEntity;
import com.fengling.shopping.ware.service.QrtzFiredTriggersService;


@Service("qrtzFiredTriggersService")
public class QrtzFiredTriggersServiceImpl extends ServiceImpl<QrtzFiredTriggersDao, QrtzFiredTriggersEntity> implements QrtzFiredTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzFiredTriggersEntity> page = this.page(
                new Query<QrtzFiredTriggersEntity>().getPage(params),
                new QueryWrapper<QrtzFiredTriggersEntity>()
        );

        return new PageUtils(page);
    }

}