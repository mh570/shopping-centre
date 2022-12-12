<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="菜单ID" prop="permissionId">
      <el-input v-model="dataForm.permissionId" placeholder="菜单ID"></el-input>
    </el-form-item>
    <el-form-item label="规则名称" prop="ruleName">
      <el-input v-model="dataForm.ruleName" placeholder="规则名称"></el-input>
    </el-form-item>
    <el-form-item label="字段" prop="ruleColumn">
      <el-input v-model="dataForm.ruleColumn" placeholder="字段"></el-input>
    </el-form-item>
    <el-form-item label="条件" prop="ruleConditions">
      <el-input v-model="dataForm.ruleConditions" placeholder="条件"></el-input>
    </el-form-item>
    <el-form-item label="规则值" prop="ruleValue">
      <el-input v-model="dataForm.ruleValue" placeholder="规则值"></el-input>
    </el-form-item>
    <el-form-item label="权限有效状态1有0否" prop="status">
      <el-input v-model="dataForm.status" placeholder="权限有效状态1有0否"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="修改人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="修改人"></el-input>
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
          permissionId: '',
          ruleName: '',
          ruleColumn: '',
          ruleConditions: '',
          ruleValue: '',
          status: '',
          createTime: '',
          createBy: '',
          updateTime: '',
          updateBy: ''
        },
        dataRule: {
          permissionId: [
            { required: true, message: '菜单ID不能为空', trigger: 'blur' }
          ],
          ruleName: [
            { required: true, message: '规则名称不能为空', trigger: 'blur' }
          ],
          ruleColumn: [
            { required: true, message: '字段不能为空', trigger: 'blur' }
          ],
          ruleConditions: [
            { required: true, message: '条件不能为空', trigger: 'blur' }
          ],
          ruleValue: [
            { required: true, message: '规则值不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '权限有效状态1有0否不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '修改人不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/syspermissiondatarule/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.permissionId = data.sysPermissionDataRule.permissionId
                this.dataForm.ruleName = data.sysPermissionDataRule.ruleName
                this.dataForm.ruleColumn = data.sysPermissionDataRule.ruleColumn
                this.dataForm.ruleConditions = data.sysPermissionDataRule.ruleConditions
                this.dataForm.ruleValue = data.sysPermissionDataRule.ruleValue
                this.dataForm.status = data.sysPermissionDataRule.status
                this.dataForm.createTime = data.sysPermissionDataRule.createTime
                this.dataForm.createBy = data.sysPermissionDataRule.createBy
                this.dataForm.updateTime = data.sysPermissionDataRule.updateTime
                this.dataForm.updateBy = data.sysPermissionDataRule.updateBy
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
              url: this.$http.adornUrl(`/ware/syspermissiondatarule/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'permissionId': this.dataForm.permissionId,
                'ruleName': this.dataForm.ruleName,
                'ruleColumn': this.dataForm.ruleColumn,
                'ruleConditions': this.dataForm.ruleConditions,
                'ruleValue': this.dataForm.ruleValue,
                'status': this.dataForm.status,
                'createTime': this.dataForm.createTime,
                'createBy': this.dataForm.createBy,
                'updateTime': this.dataForm.updateTime,
                'updateBy': this.dataForm.updateBy
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
