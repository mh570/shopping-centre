package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.TestShoptypeTreeDao;
import com.fengling.shopping.ware.entity.TestShoptypeTreeEntity;
import com.fengling.shopping.ware.service.TestShoptypeTreeService;


@Service("testShoptypeTreeService")
public class TestShoptypeTreeServiceImpl extends ServiceImpl<TestShoptypeTreeDao, TestShoptypeTreeEntity> implements TestShoptypeTreeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestShoptypeTreeEntity> page = this.page(
                new Query<TestShoptypeTreeEntity>().getPage(params),
                new QueryWrapper<TestShoptypeTreeEntity>()
        );

        return new PageUtils(page);
    }

}