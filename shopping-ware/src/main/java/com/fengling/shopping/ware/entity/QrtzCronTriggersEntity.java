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
 * @date 2022-12-12 22:19:33
 */
@Data
@TableName("qrtz_cron_triggers")
public class QrtzCronTriggersEntity implements Serializable {
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
	private String cronExpression;
	/**
	 * 
	 */
	private String timeZoneId;

}
