package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.AiControlSingleDao;
import com.fengling.shopping.ware.entity.AiControlSingleEntity;
import com.fengling.shopping.ware.service.AiControlSingleService;


@Service("aiControlSingleService")
public class AiControlSingleServiceImpl extends ServiceImpl<AiControlSingleDao, AiControlSingleEntity> implements AiControlSingleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AiControlSingleEntity> page = this.page(
                new Query<AiControlSingleEntity>().getPage(params),
                new QueryWrapper<AiControlSingleEntity>()
        );

        return new PageUtils(page);
    }

}