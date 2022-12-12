package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 超链接配置表
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("jimu_report_link")
public class JimuReportLinkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private String id;
	/**
	 * 积木设计器id
	 */
	private String reportId;
	/**
	 * 参数
	 */
	private String parameter;
	/**
	 * 弹出方式（0 当前页面 1 新窗口）
	 */
	private String ejectType;
	/**
	 * 链接名称
	 */
	private String linkName;
	/**
	 * 请求方法0-get,1-post
	 */
	private String apiMethod;
	/**
	 * 链接方式(0 网络报表 1 网络连接 2 图表联动)
	 */
	private String linkType;
	/**
	 * 外网api
	 */
	private String apiUrl;
	/**
	 * 联动图表的ID
	 */
	private String linkChartId;
	/**
	 * 条件
	 */
	private String requirement;

}
