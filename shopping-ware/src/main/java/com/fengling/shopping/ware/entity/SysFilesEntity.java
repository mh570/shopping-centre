package com.fengling.shopping.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 知识库-文档管理
 * 
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 22:19:34
 */
@Data
@TableName("sys_files")
public class SysFilesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private String id;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件地址
	 */
	private String url;
	/**
	 * 文档类型（folder:文件夹 excel:excel doc:word ppt:ppt image:图片  archive:其他文档 video:视频 pdf:pdf）
	 */
	private String fileType;
	/**
	 * 文件上传类型(temp/本地上传(临时文件) manage/知识库)
	 */
	private String storeType;
	/**
	 * 父级id
	 */
	private String parentId;
	/**
	 * 租户id
	 */
	private String tenantId;
	/**
	 * 文件大小（kb）
	 */
	private Double fileSize;
	/**
	 * 是否文件夹(1：是  0：否)
	 */
	private String izFolder;
	/**
	 * 是否为1级文件夹，允许为空 (1：是 )
	 */
	private String izRootFolder;
	/**
	 * 是否标星(1：是  0：否)
	 */
	private String izStar;
	/**
	 * 下载次数
	 */
	private Integer downCount;
	/**
	 * 阅读次数
	 */
	private Integer readCount;
	/**
	 * 分享链接
	 */
	private String shareUrl;
	/**
	 * 分享权限(1.关闭分享 2.允许所有联系人查看 3.允许任何人查看)
	 */
	private String sharePerms;
	/**
	 * 是否允许下载(1：是  0：否)
	 */
	private String enableDown;
	/**
	 * 是否允许修改(1：是  0：否)
	 */
	private String enableUpdat;
	/**
	 * 删除状态(0-正常,1-删除至回收站)
	 */
	private String delFlag;
	/**
	 * 创建人登录名称
	 */
	private String createBy;
	/**
	 * 创建日期
	 */
	private Date createTime;
	/**
	 * 更新人登录名称
	 */
	private String updateBy;
	/**
	 * 更新日期
	 */
	private Date updateTime;

}
