<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
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
    <el-form-item label="名字" prop="name">
      <el-input v-model="dataForm.name" placeholder="名字"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model="dataForm.age" placeholder="年龄"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="生日" prop="birthday">
      <el-input v-model="dataForm.birthday" placeholder="生日"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="cc">
      <el-input v-model="dataForm.cc" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="关联记录" prop="relUser">
      <el-input v-model="dataForm.relUser" placeholder="关联记录"></el-input>
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
          sysOrgCode: '',
          name: '',
          age: '',
          sex: '',
          birthday: '',
          cc: '',
          relUser: ''
        },
        dataRule: {
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
          ],
          name: [
            { required: true, message: '名字不能为空', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '年龄不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          birthday: [
            { required: true, message: '生日不能为空', trigger: 'blur' }
          ],
          cc: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          relUser: [
            { required: true, message: '关联记录不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/v3hello/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.createBy = data.v3Hello.createBy
                this.dataForm.createTime = data.v3Hello.createTime
                this.dataForm.updateBy = data.v3Hello.updateBy
                this.dataForm.updateTime = data.v3Hello.updateTime
                this.dataForm.sysOrgCode = data.v3Hello.sysOrgCode
                this.dataForm.name = data.v3Hello.name
                this.dataForm.age = data.v3Hello.age
                this.dataForm.sex = data.v3Hello.sex
                this.dataForm.birthday = data.v3Hello.birthday
                this.dataForm.cc = data.v3Hello.cc
                this.dataForm.relUser = data.v3Hello.relUser
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
              url: this.$http.adornUrl(`/ware/v3hello/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'sysOrgCode': this.dataForm.sysOrgCode,
                'name': this.dataForm.name,
                'age': this.dataForm.age,
                'sex': this.dataForm.sex,
                'birthday': this.dataForm.birthday,
                'cc': this.dataForm.cc,
                'relUser': this.dataForm.relUser
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
