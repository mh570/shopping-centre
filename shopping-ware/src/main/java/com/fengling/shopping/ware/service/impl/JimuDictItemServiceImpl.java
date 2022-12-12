package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JimuDictItemDao;
import com.fengling.shopping.ware.entity.JimuDictItemEntity;
import com.fengling.shopping.ware.service.JimuDictItemService;


@Service("jimuDictItemService")
public class JimuDictItemServiceImpl extends ServiceImpl<JimuDictItemDao, JimuDictItemEntity> implements JimuDictItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JimuDictItemEntity> page = this.page(
                new Query<JimuDictItemEntity>().getPage(params),
                new QueryWrapper<JimuDictItemEntity>()
        );

        return new PageUtils(page);
    }

}