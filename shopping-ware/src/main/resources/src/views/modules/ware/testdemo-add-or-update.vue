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
    <el-form-item label="用户名" prop="name">
      <el-input v-model="dataForm.name" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model="dataForm.age" placeholder="年龄"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="descc">
      <el-input v-model="dataForm.descc" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="生日" prop="birthday">
      <el-input v-model="dataForm.birthday" placeholder="生日"></el-input>
    </el-form-item>
    <el-form-item label="用户编码" prop="userCode">
      <el-input v-model="dataForm.userCode" placeholder="用户编码"></el-input>
    </el-form-item>
    <el-form-item label="附件" prop="fileKk">
      <el-input v-model="dataForm.fileKk" placeholder="附件"></el-input>
    </el-form-item>
    <el-form-item label="头像" prop="topPic">
      <el-input v-model="dataForm.topPic" placeholder="头像"></el-input>
    </el-form-item>
    <el-form-item label="城市" prop="chegnshi">
      <el-input v-model="dataForm.chegnshi" placeholder="城市"></el-input>
    </el-form-item>
    <el-form-item label="checkbox" prop="ceck">
      <el-input v-model="dataForm.ceck" placeholder="checkbox"></el-input>
    </el-form-item>
    <el-form-item label="下拉多选" prop="xiamuti">
      <el-input v-model="dataForm.xiamuti" placeholder="下拉多选"></el-input>
    </el-form-item>
    <el-form-item label="搜索下拉" prop="searchSel">
      <el-input v-model="dataForm.searchSel" placeholder="搜索下拉"></el-input>
    </el-form-item>
    <el-form-item label="弹窗" prop="pop">
      <el-input v-model="dataForm.pop" placeholder="弹窗"></el-input>
    </el-form-item>
    <el-form-item label="下拉字典表" prop="selTable">
      <el-input v-model="dataForm.selTable" placeholder="下拉字典表"></el-input>
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
          name: '',
          sex: '',
          age: '',
          descc: '',
          birthday: '',
          userCode: '',
          fileKk: '',
          topPic: '',
          chegnshi: '',
          ceck: '',
          xiamuti: '',
          searchSel: '',
          pop: '',
          selTable: ''
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
          name: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '年龄不能为空', trigger: 'blur' }
          ],
          descc: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          birthday: [
            { required: true, message: '生日不能为空', trigger: 'blur' }
          ],
          userCode: [
            { required: true, message: '用户编码不能为空', trigger: 'blur' }
          ],
          fileKk: [
            { required: true, message: '附件不能为空', trigger: 'blur' }
          ],
          topPic: [
            { required: true, message: '头像不能为空', trigger: 'blur' }
          ],
          chegnshi: [
            { required: true, message: '城市不能为空', trigger: 'blur' }
          ],
          ceck: [
            { required: true, message: 'checkbox不能为空', trigger: 'blur' }
          ],
          xiamuti: [
            { required: true, message: '下拉多选不能为空', trigger: 'blur' }
          ],
          searchSel: [
            { required: true, message: '搜索下拉不能为空', trigger: 'blur' }
          ],
          pop: [
            { required: true, message: '弹窗不能为空', trigger: 'blur' }
          ],
          selTable: [
            { required: true, message: '下拉字典表不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/testdemo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.createBy = data.testDemo.createBy
                this.dataForm.createTime = data.testDemo.createTime
                this.dataForm.updateBy = data.testDemo.updateBy
                this.dataForm.updateTime = data.testDemo.updateTime
                this.dataForm.name = data.testDemo.name
                this.dataForm.sex = data.testDemo.sex
                this.dataForm.age = data.testDemo.age
                this.dataForm.descc = data.testDemo.descc
                this.dataForm.birthday = data.testDemo.birthday
                this.dataForm.userCode = data.testDemo.userCode
                this.dataForm.fileKk = data.testDemo.fileKk
                this.dataForm.topPic = data.testDemo.topPic
                this.dataForm.chegnshi = data.testDemo.chegnshi
                this.dataForm.ceck = data.testDemo.ceck
                this.dataForm.xiamuti = data.testDemo.xiamuti
                this.dataForm.searchSel = data.testDemo.searchSel
                this.dataForm.pop = data.testDemo.pop
                this.dataForm.selTable = data.testDemo.selTable
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
              url: this.$http.adornUrl(`/ware/testdemo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'name': this.dataForm.name,
                'sex': this.dataForm.sex,
                'age': this.dataForm.age,
                'descc': this.dataForm.descc,
                'birthday': this.dataForm.birthday,
                'userCode': this.dataForm.userCode,
                'fileKk': this.dataForm.fileKk,
                'topPic': this.dataForm.topPic,
                'chegnshi': this.dataForm.chegnshi,
                'ceck': this.dataForm.ceck,
                'xiamuti': this.dataForm.xiamuti,
                'searchSel': this.dataForm.searchSel,
                'pop': this.dataForm.pop,
                'selTable': this.dataForm.selTable
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
