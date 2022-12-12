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
@TableName("onl_auth_page")
public class OnlAuthPageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *  主键
	 */
	@TableId
	private String id;
	/**
	 * online表id
	 */
	private String cgformId;
	/**
	 * 字段名/按钮编码
	 */
	private String code;
	/**
	 * 1字段 2按钮
	 */
	private Integer type;
	/**
	 * 3可编辑 5可见(仅支持两种状态值3,5)
	 */
	private Integer control;
	/**
	 * 3列表 5表单(仅支持两种状态值3,5)
	 */
	private Integer page;
	/**
	 * 1有效 0无效
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 更新人
	 */
	private String updateBy;
	/**
	 * 更新日期
	 */
	private Date updateTime;

}
