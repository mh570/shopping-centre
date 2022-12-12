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
@TableName("jimu_report_data_source")
public class JimuReportDataSourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 数据源名称
	 */
	private String name;
	/**
	 * 报表_id
	 */
	private String reportId;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 数据库类型
	 */
	private String dbType;
	/**
	 * 驱动类
	 */
	private String dbDriver;
	/**
	 * 数据源地址
	 */
	private String dbUrl;
	/**
	 * 用户名
	 */
	private String dbUsername;
	/**
	 * 密码
	 */
	private String dbPassword;
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
	/**
	 * 连接失败次数
	 */
	private Integer connectTimes;
	/**
	 * 多租户标识
	 */
	private String tenantId;

}
