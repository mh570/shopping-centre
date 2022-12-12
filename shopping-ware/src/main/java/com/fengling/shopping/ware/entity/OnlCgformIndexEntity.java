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
@TableName("onl_cgform_index")
public class OnlCgformIndexEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 主表id
	 */
	private String cgformHeadId;
	/**
	 * 索引名称
	 */
	private String indexName;
	/**
	 * 索引栏位
	 */
	private String indexField;
	/**
	 * 索引类型
	 */
	private String indexType;
	/**
	 * 创建人登录名称
	 */
	private String createBy;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 更新人登录名称
	 */
	private String updateBy;
	/**
	 * 更新日期
	 */
	private Date updateTime;
	/**
	 * 是否同步数据库 N未同步 Y已同步
	 */
	private String isDbSynch;
	/**
	 * 是否删除 0未删除 1删除
	 */
	private Integer delFlag;

}
