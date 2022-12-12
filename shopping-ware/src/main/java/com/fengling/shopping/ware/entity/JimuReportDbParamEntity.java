package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("jimu_report_db_param")
public class JimuReportDbParamEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 动态报表ID
	 */
	private String jimuReportHeadId;
	/**
	 * 参数字段
	 */
	private String paramName;
	/**
	 * 参数文本
	 */
	private String paramTxt;
	/**
	 * 参数默认值
	 */
	private String paramValue;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 创建人登录名称
	 */
	private String createBy;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 更新人登录名称
	 */
	private String updateBy;
	/**
	 * 更新日期
	 */
	private Date updateTime;
	/**
	 * 查询标识0否1是 默认0
	 */
	private Integer searchFlag;
	/**
	 * 查询控件类型
	 */
	private String widgetType;
	/**
	 * 查询模式1简单2范围
	 */
	private Integer searchMode;
	/**
	 * 字典
	 */
	private String dictCode;
	/**
	 * 查询时间格式化表达式
	 */
	private String searchFormat;
	/**
	 * 参数配置
	 */
	private String extJson;

}
