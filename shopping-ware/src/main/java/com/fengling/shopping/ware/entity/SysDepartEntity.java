package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 组织机构表
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("sys_depart")
public class SysDepartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private String id;
	/**
	 * 父机构ID
	 */
	private String parentId;
	/**
	 * 机构/部门名称
	 */
	private String departName;
	/**
	 * 英文名
	 */
	private String departNameEn;
	/**
	 * 缩写
	 */
	private String departNameAbbr;
	/**
	 * 排序
	 */
	private Integer departOrder;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 机构类别 1公司，2组织机构，2岗位
	 */
	private String orgCategory;
	/**
	 * 机构类型 1一级部门 2子部门
	 */
	private String orgType;
	/**
	 * 机构编码
	 */
	private String orgCode;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 状态（1启用，0不启用）
	 */
	private String status;
	/**
	 * 删除状态（0，正常，1已删除）
	 */
	private String delFlag;
	/**
	 * 对接企业微信的ID
	 */
	private String qywxIdentifier;
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

}
