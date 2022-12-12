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
@TableName("onl_cgreport_item")
public class OnlCgreportItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 报表ID
	 */
	private String cgrheadId;
	/**
	 * 字段名字
	 */
	private String fieldName;
	/**
	 * 字段文本
	 */
	private String fieldTxt;
	/**
	 * 
	 */
	private Integer fieldWidth;
	/**
	 * 字段类型
	 */
	private String fieldType;
	/**
	 * 查询模式
	 */
	private String searchMode;
	/**
	 * 是否排序  0否,1是
	 */
	private Integer isOrder;
	/**
	 * 是否查询  0否,1是
	 */
	private Integer isSearch;
	/**
	 * 字典CODE
	 */
	private String dictCode;
	/**
	 * 字段跳转URL
	 */
	private String fieldHref;
	/**
	 * 是否显示  0否,1显示
	 */
	private Integer isShow;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 取值表达式
	 */
	private String replaceVal;
	/**
	 * 是否合计 0否,1是（仅对数值有效）
	 */
	private String isTotal;
	/**
	 * 分组标题
	 */
	private String groupTitle;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改人
	 */
	private String updateBy;
	/**
	 * 修改时间
	 */
	private Date updateTime;

}
