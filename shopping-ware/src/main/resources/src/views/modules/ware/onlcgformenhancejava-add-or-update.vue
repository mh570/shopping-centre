<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="按钮编码" prop="buttonCode">
      <el-input v-model="dataForm.buttonCode" placeholder="按钮编码"></el-input>
    </el-form-item>
    <el-form-item label="类型" prop="cgJavaType">
      <el-input v-model="dataForm.cgJavaType" placeholder="类型"></el-input>
    </el-form-item>
    <el-form-item label="数值" prop="cgJavaValue">
      <el-input v-model="dataForm.cgJavaValue" placeholder="数值"></el-input>
    </el-form-item>
    <el-form-item label="表单ID" prop="cgformHeadId">
      <el-input v-model="dataForm.cgformHeadId" placeholder="表单ID"></el-input>
    </el-form-item>
    <el-form-item label="生效状态" prop="activeStatus">
      <el-input v-model="dataForm.activeStatus" placeholder="生效状态"></el-input>
    </el-form-item>
    <el-form-item label="事件状态(end:结束，start:开始)" prop="event">
      <el-input v-model="dataForm.event" placeholder="事件状态(end:结束，start:开始)"></el-input>
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
          buttonCode: '',
          cgJavaType: '',
          cgJavaValue: '',
          cgformHeadId: '',
          activeStatus: '',
          event: ''
        },
        dataRule: {
          buttonCode: [
            { required: true, message: '按钮编码不能为空', trigger: 'blur' }
          ],
          cgJavaType: [
            { required: true, message: '类型不能为空', trigger: 'blur' }
          ],
          cgJavaValue: [
            { required: true, message: '数值不能为空', trigger: 'blur' }
          ],
          cgformHeadId: [
            { required: true, message: '表单ID不能为空', trigger: 'blur' }
          ],
          activeStatus: [
            { required: true, message: '生效状态不能为空', trigger: 'blur' }
          ],
          event: [
            { required: true, message: '事件状态(end:结束，start:开始)不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/onlcgformenhancejava/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.buttonCode = data.onlCgformEnhanceJava.buttonCode
                this.dataForm.cgJavaType = data.onlCgformEnhanceJava.cgJavaType
                this.dataForm.cgJavaValue = data.onlCgformEnhanceJava.cgJavaValue
                this.dataForm.cgformHeadId = data.onlCgformEnhanceJava.cgformHeadId
                this.dataForm.activeStatus = data.onlCgformEnhanceJava.activeStatus
                this.dataForm.event = data.onlCgformEnhanceJava.event
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
              url: this.$http.adornUrl(`/ware/onlcgformenhancejava/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'buttonCode': this.dataForm.buttonCode,
                'cgJavaType': this.dataForm.cgJavaType,
                'cgJavaValue': this.dataForm.cgJavaValue,
                'cgformHeadId': this.dataForm.cgformHeadId,
                'activeStatus': this.dataForm.activeStatus,
                'event': this.dataForm.event
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
