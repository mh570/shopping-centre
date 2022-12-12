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
@TableName("jimu_dict")
public class JimuDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 字典名称
	 */
	private String dictName;
	/**
	 * 字典编码
	 */
	private String dictCode;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 删除状态
	 */
	private Integer delFlag;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新人
	 */
	private String updateBy;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 字典类型0为string,1为number
	 */
	private Integer type;
	/**
	 * 多租户标识
	 */
	private String tenantId;

}
