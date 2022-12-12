package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.QrtzJobDetailsDao;
import com.fengling.shopping.ware.entity.QrtzJobDetailsEntity;
import com.fengling.shopping.ware.service.QrtzJobDetailsService;


@Service("qrtzJobDetailsService")
public class QrtzJobDetailsServiceImpl extends ServiceImpl<QrtzJobDetailsDao, QrtzJobDetailsEntity> implements QrtzJobDetailsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzJobDetailsEntity> page = this.page(
                new Query<QrtzJobDetailsEntity>().getPage(params),
                new QueryWrapper<QrtzJobDetailsEntity>()
        );

        return new PageUtils(page);
    }

}