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
@TableName("jimu_report_db")
public class JimuReportDbEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private String id;
	/**
	 * 主键字段
	 */
	private String jimuReportId;
	/**
	 * 创建人登录名称
	 */
	private String createBy;
	/**
	 * 更新人登录名称
	 */
	private String updateBy;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 更新日期
	 */
	private Date updateTime;
	/**
	 * 数据集编码
	 */
	private String dbCode;
	/**
	 * 数据集名字
	 */
	private String dbChName;
	/**
	 * 数据源类型
	 */
	private String dbType;
	/**
	 * 数据库表名
	 */
	private String dbTableName;
	/**
	 * 动态查询SQL
	 */
	private String dbDynSql;
	/**
	 * 数据源KEY
	 */
	private String dbKey;
	/**
	 * 填报数据源
	 */
	private String tbDbKey;
	/**
	 * 填报数据表
	 */
	private String tbDbTableName;
	/**
	 * java类数据集  类型（spring:springkey,class:java类名）
	 */
	private String javaType;
	/**
	 * java类数据源  数值（bean key/java类名）
	 */
	private String javaValue;
	/**
	 * 请求地址
	 */
	private String apiUrl;
	/**
	 * 请求方法0-get,1-post
	 */
	private String apiMethod;
	/**
	 * 是否是列表0否1是 默认0
	 */
	private String isList;
	/**
	 * 是否作为分页,0:不分页，1:分页
	 */
	private String isPage;
	/**
	 * 数据源
	 */
	private String dbSource;
	/**
	 * 数据库类型 MYSQL ORACLE SQLSERVER
	 */
	private String dbSourceType;
	/**
	 * json数据，直接解析json内容
	 */
	private String jsonData;
	/**
	 * api转换器
	 */
	private String apiConvert;

}
