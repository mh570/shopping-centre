package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysDictItemDao;
import com.fengling.shopping.ware.entity.SysDictItemEntity;
import com.fengling.shopping.ware.service.SysDictItemService;


@Service("sysDictItemService")
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemDao, SysDictItemEntity> implements SysDictItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDictItemEntity> page = this.page(
                new Query<SysDictItemEntity>().getPage(params),
                new QueryWrapper<SysDictItemEntity>()
        );

        return new PageUtils(page);
    }

}