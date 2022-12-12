<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="第三方登录id" prop="sysUserId">
      <el-input v-model="dataForm.sysUserId" placeholder="第三方登录id"></el-input>
    </el-form-item>
    <el-form-item label="头像" prop="avatar">
      <el-input v-model="dataForm.avatar" placeholder="头像"></el-input>
    </el-form-item>
    <el-form-item label="状态(1-正常,2-冻结)" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态(1-正常,2-冻结)"></el-input>
    </el-form-item>
    <el-form-item label="删除状态(0-正常,1-已删除)" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="删除状态(0-正常,1-已删除)"></el-input>
    </el-form-item>
    <el-form-item label="真实姓名" prop="realname">
      <el-input v-model="dataForm.realname" placeholder="真实姓名"></el-input>
    </el-form-item>
    <el-form-item label="第三方账号" prop="thirdUserUuid">
      <el-input v-model="dataForm.thirdUserUuid" placeholder="第三方账号"></el-input>
    </el-form-item>
    <el-form-item label="第三方app用户账号" prop="thirdUserId">
      <el-input v-model="dataForm.thirdUserId" placeholder="第三方app用户账号"></el-input>
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
    <el-form-item label="登录来源" prop="thirdType">
      <el-input v-model="dataForm.thirdType" placeholder="登录来源"></el-input>
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
          sysUserId: '',
          avatar: '',
          status: '',
          delFlag: '',
          realname: '',
          thirdUserUuid: '',
          thirdUserId: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          thirdType: ''
        },
        dataRule: {
          sysUserId: [
            { required: true, message: '第三方登录id不能为空', trigger: 'blur' }
          ],
          avatar: [
            { required: true, message: '头像不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态(1-正常,2-冻结)不能为空', trigger: 'blur' }
          ],
          delFlag: [
            { required: true, message: '删除状态(0-正常,1-已删除)不能为空', trigger: 'blur' }
          ],
          realname: [
            { required: true, message: '真实姓名不能为空', trigger: 'blur' }
          ],
          thirdUserUuid: [
            { required: true, message: '第三方账号不能为空', trigger: 'blur' }
          ],
          thirdUserId: [
            { required: true, message: '第三方app用户账号不能为空', trigger: 'blur' }
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
          ],
          thirdType: [
            { required: true, message: '登录来源不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/systhirdaccount/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.sysUserId = data.sysThirdAccount.sysUserId
                this.dataForm.avatar = data.sysThirdAccount.avatar
                this.dataForm.status = data.sysThirdAccount.status
                this.dataForm.delFlag = data.sysThirdAccount.delFlag
                this.dataForm.realname = data.sysThirdAccount.realname
                this.dataForm.thirdUserUuid = data.sysThirdAccount.thirdUserUuid
                this.dataForm.thirdUserId = data.sysThirdAccount.thirdUserId
                this.dataForm.createBy = data.sysThirdAccount.createBy
                this.dataForm.createTime = data.sysThirdAccount.createTime
                this.dataForm.updateBy = data.sysThirdAccount.updateBy
                this.dataForm.updateTime = data.sysThirdAccount.updateTime
                this.dataForm.thirdType = data.sysThirdAccount.thirdType
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
              url: this.$http.adornUrl(`/ware/systhirdaccount/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'sysUserId': this.dataForm.sysUserId,
                'avatar': this.dataForm.avatar,
                'status': this.dataForm.status,
                'delFlag': this.dataForm.delFlag,
                'realname': this.dataForm.realname,
                'thirdUserUuid': this.dataForm.thirdUserUuid,
                'thirdUserId': this.dataForm.thirdUserId,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'thirdType': this.dataForm.thirdType
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
