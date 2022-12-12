package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Online表单自定义按钮
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("onl_cgform_button")
public class OnlCgformButtonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private String id;
	/**
	 * 按钮编码
	 */
	private String buttonCode;
	/**
	 * 按钮图标
	 */
	private String buttonIcon;
	/**
	 * 按钮名称
	 */
	private String buttonName;
	/**
	 * 按钮状态
	 */
	private String buttonStatus;
	/**
	 * 按钮样式
	 */
	private String buttonStyle;
	/**
	 * 表达式
	 */
	private String exp;
	/**
	 * 表单ID
	 */
	private String cgformHeadId;
	/**
	 * 按钮类型
	 */
	private String optType;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 按钮位置1侧面 2底部
	 */
	private String optPosition;

}
