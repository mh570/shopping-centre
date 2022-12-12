<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="订单号" prop="orderCode">
      <el-input v-model="dataForm.orderCode" placeholder="订单号"></el-input>
    </el-form-item>
    <el-form-item label="订单类型" prop="ctype">
      <el-input v-model="dataForm.ctype" placeholder="订单类型"></el-input>
    </el-form-item>
    <el-form-item label="订单日期" prop="orderDate">
      <el-input v-model="dataForm.orderDate" placeholder="订单日期"></el-input>
    </el-form-item>
    <el-form-item label="订单金额" prop="orderMoney">
      <el-input v-model="dataForm.orderMoney" placeholder="订单金额"></el-input>
    </el-form-item>
    <el-form-item label="订单备注" prop="content">
      <el-input v-model="dataForm.content" placeholder="订单备注"></el-input>
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
    <el-form-item label="流程状态" prop="bpmStatus">
      <el-input v-model="dataForm.bpmStatus" placeholder="流程状态"></el-input>
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
          orderCode: '',
          ctype: '',
          orderDate: '',
          orderMoney: '',
          content: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          bpmStatus: ''
        },
        dataRule: {
          orderCode: [
            { required: true, message: '订单号不能为空', trigger: 'blur' }
          ],
          ctype: [
            { required: true, message: '订单类型不能为空', trigger: 'blur' }
          ],
          orderDate: [
            { required: true, message: '订单日期不能为空', trigger: 'blur' }
          ],
          orderMoney: [
            { required: true, message: '订单金额不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '订单备注不能为空', trigger: 'blur' }
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
          bpmStatus: [
            { required: true, message: '流程状态不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jeecgordermain/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderCode = data.jeecgOrderMain.orderCode
                this.dataForm.ctype = data.jeecgOrderMain.ctype
                this.dataForm.orderDate = data.jeecgOrderMain.orderDate
                this.dataForm.orderMoney = data.jeecgOrderMain.orderMoney
                this.dataForm.content = data.jeecgOrderMain.content
                this.dataForm.createBy = data.jeecgOrderMain.createBy
                this.dataForm.createTime = data.jeecgOrderMain.createTime
                this.dataForm.updateBy = data.jeecgOrderMain.updateBy
                this.dataForm.updateTime = data.jeecgOrderMain.updateTime
                this.dataForm.bpmStatus = data.jeecgOrderMain.bpmStatus
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
              url: this.$http.adornUrl(`/ware/jeecgordermain/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderCode': this.dataForm.orderCode,
                'ctype': this.dataForm.ctype,
                'orderDate': this.dataForm.orderDate,
                'orderMoney': this.dataForm.orderMoney,
                'content': this.dataForm.content,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'bpmStatus': this.dataForm.bpmStatus
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
