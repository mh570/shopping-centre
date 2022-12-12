<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="online表ID" prop="cgformId">
      <el-input v-model="dataForm.cgformId" placeholder="online表ID"></el-input>
    </el-form-item>
    <el-form-item label="规则名" prop="ruleName">
      <el-input v-model="dataForm.ruleName" placeholder="规则名"></el-input>
    </el-form-item>
    <el-form-item label="规则列" prop="ruleColumn">
      <el-input v-model="dataForm.ruleColumn" placeholder="规则列"></el-input>
    </el-form-item>
    <el-form-item label="规则条件 大于小于like" prop="ruleOperator">
      <el-input v-model="dataForm.ruleOperator" placeholder="规则条件 大于小于like"></el-input>
    </el-form-item>
    <el-form-item label="规则值" prop="ruleValue">
      <el-input v-model="dataForm.ruleValue" placeholder="规则值"></el-input>
    </el-form-item>
    <el-form-item label="1有效 0无效" prop="status">
      <el-input v-model="dataForm.status" placeholder="1有效 0无效"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="更新人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人"></el-input>
    </el-form-item>
    <el-form-item label="更新日期" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新日期"></el-input>
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
          cgformId: '',
          ruleName: '',
          ruleColumn: '',
          ruleOperator: '',
          ruleValue: '',
          status: '',
          createTime: '',
          createBy: '',
          updateBy: '',
          updateTime: ''
        },
        dataRule: {
          cgformId: [
            { required: true, message: 'online表ID不能为空', trigger: 'blur' }
          ],
          ruleName: [
            { required: true, message: '规则名不能为空', trigger: 'blur' }
          ],
          ruleColumn: [
            { required: true, message: '规则列不能为空', trigger: 'blur' }
          ],
          ruleOperator: [
            { required: true, message: '规则条件 大于小于like不能为空', trigger: 'blur' }
          ],
          ruleValue: [
            { required: true, message: '规则值不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '1有效 0无效不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/onlauthdata/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.cgformId = data.onlAuthData.cgformId
                this.dataForm.ruleName = data.onlAuthData.ruleName
                this.dataForm.ruleColumn = data.onlAuthData.ruleColumn
                this.dataForm.ruleOperator = data.onlAuthData.ruleOperator
                this.dataForm.ruleValue = data.onlAuthData.ruleValue
                this.dataForm.status = data.onlAuthData.status
                this.dataForm.createTime = data.onlAuthData.createTime
                this.dataForm.createBy = data.onlAuthData.createBy
                this.dataForm.updateBy = data.onlAuthData.updateBy
                this.dataForm.updateTime = data.onlAuthData.updateTime
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
              url: this.$http.adornUrl(`/ware/onlauthdata/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'cgformId': this.dataForm.cgformId,
                'ruleName': this.dataForm.ruleName,
                'ruleColumn': this.dataForm.ruleColumn,
                'ruleOperator': this.dataForm.ruleOperator,
                'ruleValue': this.dataForm.ruleValue,
                'status': this.dataForm.status,
                'createTime': this.dataForm.createTime,
                'createBy': this.dataForm.createBy,
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
