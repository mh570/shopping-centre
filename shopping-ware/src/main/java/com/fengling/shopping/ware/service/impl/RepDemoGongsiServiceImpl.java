package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.RepDemoGongsiDao;
import com.fengling.shopping.ware.entity.RepDemoGongsiEntity;
import com.fengling.shopping.ware.service.RepDemoGongsiService;


@Service("repDemoGongsiService")
public class RepDemoGongsiServiceImpl extends ServiceImpl<RepDemoGongsiDao, RepDemoGongsiEntity> implements RepDemoGongsiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RepDemoGongsiEntity> page = this.page(
                new Query<RepDemoGongsiEntity>().getPage(params),
                new QueryWrapper<RepDemoGongsiEntity>()
        );

        return new PageUtils(page);
    }

}