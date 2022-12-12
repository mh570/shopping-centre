<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="文件名称" prop="fileName">
      <el-input v-model="dataForm.fileName" placeholder="文件名称"></el-input>
    </el-form-item>
    <el-form-item label="文件地址" prop="url">
      <el-input v-model="dataForm.url" placeholder="文件地址"></el-input>
    </el-form-item>
    <el-form-item label="文档类型（folder:文件夹 excel:excel doc:word ppt:ppt image:图片  archive:其他文档 video:视频 pdf:pdf）" prop="fileType">
      <el-input v-model="dataForm.fileType" placeholder="文档类型（folder:文件夹 excel:excel doc:word ppt:ppt image:图片  archive:其他文档 video:视频 pdf:pdf）"></el-input>
    </el-form-item>
    <el-form-item label="文件上传类型(temp/本地上传(临时文件) manage/知识库)" prop="storeType">
      <el-input v-model="dataForm.storeType" placeholder="文件上传类型(temp/本地上传(临时文件) manage/知识库)"></el-input>
    </el-form-item>
    <el-form-item label="父级id" prop="parentId">
      <el-input v-model="dataForm.parentId" placeholder="父级id"></el-input>
    </el-form-item>
    <el-form-item label="租户id" prop="tenantId">
      <el-input v-model="dataForm.tenantId" placeholder="租户id"></el-input>
    </el-form-item>
    <el-form-item label="文件大小（kb）" prop="fileSize">
      <el-input v-model="dataForm.fileSize" placeholder="文件大小（kb）"></el-input>
    </el-form-item>
    <el-form-item label="是否文件夹(1：是  0：否)" prop="izFolder">
      <el-input v-model="dataForm.izFolder" placeholder="是否文件夹(1：是  0：否)"></el-input>
    </el-form-item>
    <el-form-item label="是否为1级文件夹，允许为空 (1：是 )" prop="izRootFolder">
      <el-input v-model="dataForm.izRootFolder" placeholder="是否为1级文件夹，允许为空 (1：是 )"></el-input>
    </el-form-item>
    <el-form-item label="是否标星(1：是  0：否)" prop="izStar">
      <el-input v-model="dataForm.izStar" placeholder="是否标星(1：是  0：否)"></el-input>
    </el-form-item>
    <el-form-item label="下载次数" prop="downCount">
      <el-input v-model="dataForm.downCount" placeholder="下载次数"></el-input>
    </el-form-item>
    <el-form-item label="阅读次数" prop="readCount">
      <el-input v-model="dataForm.readCount" placeholder="阅读次数"></el-input>
    </el-form-item>
    <el-form-item label="分享链接" prop="shareUrl">
      <el-input v-model="dataForm.shareUrl" placeholder="分享链接"></el-input>
    </el-form-item>
    <el-form-item label="分享权限(1.关闭分享 2.允许所有联系人查看 3.允许任何人查看)" prop="sharePerms">
      <el-input v-model="dataForm.sharePerms" placeholder="分享权限(1.关闭分享 2.允许所有联系人查看 3.允许任何人查看)"></el-input>
    </el-form-item>
    <el-form-item label="是否允许下载(1：是  0：否)" prop="enableDown">
      <el-input v-model="dataForm.enableDown" placeholder="是否允许下载(1：是  0：否)"></el-input>
    </el-form-item>
    <el-form-item label="是否允许修改(1：是  0：否)" prop="enableUpdat">
      <el-input v-model="dataForm.enableUpdat" placeholder="是否允许修改(1：是  0：否)"></el-input>
    </el-form-item>
    <el-form-item label="删除状态(0-正常,1-删除至回收站)" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="删除状态(0-正常,1-删除至回收站)"></el-input>
    </el-form-item>
    <el-form-item label="创建人登录名称" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人登录名称"></el-input>
    </el-form-item>
    <el-form-item label="创建日期" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建日期"></el-input>
    </el-form-item>
    <el-form-item label="更新人登录名称" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人登录名称"></el-input>
    </el-form-item>
    <el-form-item label="更新日期" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新日期"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          fileName: '',
          url: '',
          fileType: '',
          storeType: '',
          parentId: '',
          tenantId: '',
          fileSize: '',
          izFolder: '',
          izRootFolder: '',
          izStar: '',
          downCount: '',
          readCount: '',
          shareUrl: '',
          sharePerms: '',
          enableDown: '',
          enableUpdat: '',
          delFlag: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: ''
        },
        dataRule: {
          fileName: [
            { required: true, message: '文件名称不能为空', trigger: 'blur' }
          ],
          url: [
            { required: true, message: '文件地址不能为空', trigger: 'blur' }
          ],
          fileType: [
            { required: true, message: '文档类型（folder:文件夹 excel:excel doc:word ppt:ppt image:图片  archive:其他文档 video:视频 pdf:pdf）不能为空', trigger: 'blur' }
          ],
          storeType: [
            { required: true, message: '文件上传类型(temp/本地上传(临时文件) manage/知识库)不能为空', trigger: 'blur' }
          ],
          parentId: [
            { required: true, message: '父级id不能为空', trigger: 'blur' }
          ],
          tenantId: [
            { required: true, message: '租户id不能为空', trigger: 'blur' }
          ],
          fileSize: [
            { required: true, message: '文件大小（kb）不能为空', trigger: 'blur' }
          ],
          izFolder: [
            { required: true, message: '是否文件夹(1：是  0：否)不能为空', trigger: 'blur' }
          ],
          izRootFolder: [
            { required: true, message: '是否为1级文件夹，允许为空 (1：是 )不能为空', trigger: 'blur' }
          ],
          izStar: [
            { required: true, message: '是否标星(1：是  0：否)不能为空', trigger: 'blur' }
          ],
          downCount: [
            { required: true, message: '下载次数不能为空', trigger: 'blur' }
          ],
          readCount: [
            { required: true, message: '阅读次数不能为空', trigger: 'blur' }
          ],
          shareUrl: [
            { required: true, message: '分享链接不能为空', trigger: 'blur' }
          ],
          sharePerms: [
            { required: true, message: '分享权限(1.关闭分享 2.允许所有联系人查看 3.允许任何人查看)不能为空', trigger: 'blur' }
          ],
          enableDown: [
            { required: true, message: '是否允许下载(1：是  0：否)不能为空', trigger: 'blur' }
          ],
          enableUpdat: [
            { required: true, message: '是否允许修改(1：是  0：否)不能为空', trigger: 'blur' }
          ],
          delFlag: [
            { required: true, message: '删除状态(0-正常,1-删除至回收站)不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人登录名称不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建日期不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人登录名称不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新日期不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ware/sysfiles/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.fileName = data.sysFiles.fileName
                this.dataForm.url = data.sysFiles.url
                this.dataForm.fileType = data.sysFiles.fileType
                this.dataForm.storeType = data.sysFiles.storeType
                this.dataForm.parentId = data.sysFiles.parentId
                this.dataForm.tenantId = data.sysFiles.tenantId
                this.dataForm.fileSize = data.sysFiles.fileSize
                this.dataForm.izFolder = data.sysFiles.izFolder
                this.dataForm.izRootFolder = data.sysFiles.izRootFolder
                this.dataForm.izStar = data.sysFiles.izStar
                this.dataForm.downCount = data.sysFiles.downCount
                this.dataForm.readCount = data.sysFiles.readCount
                this.dataForm.shareUrl = data.sysFiles.shareUrl
                this.dataForm.sharePerms = data.sysFiles.sharePerms
                this.dataForm.enableDown = data.sysFiles.enableDown
                this.dataForm.enableUpdat = data.sysFiles.enableUpdat
                this.dataForm.delFlag = data.sysFiles.delFlag
                this.dataForm.createBy = data.sysFiles.createBy
                this.dataForm.createTime = data.sysFiles.createTime
                this.dataForm.updateBy = data.sysFiles.updateBy
                this.dataForm.updateTime = data.sysFiles.updateTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ware/sysfiles/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'fileName': this.dataForm.fileName,
                'url': this.dataForm.url,
                'fileType': this.dataForm.fileType,
                'storeType': this.dataForm.storeType,
                'parentId': this.dataForm.parentId,
                'tenantId': this.dataForm.tenantId,
                'fileSize': this.dataForm.fileSize,
                'izFolder': this.dataForm.izFolder,
                'izRootFolder': this.dataForm.izRootFolder,
                'izStar': this.dataForm.izStar,
                'downCount': this.dataForm.downCount,
                'readCount': this.dataForm.readCount,
                'shareUrl': this.dataForm.shareUrl,
                'sharePerms': this.dataForm.sharePerms,
                'enableDown': this.dataForm.enableDown,
                'enableUpdat': this.dataForm.enableUpdat,
                'delFlag': this.dataForm.delFlag,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
