package com.fengling.shopping.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.common.utils.PageUtils;
import com.fengling.shopping.ware.entity.SysPermissionEntity;

import java.util.Map;

/**
 * 菜单权限表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
public interface SysPermissionService extends IService<SysPermissionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

