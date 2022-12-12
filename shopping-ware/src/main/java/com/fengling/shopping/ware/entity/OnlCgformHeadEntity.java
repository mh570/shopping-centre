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
@TableName("onl_cgform_head")
public class OnlCgformHeadEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId
	private String id;
	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 表类型: 0单表、1主表、2附表
	 */
	private Integer tableType;
	/**
	 * 表版本
	 */
	private Integer tableVersion;
	/**
	 * 表说明
	 */
	private String tableTxt;
	/**
	 * 是否带checkbox
	 */
	private String isCheckbox;
	/**
	 * 同步数据库状态
	 */
	private String isDbSynch;
	/**
	 * 是否分页
	 */
	private String isPage;
	/**
	 * 是否是树
	 */
	private String isTree;
	/**
	 * 主键生成序列
	 */
	private String idSequence;
	/**
	 * 主键类型
	 */
	private String idType;
	/**
	 * 查询模式
	 */
	private String queryMode;
	/**
	 * 映射关系 0一对多  1一对一
	 */
	private Integer relationType;
	/**
	 * 子表
	 */
	private String subTableStr;
	/**
	 * 附表排序序号
	 */
	private Integer tabOrderNum;
	/**
	 * 树形表单父id
	 */
	private String treeParentIdField;
	/**
	 * 树表主键字段
	 */
	private String treeIdField;
	/**
	 * 树开表单列字段
	 */
	private String treeFieldname;
	/**
	 * 表单分类
	 */
	private String formCategory;
	/**
	 * PC表单模板
	 */
	private String formTemplate;
	/**
	 * 表单模板样式(移动端)
	 */
	private String formTemplateMobile;
	/**
	 * 是否有横向滚动条
	 */
	private Integer scroll;
	/**
	 * 复制版本号
	 */
	private Integer copyVersion;
	/**
	 * 复制表类型1为复制表 0为原始表
	 */
	private Integer copyType;
	/**
	 * 原始表ID
	 */
	private String physicId;
	/**
	 * 扩展JSON
	 */
	private String extConfigJson;
	/**
	 * 修改人
	 */
	private String updateBy;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 主题模板
	 */
	private String themeTemplate;
	/**
	 * 是否用设计器表单
	 */
	private String isDesForm;
	/**
	 * 设计器表单编码
	 */
	private String desFormCode;
	/**
	 * 关联的应用ID
	 */
	private String lowAppId;

}
