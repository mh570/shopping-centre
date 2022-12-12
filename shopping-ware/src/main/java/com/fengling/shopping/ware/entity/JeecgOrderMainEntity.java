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
@TableName("jeecg_order_main")
public class JeecgOrderMainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 订单号
	 */
	private String orderCode;
	/**
	 * 订单类型
	 */
	private String ctype;
	/**
	 * 订单日期
	 */
	private Date orderDate;
	/**
	 * 订单金额
	 */
	private Double orderMoney;
	/**
	 * 订单备注
	 */
	private String content;
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
	/**
	 * 流程状态
	 */
	private String bpmStatus;

}
