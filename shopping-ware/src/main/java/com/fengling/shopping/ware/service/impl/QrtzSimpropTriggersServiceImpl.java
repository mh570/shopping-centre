package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.QrtzSimpropTriggersDao;
import com.fengling.shopping.ware.entity.QrtzSimpropTriggersEntity;
import com.fengling.shopping.ware.service.QrtzSimpropTriggersService;


@Service("qrtzSimpropTriggersService")
public class QrtzSimpropTriggersServiceImpl extends ServiceImpl<QrtzSimpropTriggersDao, QrtzSimpropTriggersEntity> implements QrtzSimpropTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzSimpropTriggersEntity> page = this.page(
                new Query<QrtzSimpropTriggersEntity>().getPage(params),
                new QueryWrapper<QrtzSimpropTriggersEntity>()
        );

        return new PageUtils(page);
    }

}