package com.fengling.shopping.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.common.utils.PageUtils;
import com.fengling.shopping.ware.entity.SysAnnouncementEntity;

import java.util.Map;

/**
 * 系统通告表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
public interface SysAnnouncementService extends IService<SysAnnouncementEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

