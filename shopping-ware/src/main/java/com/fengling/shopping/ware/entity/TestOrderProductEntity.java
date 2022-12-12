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
@TableName("test_order_product")
public class TestOrderProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
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
	 * 产品名字
	 */
	private String productName;
	/**
	 * 价格
	 */
	private Double price;
	/**
	 * 数量
	 */
	private Integer num;
	/**
	 * 描述
	 */
	private String descc;
	/**
	 * 订单外键ID
	 */
	private String orderFkId;
	/**
	 * 产品类型
	 */
	private String proType;

}
