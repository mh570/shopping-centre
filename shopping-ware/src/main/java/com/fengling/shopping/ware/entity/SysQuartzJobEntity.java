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
@TableName("sys_quartz_job")
public class SysQuartzJobEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 删除状态
	 */
	private Integer delFlag;
	/**
	 * 修改人
	 */
	private String updateBy;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 任务类名
	 */
	private String jobClassName;
	/**
	 * cron表达式
	 */
	private String cronExpression;
	/**
	 * 参数
	 */
	private String parameter;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 状态 0正常 -1停止
	 */
	private Integer status;

}
