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
@TableName("ces_order_goods")
public class CesOrderGoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
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
	 * 商品名字
	 */
	private String goodName;
	/**
	 * 价格
	 */
	private Double price;
	/**
	 * 数量
	 */
	private Integer num;
	/**
	 * 单品总价
	 */
	private Double zongPrice;
	/**
	 * 订单ID
	 */
	private String orderMainId;

}
