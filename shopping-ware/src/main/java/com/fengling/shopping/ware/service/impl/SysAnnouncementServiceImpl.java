package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysAnnouncementDao;
import com.fengling.shopping.ware.entity.SysAnnouncementEntity;
import com.fengling.shopping.ware.service.SysAnnouncementService;


@Service("sysAnnouncementService")
public class SysAnnouncementServiceImpl extends ServiceImpl<SysAnnouncementDao, SysAnnouncementEntity> implements SysAnnouncementService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysAnnouncementEntity> page = this.page(
                new Query<SysAnnouncementEntity>().getPage(params),
                new QueryWrapper<SysAnnouncementEntity>()
        );

        return new PageUtils(page);
    }

}