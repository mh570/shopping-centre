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
    <el-form-item label="用户名字" prop="name">
      <el-input v-model="dataForm.name" placeholder="用户名字"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model="dataForm.age" placeholder="年龄"></el-input>
    </el-form-item>
    <el-form-item label="生日" prop="birthday">
      <el-input v-model="dataForm.birthday" placeholder="生日"></el-input>
    </el-form-item>
    <el-form-item label="打卡时间" prop="dakaTime">
      <el-input v-model="dataForm.dakaTime" placeholder="打卡时间"></el-input>
    </el-form-item>
    <el-form-item label="薪资" prop="salary">
      <el-input v-model="dataForm.salary" placeholder="薪资"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="ccc">
      <el-input v-model="dataForm.ccc" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="所属部门" prop="depSuo">
      <el-input v-model="dataForm.depSuo" placeholder="所属部门"></el-input>
    </el-form-item>
    <el-form-item label="弹窗" prop="popupTa">
      <el-input v-model="dataForm.popupTa" placeholder="弹窗"></el-input>
    </el-form-item>
    <el-form-item label="父级节点" prop="pid">
      <el-input v-model="dataForm.pid" placeholder="父级节点"></el-input>
    </el-form-item>
    <el-form-item label="是否有子节点" prop="hasChild">
      <el-input v-model="dataForm.hasChild" placeholder="是否有子节点"></el-input>
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
          sex: '',
          age: '',
          birthday: '',
          dakaTime: '',
          salary: '',
          ccc: '',
          depSuo: '',
          popupTa: '',
          pid: '',
          hasChild: ''
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
            { required: true, message: '用户名字不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '年龄不能为空', trigger: 'blur' }
          ],
          birthday: [
            { required: true, message: '生日不能为空', trigger: 'blur' }
          ],
          dakaTime: [
            { required: true, message: '打卡时间不能为空', trigger: 'blur' }
          ],
          salary: [
            { required: true, message: '薪资不能为空', trigger: 'blur' }
          ],
          ccc: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          depSuo: [
            { required: true, message: '所属部门不能为空', trigger: 'blur' }
          ],
          popupTa: [
            { required: true, message: '弹窗不能为空', trigger: 'blur' }
          ],
          pid: [
            { required: true, message: '父级节点不能为空', trigger: 'blur' }
          ],
          hasChild: [
            { required: true, message: '是否有子节点不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/ceshi001/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.createBy = data.ceshi001.createBy
                this.dataForm.createTime = data.ceshi001.createTime
                this.dataForm.updateBy = data.ceshi001.updateBy
                this.dataForm.updateTime = data.ceshi001.updateTime
                this.dataForm.sysOrgCode = data.ceshi001.sysOrgCode
                this.dataForm.name = data.ceshi001.name
                this.dataForm.sex = data.ceshi001.sex
                this.dataForm.age = data.ceshi001.age
                this.dataForm.birthday = data.ceshi001.birthday
                this.dataForm.dakaTime = data.ceshi001.dakaTime
                this.dataForm.salary = data.ceshi001.salary
                this.dataForm.ccc = data.ceshi001.ccc
                this.dataForm.depSuo = data.ceshi001.depSuo
                this.dataForm.popupTa = data.ceshi001.popupTa
                this.dataForm.pid = data.ceshi001.pid
                this.dataForm.hasChild = data.ceshi001.hasChild
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
              url: this.$http.adornUrl(`/ware/ceshi001/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'sysOrgCode': this.dataForm.sysOrgCode,
                'name': this.dataForm.name,
                'sex': this.dataForm.sex,
                'age': this.dataForm.age,
                'birthday': this.dataForm.birthday,
                'dakaTime': this.dataForm.dakaTime,
                'salary': this.dataForm.salary,
                'ccc': this.dataForm.ccc,
                'depSuo': this.dataForm.depSuo,
                'popupTa': this.dataForm.popupTa,
                'pid': this.dataForm.pid,
                'hasChild': this.dataForm.hasChild
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
