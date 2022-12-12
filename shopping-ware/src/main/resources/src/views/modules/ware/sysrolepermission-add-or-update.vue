<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="角色id" prop="roleId">
      <el-input v-model="dataForm.roleId" placeholder="角色id"></el-input>
    </el-form-item>
    <el-form-item label="权限id" prop="permissionId">
      <el-input v-model="dataForm.permissionId" placeholder="权限id"></el-input>
    </el-form-item>
    <el-form-item label="数据权限ids" prop="dataRuleIds">
      <el-input v-model="dataForm.dataRuleIds" placeholder="数据权限ids"></el-input>
    </el-form-item>
    <el-form-item label="操作时间" prop="operateDate">
      <el-input v-model="dataForm.operateDate" placeholder="操作时间"></el-input>
    </el-form-item>
    <el-form-item label="操作ip" prop="operateIp">
      <el-input v-model="dataForm.operateIp" placeholder="操作ip"></el-input>
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
          roleId: '',
          permissionId: '',
          dataRuleIds: '',
          operateDate: '',
          operateIp: ''
        },
        dataRule: {
          roleId: [
            { required: true, message: '角色id不能为空', trigger: 'blur' }
          ],
          permissionId: [
            { required: true, message: '权限id不能为空', trigger: 'blur' }
          ],
          dataRuleIds: [
            { required: true, message: '数据权限ids不能为空', trigger: 'blur' }
          ],
          operateDate: [
            { required: true, message: '操作时间不能为空', trigger: 'blur' }
          ],
          operateIp: [
            { required: true, message: '操作ip不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysrolepermission/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.roleId = data.sysRolePermission.roleId
                this.dataForm.permissionId = data.sysRolePermission.permissionId
                this.dataForm.dataRuleIds = data.sysRolePermission.dataRuleIds
                this.dataForm.operateDate = data.sysRolePermission.operateDate
                this.dataForm.operateIp = data.sysRolePermission.operateIp
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
              url: this.$http.adornUrl(`/ware/sysrolepermission/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'roleId': this.dataForm.roleId,
                'permissionId': this.dataForm.permissionId,
                'dataRuleIds': this.dataForm.dataRuleIds,
                'operateDate': this.dataForm.operateDate,
                'operateIp': this.dataForm.operateIp
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
