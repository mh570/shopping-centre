<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="项目性质" prop="nature">
      <el-input v-model="dataForm.nature" placeholder="项目性质"></el-input>
    </el-form-item>
    <el-form-item label="保险经纪佣金费" prop="insuranceFee">
      <el-input v-model="dataForm.insuranceFee" placeholder="保险经纪佣金费"></el-input>
    </el-form-item>
    <el-form-item label="风险咨询费" prop="riskConsultingFee">
      <el-input v-model="dataForm.riskConsultingFee" placeholder="风险咨询费"></el-input>
    </el-form-item>
    <el-form-item label="承保公估评估费" prop="evaluationFee">
      <el-input v-model="dataForm.evaluationFee" placeholder="承保公估评估费"></el-input>
    </el-form-item>
    <el-form-item label="保险公估费" prop="insuranceEvaluationFee">
      <el-input v-model="dataForm.insuranceEvaluationFee" placeholder="保险公估费"></el-input>
    </el-form-item>
    <el-form-item label="投标咨询费" prop="biddingConsultingFee">
      <el-input v-model="dataForm.biddingConsultingFee" placeholder="投标咨询费"></el-input>
    </el-form-item>
    <el-form-item label="内控咨询费" prop="interolConsultingFee">
      <el-input v-model="dataForm.interolConsultingFee" placeholder="内控咨询费"></el-input>
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
          nature: '',
          insuranceFee: '',
          riskConsultingFee: '',
          evaluationFee: '',
          insuranceEvaluationFee: '',
          biddingConsultingFee: '',
          interolConsultingFee: ''
        },
        dataRule: {
          nature: [
            { required: true, message: '项目性质不能为空', trigger: 'blur' }
          ],
          insuranceFee: [
            { required: true, message: '保险经纪佣金费不能为空', trigger: 'blur' }
          ],
          riskConsultingFee: [
            { required: true, message: '风险咨询费不能为空', trigger: 'blur' }
          ],
          evaluationFee: [
            { required: true, message: '承保公估评估费不能为空', trigger: 'blur' }
          ],
          insuranceEvaluationFee: [
            { required: true, message: '保险公估费不能为空', trigger: 'blur' }
          ],
          biddingConsultingFee: [
            { required: true, message: '投标咨询费不能为空', trigger: 'blur' }
          ],
          interolConsultingFee: [
            { required: true, message: '内控咨询费不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jeecgprojectnatureincome/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.nature = data.jeecgProjectNatureIncome.nature
                this.dataForm.insuranceFee = data.jeecgProjectNatureIncome.insuranceFee
                this.dataForm.riskConsultingFee = data.jeecgProjectNatureIncome.riskConsultingFee
                this.dataForm.evaluationFee = data.jeecgProjectNatureIncome.evaluationFee
                this.dataForm.insuranceEvaluationFee = data.jeecgProjectNatureIncome.insuranceEvaluationFee
                this.dataForm.biddingConsultingFee = data.jeecgProjectNatureIncome.biddingConsultingFee
                this.dataForm.interolConsultingFee = data.jeecgProjectNatureIncome.interolConsultingFee
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
              url: this.$http.adornUrl(`/ware/jeecgprojectnatureincome/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'nature': this.dataForm.nature,
                'insuranceFee': this.dataForm.insuranceFee,
                'riskConsultingFee': this.dataForm.riskConsultingFee,
                'evaluationFee': this.dataForm.evaluationFee,
                'insuranceEvaluationFee': this.dataForm.insuranceEvaluationFee,
                'biddingConsultingFee': this.dataForm.biddingConsultingFee,
                'interolConsultingFee': this.dataForm.interolConsultingFee
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
