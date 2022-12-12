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
@TableName("sys_form_file")
public class SysFormFileEntity implements Serializable {
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
	 * 关联文件id
	 */
	private String fileId;
	/**
	 * 文件类型(text:文本, excel:excel doc:word ppt:ppt image:图片  archive:其他文档 video:视频 pdf:pdf）)
	 */
	private String fileType;
	/**
	 * 创建人登录名称
	 */
	private String createBy;
	/**
	 * 创建日期
	 */
	private Date createTime;

}
