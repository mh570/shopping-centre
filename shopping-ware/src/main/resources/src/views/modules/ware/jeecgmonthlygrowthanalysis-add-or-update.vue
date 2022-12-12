<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="year">
      <el-input v-model="dataForm.year" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="月份" prop="month">
      <el-input v-model="dataForm.month" placeholder="月份"></el-input>
    </el-form-item>
    <el-form-item label="佣金/主营收入" prop="mainIncome">
      <el-input v-model="dataForm.mainIncome" placeholder="佣金/主营收入"></el-input>
    </el-form-item>
    <el-form-item label="其他收入" prop="otherIncome">
      <el-input v-model="dataForm.otherIncome" placeholder="其他收入"></el-input>
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
          year: '',
          month: '',
          mainIncome: '',
          otherIncome: ''
        },
        dataRule: {
          year: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          month: [
            { required: true, message: '月份不能为空', trigger: 'blur' }
          ],
          mainIncome: [
            { required: true, message: '佣金/主营收入不能为空', trigger: 'blur' }
          ],
          otherIncome: [
            { required: true, message: '其他收入不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jeecgmonthlygrowthanalysis/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.year = data.jeecgMonthlyGrowthAnalysis.year
                this.dataForm.month = data.jeecgMonthlyGrowthAnalysis.month
                this.dataForm.mainIncome = data.jeecgMonthlyGrowthAnalysis.mainIncome
                this.dataForm.otherIncome = data.jeecgMonthlyGrowthAnalysis.otherIncome
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
              url: this.$http.adornUrl(`/ware/jeecgmonthlygrowthanalysis/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'year': this.dataForm.year,
                'month': this.dataForm.month,
                'mainIncome': this.dataForm.mainIncome,
                'otherIncome': this.dataForm.otherIncome
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
