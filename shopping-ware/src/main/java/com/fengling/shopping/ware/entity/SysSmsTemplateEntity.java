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
@TableName("sys_sms_template")
public class SysSmsTemplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 模板标题
	 */
	private String templateName;
	/**
	 * 模板CODE
	 */
	private String templateCode;
	/**
	 * 模板类型：1短信 2邮件 3微信
	 */
	private String templateType;
	/**
	 * 模板内容
	 */
	private String templateContent;
	/**
	 * 模板测试json
	 */
	private String templateTestJson;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 创建人登录名称
	 */
	private String createBy;
	/**
	 * 更新日期
	 */
	private Date updateTime;
	/**
	 * 更新人登录名称
	 */
	private String updateBy;
	/**
	 * 是否使用中 1是0否
	 */
	private String useStatus;

}
