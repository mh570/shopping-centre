package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 流程测试
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("joa_demo")
public class JoaDemoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private String id;
	/**
	 * 请假人
	 */
	private String name;
	/**
	 * 请假天数
	 */
	private Integer days;
	/**
	 * 开始时间
	 */
	private Date beginDate;
	/**
	 * 请假结束时间
	 */
	private Date endDate;
	/**
	 * 请假原因
	 */
	private String reason;
	/**
	 * 流程状态
	 */
	private String bpmStatus;
	/**
	 * 创建人id
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 修改人id
	 */
	private String updateBy;

}
