<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="角色id" prop="roleId">
      <el-input v-model="dataForm.roleId" placeholder="角色id"></el-input>
    </el-form-item>
    <el-form-item label="权限id" prop="authId">
      <el-input v-model="dataForm.authId" placeholder="权限id"></el-input>
    </el-form-item>
    <el-form-item label="1字段 2按钮 3数据权限" prop="type">
      <el-input v-model="dataForm.type" placeholder="1字段 2按钮 3数据权限"></el-input>
    </el-form-item>
    <el-form-item label="online表单ID" prop="cgformId">
      <el-input v-model="dataForm.cgformId" placeholder="online表单ID"></el-input>
    </el-form-item>
    <el-form-item label="授权方式role角色，depart部门，user人" prop="authMode">
      <el-input v-model="dataForm.authMode" placeholder="授权方式role角色，depart部门，user人"></el-input>
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
          authId: '',
          type: '',
          cgformId: '',
          authMode: ''
        },
        dataRule: {
          roleId: [
            { required: true, message: '角色id不能为空', trigger: 'blur' }
          ],
          authId: [
            { required: true, message: '权限id不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '1字段 2按钮 3数据权限不能为空', trigger: 'blur' }
          ],
          cgformId: [
            { required: true, message: 'online表单ID不能为空', trigger: 'blur' }
          ],
          authMode: [
            { required: true, message: '授权方式role角色，depart部门，user人不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/onlauthrelation/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.roleId = data.onlAuthRelation.roleId
                this.dataForm.authId = data.onlAuthRelation.authId
                this.dataForm.type = data.onlAuthRelation.type
                this.dataForm.cgformId = data.onlAuthRelation.cgformId
                this.dataForm.authMode = data.onlAuthRelation.authMode
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
              url: this.$http.adornUrl(`/ware/onlauthrelation/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'roleId': this.dataForm.roleId,
                'authId': this.dataForm.authId,
                'type': this.dataForm.type,
                'cgformId': this.dataForm.cgformId,
                'authMode': this.dataForm.authMode
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
