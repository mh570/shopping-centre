<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
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
    <el-form-item label="表名" prop="dataTable">
      <el-input v-model="dataForm.dataTable" placeholder="表名"></el-input>
    </el-form-item>
    <el-form-item label="数据ID" prop="dataId">
      <el-input v-model="dataForm.dataId" placeholder="数据ID"></el-input>
    </el-form-item>
    <el-form-item label="数据内容" prop="dataContent">
      <el-input v-model="dataForm.dataContent" placeholder="数据内容"></el-input>
    </el-form-item>
    <el-form-item label="版本号" prop="dataVersion">
      <el-input v-model="dataForm.dataVersion" placeholder="版本号"></el-input>
    </el-form-item>
    <el-form-item label="类型" prop="type">
      <el-input v-model="dataForm.type" placeholder="类型"></el-input>
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
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          dataTable: '',
          dataId: '',
          dataContent: '',
          dataVersion: '',
          type: ''
        },
        dataRule: {
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
          ],
          dataTable: [
            { required: true, message: '表名不能为空', trigger: 'blur' }
          ],
          dataId: [
            { required: true, message: '数据ID不能为空', trigger: 'blur' }
          ],
          dataContent: [
            { required: true, message: '数据内容不能为空', trigger: 'blur' }
          ],
          dataVersion: [
            { required: true, message: '版本号不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类型不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysdatalog/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.createBy = data.sysDataLog.createBy
                this.dataForm.createTime = data.sysDataLog.createTime
                this.dataForm.updateBy = data.sysDataLog.updateBy
                this.dataForm.updateTime = data.sysDataLog.updateTime
                this.dataForm.dataTable = data.sysDataLog.dataTable
                this.dataForm.dataId = data.sysDataLog.dataId
                this.dataForm.dataContent = data.sysDataLog.dataContent
                this.dataForm.dataVersion = data.sysDataLog.dataVersion
                this.dataForm.type = data.sysDataLog.type
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
              url: this.$http.adornUrl(`/ware/sysdatalog/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'dataTable': this.dataForm.dataTable,
                'dataId': this.dataForm.dataId,
                'dataContent': this.dataForm.dataContent,
                'dataVersion': this.dataForm.dataVersion,
                'type': this.dataForm.type
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
