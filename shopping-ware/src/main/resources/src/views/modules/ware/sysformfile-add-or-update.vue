<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="表名" prop="tableName">
      <el-input v-model="dataForm.tableName" placeholder="表名"></el-input>
    </el-form-item>
    <el-form-item label="数据id" prop="tableDataId">
      <el-input v-model="dataForm.tableDataId" placeholder="数据id"></el-input>
    </el-form-item>
    <el-form-item label="关联文件id" prop="fileId">
      <el-input v-model="dataForm.fileId" placeholder="关联文件id"></el-input>
    </el-form-item>
    <el-form-item label="文件类型(text:文本, excel:excel doc:word ppt:ppt image:图片  archive:其他文档 video:视频 pdf:pdf）)" prop="fileType">
      <el-input v-model="dataForm.fileType" placeholder="文件类型(text:文本, excel:excel doc:word ppt:ppt image:图片  archive:其他文档 video:视频 pdf:pdf）)"></el-input>
    </el-form-item>
    <el-form-item label="创建人登录名称" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人登录名称"></el-input>
    </el-form-item>
    <el-form-item label="创建日期" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建日期"></el-input>
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
          tableName: '',
          tableDataId: '',
          fileId: '',
          fileType: '',
          createBy: '',
          createTime: ''
        },
        dataRule: {
          tableName: [
            { required: true, message: '表名不能为空', trigger: 'blur' }
          ],
          tableDataId: [
            { required: true, message: '数据id不能为空', trigger: 'blur' }
          ],
          fileId: [
            { required: true, message: '关联文件id不能为空', trigger: 'blur' }
          ],
          fileType: [
            { required: true, message: '文件类型(text:文本, excel:excel doc:word ppt:ppt image:图片  archive:其他文档 video:视频 pdf:pdf）)不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人登录名称不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysformfile/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tableName = data.sysFormFile.tableName
                this.dataForm.tableDataId = data.sysFormFile.tableDataId
                this.dataForm.fileId = data.sysFormFile.fileId
                this.dataForm.fileType = data.sysFormFile.fileType
                this.dataForm.createBy = data.sysFormFile.createBy
                this.dataForm.createTime = data.sysFormFile.createTime
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
              url: this.$http.adornUrl(`/ware/sysformfile/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'tableName': this.dataForm.tableName,
                'tableDataId': this.dataForm.tableDataId,
                'fileId': this.dataForm.fileId,
                'fileType': this.dataForm.fileType,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime
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
