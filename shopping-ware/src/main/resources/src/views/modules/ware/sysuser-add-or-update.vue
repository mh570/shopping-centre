<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="登录账号" prop="username">
      <el-input v-model="dataForm.username" placeholder="登录账号"></el-input>
    </el-form-item>
    <el-form-item label="真实姓名" prop="realname">
      <el-input v-model="dataForm.realname" placeholder="真实姓名"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="dataForm.password" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="md5密码盐" prop="salt">
      <el-input v-model="dataForm.salt" placeholder="md5密码盐"></el-input>
    </el-form-item>
    <el-form-item label="头像" prop="avatar">
      <el-input v-model="dataForm.avatar" placeholder="头像"></el-input>
    </el-form-item>
    <el-form-item label="生日" prop="birthday">
      <el-input v-model="dataForm.birthday" placeholder="生日"></el-input>
    </el-form-item>
    <el-form-item label="性别(0-默认未知,1-男,2-女)" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别(0-默认未知,1-男,2-女)"></el-input>
    </el-form-item>
    <el-form-item label="电子邮件" prop="email">
      <el-input v-model="dataForm.email" placeholder="电子邮件"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="电话"></el-input>
    </el-form-item>
    <el-form-item label="登录会话的机构编码" prop="orgCode">
      <el-input v-model="dataForm.orgCode" placeholder="登录会话的机构编码"></el-input>
    </el-form-item>
    <el-form-item label="性别(1-正常,2-冻结)" prop="status">
      <el-input v-model="dataForm.status" placeholder="性别(1-正常,2-冻结)"></el-input>
    </el-form-item>
    <el-form-item label="删除状态(0-正常,1-已删除)" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="删除状态(0-正常,1-已删除)"></el-input>
    </el-form-item>
    <el-form-item label="第三方登录的唯一标识" prop="thirdId">
      <el-input v-model="dataForm.thirdId" placeholder="第三方登录的唯一标识"></el-input>
    </el-form-item>
    <el-form-item label="第三方类型" prop="thirdType">
      <el-input v-model="dataForm.thirdType" placeholder="第三方类型"></el-input>
    </el-form-item>
    <el-form-item label="同步工作流引擎(1-同步,0-不同步)" prop="activitiSync">
      <el-input v-model="dataForm.activitiSync" placeholder="同步工作流引擎(1-同步,0-不同步)"></el-input>
    </el-form-item>
    <el-form-item label="工号，唯一键" prop="workNo">
      <el-input v-model="dataForm.workNo" placeholder="工号，唯一键"></el-input>
    </el-form-item>
    <el-form-item label="职务，关联职务表" prop="post">
      <el-input v-model="dataForm.post" placeholder="职务，关联职务表"></el-input>
    </el-form-item>
    <el-form-item label="座机号" prop="telephone">
      <el-input v-model="dataForm.telephone" placeholder="座机号"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="身份（1普通成员 2上级）" prop="userIdentity">
      <el-input v-model="dataForm.userIdentity" placeholder="身份（1普通成员 2上级）"></el-input>
    </el-form-item>
    <el-form-item label="负责部门" prop="departIds">
      <el-input v-model="dataForm.departIds" placeholder="负责部门"></el-input>
    </el-form-item>
    <el-form-item label="多租户标识" prop="relTenantIds">
      <el-input v-model="dataForm.relTenantIds" placeholder="多租户标识"></el-input>
    </el-form-item>
    <el-form-item label="设备ID" prop="clientId">
      <el-input v-model="dataForm.clientId" placeholder="设备ID"></el-input>
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
          username: '',
          realname: '',
          password: '',
          salt: '',
          avatar: '',
          birthday: '',
          sex: '',
          email: '',
          phone: '',
          orgCode: '',
          status: '',
          delFlag: '',
          thirdId: '',
          thirdType: '',
          activitiSync: '',
          workNo: '',
          post: '',
          telephone: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          userIdentity: '',
          departIds: '',
          relTenantIds: '',
          clientId: ''
        },
        dataRule: {
          username: [
            { required: true, message: '登录账号不能为空', trigger: 'blur' }
          ],
          realname: [
            { required: true, message: '真实姓名不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          salt: [
            { required: true, message: 'md5密码盐不能为空', trigger: 'blur' }
          ],
          avatar: [
            { required: true, message: '头像不能为空', trigger: 'blur' }
          ],
          birthday: [
            { required: true, message: '生日不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别(0-默认未知,1-男,2-女)不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '电子邮件不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '电话不能为空', trigger: 'blur' }
          ],
          orgCode: [
            { required: true, message: '登录会话的机构编码不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '性别(1-正常,2-冻结)不能为空', trigger: 'blur' }
          ],
          delFlag: [
            { required: true, message: '删除状态(0-正常,1-已删除)不能为空', trigger: 'blur' }
          ],
          thirdId: [
            { required: true, message: '第三方登录的唯一标识不能为空', trigger: 'blur' }
          ],
          thirdType: [
            { required: true, message: '第三方类型不能为空', trigger: 'blur' }
          ],
          activitiSync: [
            { required: true, message: '同步工作流引擎(1-同步,0-不同步)不能为空', trigger: 'blur' }
          ],
          workNo: [
            { required: true, message: '工号，唯一键不能为空', trigger: 'blur' }
          ],
          post: [
            { required: true, message: '职务，关联职务表不能为空', trigger: 'blur' }
          ],
          telephone: [
            { required: true, message: '座机号不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          userIdentity: [
            { required: true, message: '身份（1普通成员 2上级）不能为空', trigger: 'blur' }
          ],
          departIds: [
            { required: true, message: '负责部门不能为空', trigger: 'blur' }
          ],
          relTenantIds: [
            { required: true, message: '多租户标识不能为空', trigger: 'blur' }
          ],
          clientId: [
            { required: true, message: '设备ID不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysuser/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.username = data.sysUser.username
                this.dataForm.realname = data.sysUser.realname
                this.dataForm.password = data.sysUser.password
                this.dataForm.salt = data.sysUser.salt
                this.dataForm.avatar = data.sysUser.avatar
                this.dataForm.birthday = data.sysUser.birthday
                this.dataForm.sex = data.sysUser.sex
                this.dataForm.email = data.sysUser.email
                this.dataForm.phone = data.sysUser.phone
                this.dataForm.orgCode = data.sysUser.orgCode
                this.dataForm.status = data.sysUser.status
                this.dataForm.delFlag = data.sysUser.delFlag
                this.dataForm.thirdId = data.sysUser.thirdId
                this.dataForm.thirdType = data.sysUser.thirdType
                this.dataForm.activitiSync = data.sysUser.activitiSync
                this.dataForm.workNo = data.sysUser.workNo
                this.dataForm.post = data.sysUser.post
                this.dataForm.telephone = data.sysUser.telephone
                this.dataForm.createBy = data.sysUser.createBy
                this.dataForm.createTime = data.sysUser.createTime
                this.dataForm.updateBy = data.sysUser.updateBy
                this.dataForm.updateTime = data.sysUser.updateTime
                this.dataForm.userIdentity = data.sysUser.userIdentity
                this.dataForm.departIds = data.sysUser.departIds
                this.dataForm.relTenantIds = data.sysUser.relTenantIds
                this.dataForm.clientId = data.sysUser.clientId
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
              url: this.$http.adornUrl(`/ware/sysuser/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'username': this.dataForm.username,
                'realname': this.dataForm.realname,
                'password': this.dataForm.password,
                'salt': this.dataForm.salt,
                'avatar': this.dataForm.avatar,
                'birthday': this.dataForm.birthday,
                'sex': this.dataForm.sex,
                'email': this.dataForm.email,
                'phone': this.dataForm.phone,
                'orgCode': this.dataForm.orgCode,
                'status': this.dataForm.status,
                'delFlag': this.dataForm.delFlag,
                'thirdId': this.dataForm.thirdId,
                'thirdType': this.dataForm.thirdType,
                'activitiSync': this.dataForm.activitiSync,
                'workNo': this.dataForm.workNo,
                'post': this.dataForm.post,
                'telephone': this.dataForm.telephone,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'userIdentity': this.dataForm.userIdentity,
                'departIds': this.dataForm.departIds,
                'relTenantIds': this.dataForm.relTenantIds,
                'clientId': this.dataForm.clientId
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
