package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.RepDemoJianpiaoDao;
import com.fengling.shopping.ware.entity.RepDemoJianpiaoEntity;
import com.fengling.shopping.ware.service.RepDemoJianpiaoService;


@Service("repDemoJianpiaoService")
public class RepDemoJianpiaoServiceImpl extends ServiceImpl<RepDemoJianpiaoDao, RepDemoJianpiaoEntity> implements RepDemoJianpiaoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RepDemoJianpiaoEntity> page = this.page(
                new Query<RepDemoJianpiaoEntity>().getPage(params),
                new QueryWrapper<RepDemoJianpiaoEntity>()
        );

        return new PageUtils(page);
    }

}