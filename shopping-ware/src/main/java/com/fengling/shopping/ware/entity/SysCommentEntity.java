package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统评论回复表
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("sys_comment")
public class SysCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 数据id
	 */
	private String tableDataId;
	/**
	 * 来源用户id
	 */
	private String fromUserId;
	/**
	 * 发送给用户id(允许为空)
	 */
	private String toUserId;
	/**
	 * 评论id(允许为空，不为空时，则为回复)
	 */
	private String commentId;
	/**
	 * 回复内容
	 */
	private String commentContent;
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

}
