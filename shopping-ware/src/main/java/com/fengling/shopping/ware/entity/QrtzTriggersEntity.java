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
@TableName("qrtz_triggers")
public class QrtzTriggersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String schedName;
	/**
	 * 
	 */
	private String triggerName;
	/**
	 * 
	 */
	private String triggerGroup;
	/**
	 * 
	 */
	private String jobName;
	/**
	 * 
	 */
	private String jobGroup;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private Long nextFireTime;
	/**
	 * 
	 */
	private Long prevFireTime;
	/**
	 * 
	 */
	private Integer priority;
	/**
	 * 
	 */
	private String triggerState;
	/**
	 * 
	 */
	private String triggerType;
	/**
	 * 
	 */
	private Long startTime;
	/**
	 * 
	 */
	private Long endTime;
	/**
	 * 
	 */
	private String calendarName;
	/**
	 * 
	 */
	private Integer misfireInstr;
	/**
	 * 
	 */
//	private unknowType jobData;

}
