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
@TableName("sys_third_account")
public class SysThirdAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	private String id;
	/**
	 * 第三方登录id
	 */
	private String sysUserId;
	/**
	 * 头像
	 */
	private String avatar;
	/**
	 * 状态(1-正常,2-冻结)
	 */
	private Integer status;
	/**
	 * 删除状态(0-正常,1-已删除)
	 */
	private Integer delFlag;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 第三方账号
	 */
	private String thirdUserUuid;
	/**
	 * 第三方app用户账号
	 */
	private String thirdUserId;
	/**
	 * 创建人登录名称
	 */
	private String createBy;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 更新人登录名称
	 */
	private String updateBy;
	/**
	 * 更新日期
	 */
	private Date updateTime;
	/**
	 * 登录来源
	 */
	private String thirdType;

}
