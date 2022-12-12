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
@TableName("onl_cgform_field")
public class OnlCgformFieldEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private String id;
	/**
	 * 表ID
	 */
	private String cgformHeadId;
	/**
	 * 字段名字
	 */
	private String dbFieldName;
	/**
	 * 字段备注
	 */
	private String dbFieldTxt;
	/**
	 * 原字段名
	 */
	private String dbFieldNameOld;
	/**
	 * 是否主键 0否 1是
	 */
	private Integer dbIsKey;
	/**
	 * 是否允许为空0否 1是
	 */
	private Integer dbIsNull;
	/**
	 * 是否需要同步数据库字段， 1是0否
	 */
	private Integer dbIsPersist;
	/**
	 * 数据库字段类型
	 */
	private String dbType;
	/**
	 * 数据库字段长度
	 */
	private Integer dbLength;
	/**
	 * 小数点
	 */
	private Integer dbPointLength;
	/**
	 * 表字段默认值
	 */
	private String dbDefaultVal;
	/**
	 * 字典code
	 */
	private String dictField;
	/**
	 * 字典表
	 */
	private String dictTable;
	/**
	 * 字典Text
	 */
	private String dictText;
	/**
	 * 表单控件类型
	 */
	private String fieldShowType;
	/**
	 * 跳转URL
	 */
	private String fieldHref;
	/**
	 * 表单控件长度
	 */
	private Integer fieldLength;
	/**
	 * 表单字段校验规则
	 */
	private String fieldValidType;
	/**
	 * 字段是否必填
	 */
	private String fieldMustInput;
	/**
	 * 扩展参数JSON
	 */
	private String fieldExtendJson;
	/**
	 * 控件默认值，不同的表达式展示不同的结果。
1. 纯字符串直接赋给默认值；
2. #{普通变量}；
3. {{ 动态JS表达式 }}；
4. ${填值规则编码}；
填值规则表达式只允许存在一个，且不能和其他规则混用。
	 */
	private String fieldDefaultValue;
	/**
	 * 是否查询条件0否 1是
	 */
	private Integer isQuery;
	/**
	 * 表单是否显示0否 1是
	 */
	private Integer isShowForm;
	/**
	 * 列表是否显示0否 1是
	 */
	private Integer isShowList;
	/**
	 * 是否是只读（1是 0否）
	 */
	private Integer isReadOnly;
	/**
	 * 查询模式
	 */
	private String queryMode;
	/**
	 * 外键主表名
	 */
	private String mainTable;
	/**
	 * 外键主键字段
	 */
	private String mainField;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 修改人
	 */
	private String updateBy;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 自定义值转换器
	 */
	private String converter;
	/**
	 * 查询默认值
	 */
	private String queryDefVal;
	/**
	 * 查询配置字典text
	 */
	private String queryDictText;
	/**
	 * 查询配置字典code
	 */
	private String queryDictField;
	/**
	 * 查询配置字典table
	 */
	private String queryDictTable;
	/**
	 * 查询显示控件
	 */
	private String queryShowType;
	/**
	 * 是否启用查询配置1是0否
	 */
	private String queryConfigFlag;
	/**
	 * 查询字段校验类型
	 */
	private String queryValidType;
	/**
	 * 查询字段是否必填1是0否
	 */
	private String queryMustInput;
	/**
	 * 是否支持排序1是0否
	 */
	private String sortFlag;

}
