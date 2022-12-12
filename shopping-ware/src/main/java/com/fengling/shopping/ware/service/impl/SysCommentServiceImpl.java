package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysCommentDao;
import com.fengling.shopping.ware.entity.SysCommentEntity;
import com.fengling.shopping.ware.service.SysCommentService;


@Service("sysCommentService")
public class SysCommentServiceImpl extends ServiceImpl<SysCommentDao, SysCommentEntity> implements SysCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysCommentEntity> page = this.page(
                new Query<SysCommentEntity>().getPage(params),
                new QueryWrapper<SysCommentEntity>()
        );

        return new PageUtils(page);
    }

}