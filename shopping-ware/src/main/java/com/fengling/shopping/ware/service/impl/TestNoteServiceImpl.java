package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.TestNoteDao;
import com.fengling.shopping.ware.entity.TestNoteEntity;
import com.fengling.shopping.ware.service.TestNoteService;


@Service("testNoteService")
public class TestNoteServiceImpl extends ServiceImpl<TestNoteDao, TestNoteEntity> implements TestNoteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestNoteEntity> page = this.page(
                new Query<TestNoteEntity>().getPage(params),
                new QueryWrapper<TestNoteEntity>()
        );

        return new PageUtils(page);
    }

}