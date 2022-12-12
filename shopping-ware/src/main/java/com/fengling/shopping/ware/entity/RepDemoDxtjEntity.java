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
@TableName("rep_demo_dxtj")
public class RepDemoDxtjEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 雇佣日期
	 */
	private Date gtime;
	/**
	 * 职务
	 */
	private String updateBy;
	/**
	 * 家庭电话
	 */
	private String jphone;
	/**
	 * 出生日期
	 */
	private Date birth;
	/**
	 * 户口所在地
	 */
	private String hukou;
	/**
	 * 联系地址
	 */
	private String laddress;
	/**
	 * 紧急联系人
	 */
	private String jperson;
	/**
	 * xingbie
	 */
	private String sex;

}
