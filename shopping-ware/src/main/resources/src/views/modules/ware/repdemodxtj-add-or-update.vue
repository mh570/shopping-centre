<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="雇佣日期" prop="gtime">
      <el-input v-model="dataForm.gtime" placeholder="雇佣日期"></el-input>
    </el-form-item>
    <el-form-item label="职务" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="职务"></el-input>
    </el-form-item>
    <el-form-item label="家庭电话" prop="jphone">
      <el-input v-model="dataForm.jphone" placeholder="家庭电话"></el-input>
    </el-form-item>
    <el-form-item label="出生日期" prop="birth">
      <el-input v-model="dataForm.birth" placeholder="出生日期"></el-input>
    </el-form-item>
    <el-form-item label="户口所在地" prop="hukou">
      <el-input v-model="dataForm.hukou" placeholder="户口所在地"></el-input>
    </el-form-item>
    <el-form-item label="联系地址" prop="laddress">
      <el-input v-model="dataForm.laddress" placeholder="联系地址"></el-input>
    </el-form-item>
    <el-form-item label="紧急联系人" prop="jperson">
      <el-input v-model="dataForm.jperson" placeholder="紧急联系人"></el-input>
    </el-form-item>
    <el-form-item label="xingbie" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="xingbie"></el-input>
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
          gtime: '',
          updateBy: '',
          jphone: '',
          birth: '',
          hukou: '',
          laddress: '',
          jperson: '',
          sex: ''
        },
        dataRule: {
          name: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          gtime: [
            { required: true, message: '雇佣日期不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '职务不能为空', trigger: 'blur' }
          ],
          jphone: [
            { required: true, message: '家庭电话不能为空', trigger: 'blur' }
          ],
          birth: [
            { required: true, message: '出生日期不能为空', trigger: 'blur' }
          ],
          hukou: [
            { required: true, message: '户口所在地不能为空', trigger: 'blur' }
          ],
          laddress: [
            { required: true, message: '联系地址不能为空', trigger: 'blur' }
          ],
          jperson: [
            { required: true, message: '紧急联系人不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: 'xingbie不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/repdemodxtj/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.repDemoDxtj.name
                this.dataForm.gtime = data.repDemoDxtj.gtime
                this.dataForm.updateBy = data.repDemoDxtj.updateBy
                this.dataForm.jphone = data.repDemoDxtj.jphone
                this.dataForm.birth = data.repDemoDxtj.birth
                this.dataForm.hukou = data.repDemoDxtj.hukou
                this.dataForm.laddress = data.repDemoDxtj.laddress
                this.dataForm.jperson = data.repDemoDxtj.jperson
                this.dataForm.sex = data.repDemoDxtj.sex
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
              url: this.$http.adornUrl(`/ware/repdemodxtj/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'gtime': this.dataForm.gtime,
                'updateBy': this.dataForm.updateBy,
                'jphone': this.dataForm.jphone,
                'birth': this.dataForm.birth,
                'hukou': this.dataForm.hukou,
                'laddress': this.dataForm.laddress,
                'jperson': this.dataForm.jperson,
                'sex': this.dataForm.sex
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
