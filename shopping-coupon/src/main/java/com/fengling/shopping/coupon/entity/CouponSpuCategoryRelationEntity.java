package com.fengling.shopping.coupon.entity;

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
 * @date 2022-12-12 22:27:14
 */
@Data
@TableName("sms_coupon_spu_category_relation")
public class CouponSpuCategoryRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long couponId;
	/**
	 * 
	 */
	private Long categoryId;
	/**
	 * 
	 */
	private String categoryName;

}
