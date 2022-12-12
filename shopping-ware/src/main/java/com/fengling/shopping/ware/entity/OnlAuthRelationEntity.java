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
@TableName("onl_auth_relation")
public class OnlAuthRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 角色id
	 */
	private String roleId;
	/**
	 * 权限id
	 */
	private String authId;
	/**
	 * 1字段 2按钮 3数据权限
	 */
	private Integer type;
	/**
	 * online表单ID
	 */
	private String cgformId;
	/**
	 * 授权方式role角色，depart部门，user人
	 */
	private String authMode;

}
