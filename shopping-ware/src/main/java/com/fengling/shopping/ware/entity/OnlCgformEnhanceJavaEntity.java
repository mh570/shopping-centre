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
@TableName("onl_cgform_enhance_java")
public class OnlCgformEnhanceJavaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 按钮编码
	 */
	private String buttonCode;
	/**
	 * 类型
	 */
	private String cgJavaType;
	/**
	 * 数值
	 */
	private String cgJavaValue;
	/**
	 * 表单ID
	 */
	private String cgformHeadId;
	/**
	 * 生效状态
	 */
	private String activeStatus;
	/**
	 * 事件状态(end:结束，start:开始)
	 */
	private String event;

}
