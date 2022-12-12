package com.fengling.shopping.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ֧
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 20:52:37
 */
@Data
@TableName("oms_payment_info")
public class PaymentInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String orderSn;
	/**
	 * 
	 */
	private Long orderId;
	/**
	 * ֧
	 */
	private String alipayTradeNo;
	/**
	 * ֧
	 */
	private BigDecimal totalAmount;
	/**
	 * 
	 */
	private String subject;
	/**
	 * ֧
	 */
	private String paymentStatus;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * ȷ
	 */
	private Date confirmTime;
	/**
	 * 
	 */
	private String callbackContent;
	/**
	 * 
	 */
	private Date callbackTime;

}
