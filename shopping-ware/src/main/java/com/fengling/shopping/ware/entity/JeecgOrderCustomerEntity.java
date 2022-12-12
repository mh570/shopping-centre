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
@TableName("jeecg_order_customer")
public class JeecgOrderCustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 客户名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 身份证号码
	 */
	private String idcard;
	/**
	 * 身份证扫描件
	 */
	private String idcardPic;
	/**
	 * 电话1
	 */
	private String telphone;
	/**
	 * 外键
	 */
	private String orderId;
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
