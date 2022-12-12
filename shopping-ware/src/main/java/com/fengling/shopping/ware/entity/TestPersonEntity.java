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
@TableName("test_person")
public class TestPersonEntity implements Serializable {
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
	 * 性别
	 */
	private String sex;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 请假原因
	 */
	private String content;
	/**
	 * 请假时间
	 */
	private Date beDate;
	/**
	 * 请假天数
	 */
	private Integer qjDays;

}
