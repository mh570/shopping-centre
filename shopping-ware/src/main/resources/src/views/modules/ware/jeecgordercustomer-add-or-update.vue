<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="客户名" prop="name">
      <el-input v-model="dataForm.name" placeholder="客户名"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="身份证号码" prop="idcard">
      <el-input v-model="dataForm.idcard" placeholder="身份证号码"></el-input>
    </el-form-item>
    <el-form-item label="身份证扫描件" prop="idcardPic">
      <el-input v-model="dataForm.idcardPic" placeholder="身份证扫描件"></el-input>
    </el-form-item>
    <el-form-item label="电话1" prop="telphone">
      <el-input v-model="dataForm.telphone" placeholder="电话1"></el-input>
    </el-form-item>
    <el-form-item label="外键" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder="外键"></el-input>
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
          sex: '',
          idcard: '',
          idcardPic: '',
          telphone: '',
          orderId: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: ''
        },
        dataRule: {
          name: [
            { required: true, message: '客户名不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          idcard: [
            { required: true, message: '身份证号码不能为空', trigger: 'blur' }
          ],
          idcardPic: [
            { required: true, message: '身份证扫描件不能为空', trigger: 'blur' }
          ],
          telphone: [
            { required: true, message: '电话1不能为空', trigger: 'blur' }
          ],
          orderId: [
            { required: true, message: '外键不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jeecgordercustomer/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.jeecgOrderCustomer.name
                this.dataForm.sex = data.jeecgOrderCustomer.sex
                this.dataForm.idcard = data.jeecgOrderCustomer.idcard
                this.dataForm.idcardPic = data.jeecgOrderCustomer.idcardPic
                this.dataForm.telphone = data.jeecgOrderCustomer.telphone
                this.dataForm.orderId = data.jeecgOrderCustomer.orderId
                this.dataForm.createBy = data.jeecgOrderCustomer.createBy
                this.dataForm.createTime = data.jeecgOrderCustomer.createTime
                this.dataForm.updateBy = data.jeecgOrderCustomer.updateBy
                this.dataForm.updateTime = data.jeecgOrderCustomer.updateTime
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
              url: this.$http.adornUrl(`/ware/jeecgordercustomer/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'sex': this.dataForm.sex,
                'idcard': this.dataForm.idcard,
                'idcardPic': this.dataForm.idcardPic,
                'telphone': this.dataForm.telphone,
                'orderId': this.dataForm.orderId,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime
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
