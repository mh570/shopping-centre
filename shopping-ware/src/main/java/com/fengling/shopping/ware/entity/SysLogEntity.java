package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统日志表
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("sys_log")
public class SysLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 日志类型（1登录日志，2操作日志）
	 */
	private Integer logType;
	/**
	 * 日志内容
	 */
	private String logContent;
	/**
	 * 操作类型
	 */
	private Integer operateType;
	/**
	 * 操作用户账号
	 */
	private String userid;
	/**
	 * 操作用户名称
	 */
	private String username;
	/**
	 * IP
	 */
	private String ip;
	/**
	 * 请求java方法
	 */
	private String method;
	/**
	 * 请求路径
	 */
	private String requestUrl;
	/**
	 * 请求参数
	 */
	private String requestParam;
	/**
	 * 请求类型
	 */
	private String requestType;
	/**
	 * 耗时
	 */
	private Long costTime;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新人
	 */
	private String updateBy;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
