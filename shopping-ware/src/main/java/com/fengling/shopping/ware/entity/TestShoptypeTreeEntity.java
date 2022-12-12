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
@TableName("test_shoptype_tree")
public class TestShoptypeTreeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
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
	 * 商品分类
	 */
	private String typeName;
	/**
	 * 分类图片
	 */
	private String pic;
	/**
	 * 父级节点
	 */
	private String pid;
	/**
	 * 是否有子节点
	 */
	private String hasChild;

}
