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
    <el-form-item label="订单编码" prop="orderCode">
      <el-input v-model="dataForm.orderCode" placeholder="订单编码"></el-input>
    </el-form-item>
    <el-form-item label="下单时间" prop="orderDate">
      <el-input v-model="dataForm.orderDate" placeholder="下单时间"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="descc">
      <el-input v-model="dataForm.descc" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="下拉多选" prop="xiala">
      <el-input v-model="dataForm.xiala" placeholder="下拉多选"></el-input>
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
          orderCode: '',
          orderDate: '',
          descc: '',
          xiala: ''
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
          orderCode: [
            { required: true, message: '订单编码不能为空', trigger: 'blur' }
          ],
          orderDate: [
            { required: true, message: '下单时间不能为空', trigger: 'blur' }
          ],
          descc: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          xiala: [
            { required: true, message: '下拉多选不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/testordermain/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.createBy = data.testOrderMain.createBy
                this.dataForm.createTime = data.testOrderMain.createTime
                this.dataForm.updateBy = data.testOrderMain.updateBy
                this.dataForm.updateTime = data.testOrderMain.updateTime
                this.dataForm.orderCode = data.testOrderMain.orderCode
                this.dataForm.orderDate = data.testOrderMain.orderDate
                this.dataForm.descc = data.testOrderMain.descc
                this.dataForm.xiala = data.testOrderMain.xiala
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
              url: this.$http.adornUrl(`/ware/testordermain/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'orderCode': this.dataForm.orderCode,
                'orderDate': this.dataForm.orderDate,
                'descc': this.dataForm.descc,
                'xiala': this.dataForm.xiala
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
