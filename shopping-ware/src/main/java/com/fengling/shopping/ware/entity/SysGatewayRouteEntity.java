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
@TableName("sys_gateway_route")
public class SysGatewayRouteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 路由ID
	 */
	private String routerId;
	/**
	 * 服务名
	 */
	private String name;
	/**
	 * 服务地址
	 */
	private String uri;
	/**
	 * 断言
	 */
	private String predicates;
	/**
	 * 过滤器
	 */
	private String filters;
	/**
	 * 是否重试:0-否 1-是
	 */
	private Integer retryable;
	/**
	 * 是否忽略前缀0-否 1-是
	 */
	private Integer stripPrefix;
	/**
	 * 是否为保留数据:0-否 1-是
	 */
	private Integer persistable;
	/**
	 * 是否在接口文档中展示:0-否 1-是
	 */
	private Integer showApi;
	/**
	 * 状态:0-无效 1-有效
	 */
	private Integer status;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 更新人
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
