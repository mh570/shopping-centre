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
@TableName("sys_permission_data_rule")
public class SysPermissionDataRuleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private String id;
	/**
	 * 菜单ID
	 */
	private String permissionId;
	/**
	 * 规则名称
	 */
	private String ruleName;
	/**
	 * 字段
	 */
	private String ruleColumn;
	/**
	 * 条件
	 */
	private String ruleConditions;
	/**
	 * 规则值
	 */
	private String ruleValue;
	/**
	 * 权限有效状态1有0否
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String createBy;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 修改人
	 */
	private String updateBy;

}
