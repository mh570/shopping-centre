package com.fengling.shopping.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengling.common.utils.PageUtils;
import com.fengling.shopping.ware.entity.JimuReportShareEntity;

import java.util.Map;

/**
 * 积木报表预览权限表
 *
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
public interface JimuReportShareService extends IService<JimuReportShareEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

