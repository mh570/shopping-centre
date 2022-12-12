package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JimuDictDao;
import com.fengling.shopping.ware.entity.JimuDictEntity;
import com.fengling.shopping.ware.service.JimuDictService;


@Service("jimuDictService")
public class JimuDictServiceImpl extends ServiceImpl<JimuDictDao, JimuDictEntity> implements JimuDictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JimuDictEntity> page = this.page(
                new Query<JimuDictEntity>().getPage(params),
                new QueryWrapper<JimuDictEntity>()
        );

        return new PageUtils(page);
    }

}