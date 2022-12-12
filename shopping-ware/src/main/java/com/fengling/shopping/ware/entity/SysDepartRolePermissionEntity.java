package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 部门角色权限表
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@Data
@TableName("sys_depart_role_permission")
public class SysDepartRolePermissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 部门id
	 */
	private String departId;
	/**
	 * 角色id
	 */
	private String roleId;
	/**
	 * 权限id
	 */
	private String permissionId;
	/**
	 * 数据权限ids
	 */
	private String dataRuleIds;
	/**
	 * 操作时间
	 */
	private Date operateDate;
	/**
	 * 操作ip
	 */
	private String operateIp;

}
