package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysAnnouncementSendDao;
import com.fengling.shopping.ware.entity.SysAnnouncementSendEntity;
import com.fengling.shopping.ware.service.SysAnnouncementSendService;


@Service("sysAnnouncementSendService")
public class SysAnnouncementSendServiceImpl extends ServiceImpl<SysAnnouncementSendDao, SysAnnouncementSendEntity> implements SysAnnouncementSendService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysAnnouncementSendEntity> page = this.page(
                new Query<SysAnnouncementSendEntity>().getPage(params),
                new QueryWrapper<SysAnnouncementSendEntity>()
        );

        return new PageUtils(page);
    }

}