package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.OssFileDao;
import com.fengling.shopping.ware.entity.OssFileEntity;
import com.fengling.shopping.ware.service.OssFileService;


@Service("ossFileService")
public class OssFileServiceImpl extends ServiceImpl<OssFileDao, OssFileEntity> implements OssFileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OssFileEntity> page = this.page(
                new Query<OssFileEntity>().getPage(params),
                new QueryWrapper<OssFileEntity>()
        );

        return new PageUtils(page);
    }

}