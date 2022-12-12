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
@TableName("onl_auth_data")
public class OnlAuthDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * online表ID
	 */
	private String cgformId;
	/**
	 * 规则名
	 */
	private String ruleName;
	/**
	 * 规则列
	 */
	private String ruleColumn;
	/**
	 * 规则条件 大于小于like
	 */
	private String ruleOperator;
	/**
	 * 规则值
	 */
	private String ruleValue;
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
