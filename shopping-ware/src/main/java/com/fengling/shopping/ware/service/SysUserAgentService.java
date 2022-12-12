package com.fengling.shopping.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.common.utils.PageUtils;
import com.fengling.shopping.ware.entity.SysUserAgentEntity;

import java.util.Map;

/**
 * 用户代理人设置
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
public interface SysUserAgentService extends IService<SysUserAgentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

