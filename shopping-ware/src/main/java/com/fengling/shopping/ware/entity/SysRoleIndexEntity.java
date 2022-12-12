package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色首页表
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@Data
@TableName("sys_role_index")
public class SysRoleIndexEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 角色编码
	 */
	private String roleCode;
	/**
	 * 路由地址
	 */
	private String url;
	/**
	 * 组件
	 */
	private String component;
	/**
	 * 是否路由菜单: 0:不是  1:是（默认值1）
	 */
	private Integer isRoute;
	/**
	 * 优先级
	 */
	private Integer priority;
	/**
	 * 状态0:无效 1:有效
	 */
	private String status;
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
	 * 所属部门
	 */
	private String sysOrgCode;

}
