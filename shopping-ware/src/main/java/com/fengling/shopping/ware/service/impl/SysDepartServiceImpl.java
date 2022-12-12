package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysDepartDao;
import com.fengling.shopping.ware.entity.SysDepartEntity;
import com.fengling.shopping.ware.service.SysDepartService;


@Service("sysDepartService")
public class SysDepartServiceImpl extends ServiceImpl<SysDepartDao, SysDepartEntity> implements SysDepartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDepartEntity> page = this.page(
                new Query<SysDepartEntity>().getPage(params),
                new QueryWrapper<SysDepartEntity>()
        );

        return new PageUtils(page);
    }

}