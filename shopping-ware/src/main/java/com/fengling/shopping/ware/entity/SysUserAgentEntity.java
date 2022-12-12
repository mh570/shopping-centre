package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户代理人设置
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("sys_user_agent")
public class SysUserAgentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 */
	@TableId
	private String id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 代理人用户名
	 */
	private String agentUserName;
	/**
	 * 代理开始时间
	 */
	private Date startTime;
	/**
	 * 代理结束时间
	 */
	private Date endTime;
	/**
	 * 状态0无效1有效
	 */
	private String status;
	/**
	 * 创建人名称
	 */
	private String createName;
	/**
	 * 创建人登录名称
	 */
	private String createBy;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 更新人名称
	 */
	private String updateName;
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
	/**
	 * 所属公司
	 */
	private String sysCompanyCode;

}
