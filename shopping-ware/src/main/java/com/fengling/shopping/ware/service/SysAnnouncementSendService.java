package com.fengling.shopping.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.common.utils.PageUtils;
import com.fengling.shopping.ware.entity.SysAnnouncementSendEntity;

import java.util.Map;

/**
 * 用户通告阅读标记表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
public interface SysAnnouncementSendService extends IService<SysAnnouncementSendEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

