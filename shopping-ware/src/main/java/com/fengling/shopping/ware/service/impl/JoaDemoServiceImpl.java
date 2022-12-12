package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JoaDemoDao;
import com.fengling.shopping.ware.entity.JoaDemoEntity;
import com.fengling.shopping.ware.service.JoaDemoService;


@Service("joaDemoService")
public class JoaDemoServiceImpl extends ServiceImpl<JoaDemoDao, JoaDemoEntity> implements JoaDemoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JoaDemoEntity> page = this.page(
                new Query<JoaDemoEntity>().getPage(params),
                new QueryWrapper<JoaDemoEntity>()
        );

        return new PageUtils(page);
    }

}