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
@TableName("onl_cgreport_head")
public class OnlCgreportHeadEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 报表编码
	 */
	private String code;
	/**
	 * 报表名字
	 */
	private String name;
	/**
	 * 报表SQL
	 */
	private String cgrSql;
	/**
	 * 返回值字段
	 */
	private String returnValField;
	/**
	 * 返回文本字段
	 */
	private String returnTxtField;
	/**
	 * 返回类型，单选或多选
	 */
	private String returnType;
	/**
	 * 动态数据源
	 */
	private String dbSource;
	/**
	 * 描述
	 */
	private String content;
	/**
	 * 关联的应用ID
	 */
	private String lowAppId;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 修改人id
	 */
	private String updateBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人id
	 */
	private String createBy;

}
