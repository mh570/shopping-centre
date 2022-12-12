package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JeecgOrderMainDao;
import com.fengling.shopping.ware.entity.JeecgOrderMainEntity;
import com.fengling.shopping.ware.service.JeecgOrderMainService;


@Service("jeecgOrderMainService")
public class JeecgOrderMainServiceImpl extends ServiceImpl<JeecgOrderMainDao, JeecgOrderMainEntity> implements JeecgOrderMainService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JeecgOrderMainEntity> page = this.page(
                new Query<JeecgOrderMainEntity>().getPage(params),
                new QueryWrapper<JeecgOrderMainEntity>()
        );

        return new PageUtils(page);
    }

}