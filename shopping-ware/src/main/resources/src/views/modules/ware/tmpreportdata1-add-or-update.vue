<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="mainIncome">
      <el-input v-model="dataForm.mainIncome" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="total">
      <el-input v-model="dataForm.total" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="hisLowest">
      <el-input v-model="dataForm.hisLowest" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="hisAverage">
      <el-input v-model="dataForm.hisAverage" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="hisHighest">
      <el-input v-model="dataForm.hisHighest" placeholder=""></el-input>
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
          monty: 0,
          mainIncome: '',
          total: '',
          hisLowest: '',
          hisAverage: '',
          hisHighest: ''
        },
        dataRule: {
          mainIncome: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          total: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          hisLowest: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          hisAverage: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          hisHighest: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.monty = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.monty) {
            this.$http({
              url: this.$http.adornUrl(`/ware/tmpreportdata1/info/${this.dataForm.monty}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.mainIncome = data.tmpReportData1.mainIncome
                this.dataForm.total = data.tmpReportData1.total
                this.dataForm.hisLowest = data.tmpReportData1.hisLowest
                this.dataForm.hisAverage = data.tmpReportData1.hisAverage
                this.dataForm.hisHighest = data.tmpReportData1.hisHighest
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
              url: this.$http.adornUrl(`/ware/tmpreportdata1/${!this.dataForm.monty ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'monty': this.dataForm.monty || undefined,
                'mainIncome': this.dataForm.mainIncome,
                'total': this.dataForm.total,
                'hisLowest': this.dataForm.hisLowest,
                'hisAverage': this.dataForm.hisAverage,
                'hisHighest': this.dataForm.hisHighest
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
