package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户通告阅读标记表
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:33
 */
@Data
@TableName("sys_announcement_send")
public class SysAnnouncementSendEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 通告ID
	 */
	private String anntId;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 阅读状态（0未读，1已读）
	 */
	private String readFlag;
	/**
	 * 阅读时间
	 */
	private Date readTime;
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
	 * 标星状态( 1为标星 空/0没有标星)
	 */
	private String starFlag;

}
