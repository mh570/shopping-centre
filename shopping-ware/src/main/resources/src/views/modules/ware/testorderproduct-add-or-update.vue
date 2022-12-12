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
    <el-form-item label="产品名字" prop="productName">
      <el-input v-model="dataForm.productName" placeholder="产品名字"></el-input>
    </el-form-item>
    <el-form-item label="价格" prop="price">
      <el-input v-model="dataForm.price" placeholder="价格"></el-input>
    </el-form-item>
    <el-form-item label="数量" prop="num">
      <el-input v-model="dataForm.num" placeholder="数量"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="descc">
      <el-input v-model="dataForm.descc" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="订单外键ID" prop="orderFkId">
      <el-input v-model="dataForm.orderFkId" placeholder="订单外键ID"></el-input>
    </el-form-item>
    <el-form-item label="产品类型" prop="proType">
      <el-input v-model="dataForm.proType" placeholder="产品类型"></el-input>
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
          productName: '',
          price: '',
          num: '',
          descc: '',
          orderFkId: '',
          proType: ''
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
          productName: [
            { required: true, message: '产品名字不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '价格不能为空', trigger: 'blur' }
          ],
          num: [
            { required: true, message: '数量不能为空', trigger: 'blur' }
          ],
          descc: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          orderFkId: [
            { required: true, message: '订单外键ID不能为空', trigger: 'blur' }
          ],
          proType: [
            { required: true, message: '产品类型不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/testorderproduct/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.createBy = data.testOrderProduct.createBy
                this.dataForm.createTime = data.testOrderProduct.createTime
                this.dataForm.updateBy = data.testOrderProduct.updateBy
                this.dataForm.updateTime = data.testOrderProduct.updateTime
                this.dataForm.productName = data.testOrderProduct.productName
                this.dataForm.price = data.testOrderProduct.price
                this.dataForm.num = data.testOrderProduct.num
                this.dataForm.descc = data.testOrderProduct.descc
                this.dataForm.orderFkId = data.testOrderProduct.orderFkId
                this.dataForm.proType = data.testOrderProduct.proType
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
              url: this.$http.adornUrl(`/ware/testorderproduct/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'productName': this.dataForm.productName,
                'price': this.dataForm.price,
                'num': this.dataForm.num,
                'descc': this.dataForm.descc,
                'orderFkId': this.dataForm.orderFkId,
                'proType': this.dataForm.proType
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
