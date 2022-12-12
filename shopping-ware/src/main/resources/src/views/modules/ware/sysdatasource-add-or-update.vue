<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="数据源编码" prop="code">
      <el-input v-model="dataForm.code" placeholder="数据源编码"></el-input>
    </el-form-item>
    <el-form-item label="数据源名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="数据源名称"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="数据库类型" prop="dbType">
      <el-input v-model="dataForm.dbType" placeholder="数据库类型"></el-input>
    </el-form-item>
    <el-form-item label="驱动类" prop="dbDriver">
      <el-input v-model="dataForm.dbDriver" placeholder="驱动类"></el-input>
    </el-form-item>
    <el-form-item label="数据源地址" prop="dbUrl">
      <el-input v-model="dataForm.dbUrl" placeholder="数据源地址"></el-input>
    </el-form-item>
    <el-form-item label="数据库名称" prop="dbName">
      <el-input v-model="dataForm.dbName" placeholder="数据库名称"></el-input>
    </el-form-item>
    <el-form-item label="用户名" prop="dbUsername">
      <el-input v-model="dataForm.dbUsername" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="dbPassword">
      <el-input v-model="dataForm.dbPassword" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="创建日期" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建日期"></el-input>
    </el-form-item>
    <el-form-item label="更新人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人"></el-input>
    </el-form-item>
    <el-form-item label="更新日期" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新日期"></el-input>
    </el-form-item>
    <el-form-item label="所属部门" prop="sysOrgCode">
      <el-input v-model="dataForm.sysOrgCode" placeholder="所属部门"></el-input>
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
          code: '',
          name: '',
          remark: '',
          dbType: '',
          dbDriver: '',
          dbUrl: '',
          dbName: '',
          dbUsername: '',
          dbPassword: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          sysOrgCode: ''
        },
        dataRule: {
          code: [
            { required: true, message: '数据源编码不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '数据源名称不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          dbType: [
            { required: true, message: '数据库类型不能为空', trigger: 'blur' }
          ],
          dbDriver: [
            { required: true, message: '驱动类不能为空', trigger: 'blur' }
          ],
          dbUrl: [
            { required: true, message: '数据源地址不能为空', trigger: 'blur' }
          ],
          dbName: [
            { required: true, message: '数据库名称不能为空', trigger: 'blur' }
          ],
          dbUsername: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          dbPassword: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建日期不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新日期不能为空', trigger: 'blur' }
          ],
          sysOrgCode: [
            { required: true, message: '所属部门不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysdatasource/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.code = data.sysDataSource.code
                this.dataForm.name = data.sysDataSource.name
                this.dataForm.remark = data.sysDataSource.remark
                this.dataForm.dbType = data.sysDataSource.dbType
                this.dataForm.dbDriver = data.sysDataSource.dbDriver
                this.dataForm.dbUrl = data.sysDataSource.dbUrl
                this.dataForm.dbName = data.sysDataSource.dbName
                this.dataForm.dbUsername = data.sysDataSource.dbUsername
                this.dataForm.dbPassword = data.sysDataSource.dbPassword
                this.dataForm.createBy = data.sysDataSource.createBy
                this.dataForm.createTime = data.sysDataSource.createTime
                this.dataForm.updateBy = data.sysDataSource.updateBy
                this.dataForm.updateTime = data.sysDataSource.updateTime
                this.dataForm.sysOrgCode = data.sysDataSource.sysOrgCode
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
              url: this.$http.adornUrl(`/ware/sysdatasource/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'code': this.dataForm.code,
                'name': this.dataForm.name,
                'remark': this.dataForm.remark,
                'dbType': this.dataForm.dbType,
                'dbDriver': this.dataForm.dbDriver,
                'dbUrl': this.dataForm.dbUrl,
                'dbName': this.dataForm.dbName,
                'dbUsername': this.dataForm.dbUsername,
                'dbPassword': this.dataForm.dbPassword,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'sysOrgCode': this.dataForm.sysOrgCode
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
