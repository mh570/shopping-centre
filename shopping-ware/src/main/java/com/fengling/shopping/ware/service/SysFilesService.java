package com.fengling.shopping.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.common.utils.PageUtils;
import com.fengling.shopping.ware.entity.SysFilesEntity;

import java.util.Map;

/**
 * 知识库-文档管理
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
public interface SysFilesService extends IService<SysFilesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

