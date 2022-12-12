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
@TableName("ceshi_001")
public class Ceshi001Entity implements Serializable {
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
	 * 所属部门
	 */
	private String sysOrgCode;
	/**
	 * 用户名字
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 打卡时间
	 */
	private Date dakaTime;
	/**
	 * 薪资
	 */
	private Double salary;
	/**
	 * 备注
	 */
	private String ccc;
	/**
	 * 所属部门
	 */
	private String depSuo;
	/**
	 * 弹窗
	 */
	private String popupTa;
	/**
	 * 父级节点
	 */
	private String pid;
	/**
	 * 是否有子节点
	 */
	private String hasChild;

}
