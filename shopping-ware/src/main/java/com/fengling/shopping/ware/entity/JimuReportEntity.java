package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 在线excel设计器
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("jimu_report")
public class JimuReportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 说明
	 */
	private String note;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * json字符串
	 */
	private String jsonStr;
	/**
	 * 请求地址
	 */
	private String apiUrl;
	/**
	 * 缩略图
	 */
	private String thumb;
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
	/**
	 * 删除标识0-正常,1-已删除
	 */
	private Integer delFlag;
	/**
	 * 请求方法0-get,1-post
	 */
	private String apiMethod;
	/**
	 * 请求编码
	 */
	private String apiCode;
	/**
	 * 是否是模板 0不是,1是
	 */
	private Integer template;
	/**
	 * 浏览次数
	 */
	private Long viewCount;
	/**
	 * css增强
	 */
	private String cssStr;
	/**
	 * js增强
	 */
	private String jsStr;
	/**
	 * 多租户标识
	 */
	private String tenantId;

}
