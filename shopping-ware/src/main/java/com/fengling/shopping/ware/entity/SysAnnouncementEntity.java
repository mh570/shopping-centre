package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统通告表
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@Data
@TableName("sys_announcement")
public class SysAnnouncementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 标题
	 */
	private String titile;
	/**
	 * 内容
	 */
	private String msgContent;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 发布人
	 */
	private String sender;
	/**
	 * 优先级（L低，M中，H高）
	 */
	private String priority;
	/**
	 * 消息类型1:通知公告2:系统消息
	 */
	private String msgCategory;
	/**
	 * 通告对象类型（USER:指定用户，ALL:全体用户）
	 */
	private String msgType;
	/**
	 * 发布状态（0未发布，1已发布，2已撤销）
	 */
	private String sendStatus;
	/**
	 * 发布时间
	 */
	private Date sendTime;
	/**
	 * 撤销时间
	 */
	private Date cancelTime;
	/**
	 * 删除状态（0，正常，1已删除）
	 */
	private String delFlag;
	/**
	 * 业务类型(email:邮件 bpm:流程)
	 */
	private String busType;
	/**
	 * 业务id
	 */
	private String busId;
	/**
	 * 打开方式(组件：component 路由：url)
	 */
	private String openType;
	/**
	 * 组件/路由 地址
	 */
	private String openPage;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新人
	 */
	private String updateBy;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 指定用户
	 */
	private String userIds;
	/**
	 * 摘要
	 */
	private String msgAbstract;
	/**
	 * 钉钉task_id，用于撤回消息
	 */
	private String dtTaskId;

}
