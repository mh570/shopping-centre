<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="模板标题" prop="templateName">
      <el-input v-model="dataForm.templateName" placeholder="模板标题"></el-input>
    </el-form-item>
    <el-form-item label="模板CODE" prop="templateCode">
      <el-input v-model="dataForm.templateCode" placeholder="模板CODE"></el-input>
    </el-form-item>
    <el-form-item label="模板类型：1短信 2邮件 3微信" prop="templateType">
      <el-input v-model="dataForm.templateType" placeholder="模板类型：1短信 2邮件 3微信"></el-input>
    </el-form-item>
    <el-form-item label="模板内容" prop="templateContent">
      <el-input v-model="dataForm.templateContent" placeholder="模板内容"></el-input>
    </el-form-item>
    <el-form-item label="模板测试json" prop="templateTestJson">
      <el-input v-model="dataForm.templateTestJson" placeholder="模板测试json"></el-input>
    </el-form-item>
    <el-form-item label="创建日期" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建日期"></el-input>
    </el-form-item>
    <el-form-item label="创建人登录名称" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人登录名称"></el-input>
    </el-form-item>
    <el-form-item label="更新日期" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新日期"></el-input>
    </el-form-item>
    <el-form-item label="更新人登录名称" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人登录名称"></el-input>
    </el-form-item>
    <el-form-item label="是否使用中 1是0否" prop="useStatus">
      <el-input v-model="dataForm.useStatus" placeholder="是否使用中 1是0否"></el-input>
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
          templateName: '',
          templateCode: '',
          templateType: '',
          templateContent: '',
          templateTestJson: '',
          createTime: '',
          createBy: '',
          updateTime: '',
          updateBy: '',
          useStatus: ''
        },
        dataRule: {
          templateName: [
            { required: true, message: '模板标题不能为空', trigger: 'blur' }
          ],
          templateCode: [
            { required: true, message: '模板CODE不能为空', trigger: 'blur' }
          ],
          templateType: [
            { required: true, message: '模板类型：1短信 2邮件 3微信不能为空', trigger: 'blur' }
          ],
          templateContent: [
            { required: true, message: '模板内容不能为空', trigger: 'blur' }
          ],
          templateTestJson: [
            { required: true, message: '模板测试json不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建日期不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人登录名称不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新日期不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人登录名称不能为空', trigger: 'blur' }
          ],
          useStatus: [
            { required: true, message: '是否使用中 1是0否不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/syssmstemplate/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.templateName = data.sysSmsTemplate.templateName
                this.dataForm.templateCode = data.sysSmsTemplate.templateCode
                this.dataForm.templateType = data.sysSmsTemplate.templateType
                this.dataForm.templateContent = data.sysSmsTemplate.templateContent
                this.dataForm.templateTestJson = data.sysSmsTemplate.templateTestJson
                this.dataForm.createTime = data.sysSmsTemplate.createTime
                this.dataForm.createBy = data.sysSmsTemplate.createBy
                this.dataForm.updateTime = data.sysSmsTemplate.updateTime
                this.dataForm.updateBy = data.sysSmsTemplate.updateBy
                this.dataForm.useStatus = data.sysSmsTemplate.useStatus
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
              url: this.$http.adornUrl(`/ware/syssmstemplate/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'templateName': this.dataForm.templateName,
                'templateCode': this.dataForm.templateCode,
                'templateType': this.dataForm.templateType,
                'templateContent': this.dataForm.templateContent,
                'templateTestJson': this.dataForm.templateTestJson,
                'createTime': this.dataForm.createTime,
                'createBy': this.dataForm.createBy,
                'updateTime': this.dataForm.updateTime,
                'updateBy': this.dataForm.updateBy,
                'useStatus': this.dataForm.useStatus
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
