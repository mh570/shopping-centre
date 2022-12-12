<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="bxJjYongjin">
      <el-input v-model="dataForm.bxJjYongjin" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="bxZxMoney">
      <el-input v-model="dataForm.bxZxMoney" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="chengbaoGzMoney">
      <el-input v-model="dataForm.chengbaoGzMoney" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="bxGgMoeny">
      <el-input v-model="dataForm.bxGgMoeny" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="tbZxMoney">
      <el-input v-model="dataForm.tbZxMoney" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="neikongZxMoney">
      <el-input v-model="dataForm.neikongZxMoney" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="total">
      <el-input v-model="dataForm.total" placeholder=""></el-input>
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
          bizIncome: 0,
          bxJjYongjin: '',
          bxZxMoney: '',
          chengbaoGzMoney: '',
          bxGgMoeny: '',
          tbZxMoney: '',
          neikongZxMoney: '',
          total: ''
        },
        dataRule: {
          bxJjYongjin: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          bxZxMoney: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          chengbaoGzMoney: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          bxGgMoeny: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          tbZxMoney: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          neikongZxMoney: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          total: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.bizIncome = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.bizIncome) {
            this.$http({
              url: this.$http.adornUrl(`/ware/tmpreportdataincome/info/${this.dataForm.bizIncome}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.bxJjYongjin = data.tmpReportDataIncome.bxJjYongjin
                this.dataForm.bxZxMoney = data.tmpReportDataIncome.bxZxMoney
                this.dataForm.chengbaoGzMoney = data.tmpReportDataIncome.chengbaoGzMoney
                this.dataForm.bxGgMoeny = data.tmpReportDataIncome.bxGgMoeny
                this.dataForm.tbZxMoney = data.tmpReportDataIncome.tbZxMoney
                this.dataForm.neikongZxMoney = data.tmpReportDataIncome.neikongZxMoney
                this.dataForm.total = data.tmpReportDataIncome.total
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
              url: this.$http.adornUrl(`/ware/tmpreportdataincome/${!this.dataForm.bizIncome ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'bizIncome': this.dataForm.bizIncome || undefined,
                'bxJjYongjin': this.dataForm.bxJjYongjin,
                'bxZxMoney': this.dataForm.bxZxMoney,
                'chengbaoGzMoney': this.dataForm.chengbaoGzMoney,
                'bxGgMoeny': this.dataForm.bxGgMoeny,
                'tbZxMoney': this.dataForm.tbZxMoney,
                'neikongZxMoney': this.dataForm.neikongZxMoney,
                'total': this.dataForm.total
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
