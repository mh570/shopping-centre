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
@TableName("sys_sms")
public class SysSmsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private String id;
	/**
	 * 消息标题
	 */
	private String esTitle;
	/**
	 * 发送方式：参考枚举MessageTypeEnum
	 */
	private String esType;
	/**
	 * 接收人
	 */
	private String esReceiver;
	/**
	 * 发送所需参数Json格式
	 */
	private String esParam;
	/**
	 * 推送内容
	 */
	private String esContent;
	/**
	 * 推送时间
	 */
	private Date esSendTime;
	/**
	 * 推送状态 0未推送 1推送成功 2推送失败 -1失败不再发送
	 */
	private String esSendStatus;
	/**
	 * 发送次数 超过5次不再发送
	 */
	private Integer esSendNum;
	/**
	 * 推送失败原因
	 */
	private String esResult;
	/**
	 * 备注
	 */
	private String remark;
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

}
