<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="规则名称" prop="ruleName">
      <el-input v-model="dataForm.ruleName" placeholder="规则名称"></el-input>
    </el-form-item>
    <el-form-item label="规则Code" prop="ruleCode">
      <el-input v-model="dataForm.ruleCode" placeholder="规则Code"></el-input>
    </el-form-item>
    <el-form-item label="规则JSON" prop="ruleJson">
      <el-input v-model="dataForm.ruleJson" placeholder="规则JSON"></el-input>
    </el-form-item>
    <el-form-item label="规则描述" prop="ruleDescription">
      <el-input v-model="dataForm.ruleDescription" placeholder="规则描述"></el-input>
    </el-form-item>
    <el-form-item label="更新人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
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
          ruleName: '',
          ruleCode: '',
          ruleJson: '',
          ruleDescription: '',
          updateBy: '',
          updateTime: '',
          createBy: '',
          createTime: ''
        },
        dataRule: {
          ruleName: [
            { required: true, message: '规则名称不能为空', trigger: 'blur' }
          ],
          ruleCode: [
            { required: true, message: '规则Code不能为空', trigger: 'blur' }
          ],
          ruleJson: [
            { required: true, message: '规则JSON不能为空', trigger: 'blur' }
          ],
          ruleDescription: [
            { required: true, message: '规则描述不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/syscheckrule/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.ruleName = data.sysCheckRule.ruleName
                this.dataForm.ruleCode = data.sysCheckRule.ruleCode
                this.dataForm.ruleJson = data.sysCheckRule.ruleJson
                this.dataForm.ruleDescription = data.sysCheckRule.ruleDescription
                this.dataForm.updateBy = data.sysCheckRule.updateBy
                this.dataForm.updateTime = data.sysCheckRule.updateTime
                this.dataForm.createBy = data.sysCheckRule.createBy
                this.dataForm.createTime = data.sysCheckRule.createTime
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
              url: this.$http.adornUrl(`/ware/syscheckrule/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'ruleName': this.dataForm.ruleName,
                'ruleCode': this.dataForm.ruleCode,
                'ruleJson': this.dataForm.ruleJson,
                'ruleDescription': this.dataForm.ruleDescription,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime
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
