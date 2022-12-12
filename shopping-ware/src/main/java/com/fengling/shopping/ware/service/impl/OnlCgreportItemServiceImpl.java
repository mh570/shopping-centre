package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OnlCgreportItemDao;
import com.fengling.shopping.ware.entity.OnlCgreportItemEntity;
import com.fengling.shopping.ware.service.OnlCgreportItemService;


@Service("onlCgreportItemService")
public class OnlCgreportItemServiceImpl extends ServiceImpl<OnlCgreportItemDao, OnlCgreportItemEntity> implements OnlCgreportItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OnlCgreportItemEntity> page = this.page(
                new Query<OnlCgreportItemEntity>().getPage(params),
                new QueryWrapper<OnlCgreportItemEntity>()
        );

        return new PageUtils(page);
    }

}