<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="关键词" prop="keyWord">
      <el-input v-model="dataForm.keyWord" placeholder="关键词"></el-input>
    </el-form-item>
    <el-form-item label="打卡时间" prop="punchTime">
      <el-input v-model="dataForm.punchTime" placeholder="打卡时间"></el-input>
    </el-form-item>
    <el-form-item label="工资" prop="salaryMoney">
      <el-input v-model="dataForm.salaryMoney" placeholder="工资"></el-input>
    </el-form-item>
    <el-form-item label="奖金" prop="bonusMoney">
      <el-input v-model="dataForm.bonusMoney" placeholder="奖金"></el-input>
    </el-form-item>
    <el-form-item label="性别 {男:1,女:2}" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别 {男:1,女:2}"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model="dataForm.age" placeholder="年龄"></el-input>
    </el-form-item>
    <el-form-item label="生日" prop="birthday">
      <el-input v-model="dataForm.birthday" placeholder="生日"></el-input>
    </el-form-item>
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="邮箱"></el-input>
    </el-form-item>
    <el-form-item label="个人简介" prop="content">
      <el-input v-model="dataForm.content" placeholder="个人简介"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="修改人"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="所属部门编码" prop="sysOrgCode">
      <el-input v-model="dataForm.sysOrgCode" placeholder="所属部门编码"></el-input>
    </el-form-item>
    <el-form-item label="" prop="tenantId">
      <el-input v-model="dataForm.tenantId" placeholder=""></el-input>
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
          name: '',
          keyWord: '',
          punchTime: '',
          salaryMoney: '',
          bonusMoney: '',
          sex: '',
          age: '',
          birthday: '',
          email: '',
          content: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          sysOrgCode: '',
          tenantId: ''
        },
        dataRule: {
          name: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          keyWord: [
            { required: true, message: '关键词不能为空', trigger: 'blur' }
          ],
          punchTime: [
            { required: true, message: '打卡时间不能为空', trigger: 'blur' }
          ],
          salaryMoney: [
            { required: true, message: '工资不能为空', trigger: 'blur' }
          ],
          bonusMoney: [
            { required: true, message: '奖金不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别 {男:1,女:2}不能为空', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '年龄不能为空', trigger: 'blur' }
          ],
          birthday: [
            { required: true, message: '生日不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '邮箱不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '个人简介不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '修改人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          sysOrgCode: [
            { required: true, message: '所属部门编码不能为空', trigger: 'blur' }
          ],
          tenantId: [
            { required: true, message: '不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/demo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.demo.name
                this.dataForm.keyWord = data.demo.keyWord
                this.dataForm.punchTime = data.demo.punchTime
                this.dataForm.salaryMoney = data.demo.salaryMoney
                this.dataForm.bonusMoney = data.demo.bonusMoney
                this.dataForm.sex = data.demo.sex
                this.dataForm.age = data.demo.age
                this.dataForm.birthday = data.demo.birthday
                this.dataForm.email = data.demo.email
                this.dataForm.content = data.demo.content
                this.dataForm.createBy = data.demo.createBy
                this.dataForm.createTime = data.demo.createTime
                this.dataForm.updateBy = data.demo.updateBy
                this.dataForm.updateTime = data.demo.updateTime
                this.dataForm.sysOrgCode = data.demo.sysOrgCode
                this.dataForm.tenantId = data.demo.tenantId
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
              url: this.$http.adornUrl(`/ware/demo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'keyWord': this.dataForm.keyWord,
                'punchTime': this.dataForm.punchTime,
                'salaryMoney': this.dataForm.salaryMoney,
                'bonusMoney': this.dataForm.bonusMoney,
                'sex': this.dataForm.sex,
                'age': this.dataForm.age,
                'birthday': this.dataForm.birthday,
                'email': this.dataForm.email,
                'content': this.dataForm.content,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'sysOrgCode': this.dataForm.sysOrgCode,
                'tenantId': this.dataForm.tenantId
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
