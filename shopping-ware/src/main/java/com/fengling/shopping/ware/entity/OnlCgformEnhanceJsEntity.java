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
@TableName("onl_cgform_enhance_js")
public class OnlCgformEnhanceJsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private String id;
	/**
	 * JS增强内容
	 */
	private String cgJs;
	/**
	 * 类型
	 */
	private String cgJsType;
	/**
	 * 备注
	 */
	private String content;
	/**
	 * 表单ID
	 */
	private String cgformHeadId;

}
