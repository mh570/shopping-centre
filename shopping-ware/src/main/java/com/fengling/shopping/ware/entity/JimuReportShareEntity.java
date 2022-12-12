package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 积木报表预览权限表
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("jimu_report_share")
public class JimuReportShareEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 在线excel设计器id
	 */
	private String reportId;
	/**
	 * 预览地址
	 */
	private String previewUrl;
	/**
	 * 密码锁
	 */
	private String previewLock;
	/**
	 * 最后更新时间
	 */
	private Date lastUpdateTime;
	/**
	 * 有效期(0:永久有效，1:1天，2:7天)
	 */
	private String termOfValidity;
	/**
	 * 是否过期(0未过期，1已过期)
	 */
	private String status;
	/**
	 * 是否为密码锁(0 否,1是)
	 */
	private String previewLockStatus;

}
