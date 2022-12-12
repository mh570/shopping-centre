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
@TableName("sys_dict_item")
public class SysDictItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 字典id
	 */
	private String dictId;
	/**
	 * 字典项文本
	 */
	private String itemText;
	/**
	 * 字典项值
	 */
	private String itemValue;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 排序
	 */
	private Integer sortOrder;
	/**
	 * 状态（1启用 0不启用）
	 */
	private Integer status;
	/**
	 * 
	 */
	private String createBy;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String updateBy;
	/**
	 * 
	 */
	private Date updateTime;

}
