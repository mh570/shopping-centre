package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.QrtzCronTriggersDao;
import com.fengling.shopping.ware.entity.QrtzCronTriggersEntity;
import com.fengling.shopping.ware.service.QrtzCronTriggersService;


@Service("qrtzCronTriggersService")
public class QrtzCronTriggersServiceImpl extends ServiceImpl<QrtzCronTriggersDao, QrtzCronTriggersEntity> implements QrtzCronTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzCronTriggersEntity> page = this.page(
                new Query<QrtzCronTriggersEntity>().getPage(params),
                new QueryWrapper<QrtzCronTriggersEntity>()
        );

        return new PageUtils(page);
    }

}