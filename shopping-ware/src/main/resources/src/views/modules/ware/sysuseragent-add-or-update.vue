<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户名" prop="userName">
      <el-input v-model="dataForm.userName" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="代理人用户名" prop="agentUserName">
      <el-input v-model="dataForm.agentUserName" placeholder="代理人用户名"></el-input>
    </el-form-item>
    <el-form-item label="代理开始时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="代理开始时间"></el-input>
    </el-form-item>
    <el-form-item label="代理结束时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="代理结束时间"></el-input>
    </el-form-item>
    <el-form-item label="状态0无效1有效" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态0无效1有效"></el-input>
    </el-form-item>
    <el-form-item label="创建人名称" prop="createName">
      <el-input v-model="dataForm.createName" placeholder="创建人名称"></el-input>
    </el-form-item>
    <el-form-item label="创建人登录名称" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人登录名称"></el-input>
    </el-form-item>
    <el-form-item label="创建日期" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建日期"></el-input>
    </el-form-item>
    <el-form-item label="更新人名称" prop="updateName">
      <el-input v-model="dataForm.updateName" placeholder="更新人名称"></el-input>
    </el-form-item>
    <el-form-item label="更新人登录名称" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人登录名称"></el-input>
    </el-form-item>
    <el-form-item label="更新日期" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新日期"></el-input>
    </el-form-item>
    <el-form-item label="所属部门" prop="sysOrgCode">
      <el-input v-model="dataForm.sysOrgCode" placeholder="所属部门"></el-input>
    </el-form-item>
    <el-form-item label="所属公司" prop="sysCompanyCode">
      <el-input v-model="dataForm.sysCompanyCode" placeholder="所属公司"></el-input>
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
          userName: '',
          agentUserName: '',
          startTime: '',
          endTime: '',
          status: '',
          createName: '',
          createBy: '',
          createTime: '',
          updateName: '',
          updateBy: '',
          updateTime: '',
          sysOrgCode: '',
          sysCompanyCode: ''
        },
        dataRule: {
          userName: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          agentUserName: [
            { required: true, message: '代理人用户名不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '代理开始时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '代理结束时间不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态0无效1有效不能为空', trigger: 'blur' }
          ],
          createName: [
            { required: true, message: '创建人名称不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人登录名称不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建日期不能为空', trigger: 'blur' }
          ],
          updateName: [
            { required: true, message: '更新人名称不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人登录名称不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新日期不能为空', trigger: 'blur' }
          ],
          sysOrgCode: [
            { required: true, message: '所属部门不能为空', trigger: 'blur' }
          ],
          sysCompanyCode: [
            { required: true, message: '所属公司不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysuseragent/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userName = data.sysUserAgent.userName
                this.dataForm.agentUserName = data.sysUserAgent.agentUserName
                this.dataForm.startTime = data.sysUserAgent.startTime
                this.dataForm.endTime = data.sysUserAgent.endTime
                this.dataForm.status = data.sysUserAgent.status
                this.dataForm.createName = data.sysUserAgent.createName
                this.dataForm.createBy = data.sysUserAgent.createBy
                this.dataForm.createTime = data.sysUserAgent.createTime
                this.dataForm.updateName = data.sysUserAgent.updateName
                this.dataForm.updateBy = data.sysUserAgent.updateBy
                this.dataForm.updateTime = data.sysUserAgent.updateTime
                this.dataForm.sysOrgCode = data.sysUserAgent.sysOrgCode
                this.dataForm.sysCompanyCode = data.sysUserAgent.sysCompanyCode
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
              url: this.$http.adornUrl(`/ware/sysuseragent/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userName': this.dataForm.userName,
                'agentUserName': this.dataForm.agentUserName,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime,
                'status': this.dataForm.status,
                'createName': this.dataForm.createName,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateName': this.dataForm.updateName,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'sysOrgCode': this.dataForm.sysOrgCode,
                'sysCompanyCode': this.dataForm.sysCompanyCode
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
