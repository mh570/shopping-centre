<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="消息标题" prop="esTitle">
      <el-input v-model="dataForm.esTitle" placeholder="消息标题"></el-input>
    </el-form-item>
    <el-form-item label="发送方式：参考枚举MessageTypeEnum" prop="esType">
      <el-input v-model="dataForm.esType" placeholder="发送方式：参考枚举MessageTypeEnum"></el-input>
    </el-form-item>
    <el-form-item label="接收人" prop="esReceiver">
      <el-input v-model="dataForm.esReceiver" placeholder="接收人"></el-input>
    </el-form-item>
    <el-form-item label="发送所需参数Json格式" prop="esParam">
      <el-input v-model="dataForm.esParam" placeholder="发送所需参数Json格式"></el-input>
    </el-form-item>
    <el-form-item label="推送内容" prop="esContent">
      <el-input v-model="dataForm.esContent" placeholder="推送内容"></el-input>
    </el-form-item>
    <el-form-item label="推送时间" prop="esSendTime">
      <el-input v-model="dataForm.esSendTime" placeholder="推送时间"></el-input>
    </el-form-item>
    <el-form-item label="推送状态 0未推送 1推送成功 2推送失败 -1失败不再发送" prop="esSendStatus">
      <el-input v-model="dataForm.esSendStatus" placeholder="推送状态 0未推送 1推送成功 2推送失败 -1失败不再发送"></el-input>
    </el-form-item>
    <el-form-item label="发送次数 超过5次不再发送" prop="esSendNum">
      <el-input v-model="dataForm.esSendNum" placeholder="发送次数 超过5次不再发送"></el-input>
    </el-form-item>
    <el-form-item label="推送失败原因" prop="esResult">
      <el-input v-model="dataForm.esResult" placeholder="推送失败原因"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="创建人登录名称" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人登录名称"></el-input>
    </el-form-item>
    <el-form-item label="创建日期" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建日期"></el-input>
    </el-form-item>
    <el-form-item label="更新人登录名称" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人登录名称"></el-input>
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
          esTitle: '',
          esType: '',
          esReceiver: '',
          esParam: '',
          esContent: '',
          esSendTime: '',
          esSendStatus: '',
          esSendNum: '',
          esResult: '',
          remark: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: ''
        },
        dataRule: {
          esTitle: [
            { required: true, message: '消息标题不能为空', trigger: 'blur' }
          ],
          esType: [
            { required: true, message: '发送方式：参考枚举MessageTypeEnum不能为空', trigger: 'blur' }
          ],
          esReceiver: [
            { required: true, message: '接收人不能为空', trigger: 'blur' }
          ],
          esParam: [
            { required: true, message: '发送所需参数Json格式不能为空', trigger: 'blur' }
          ],
          esContent: [
            { required: true, message: '推送内容不能为空', trigger: 'blur' }
          ],
          esSendTime: [
            { required: true, message: '推送时间不能为空', trigger: 'blur' }
          ],
          esSendStatus: [
            { required: true, message: '推送状态 0未推送 1推送成功 2推送失败 -1失败不再发送不能为空', trigger: 'blur' }
          ],
          esSendNum: [
            { required: true, message: '发送次数 超过5次不再发送不能为空', trigger: 'blur' }
          ],
          esResult: [
            { required: true, message: '推送失败原因不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人登录名称不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建日期不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人登录名称不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/syssms/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.esTitle = data.sysSms.esTitle
                this.dataForm.esType = data.sysSms.esType
                this.dataForm.esReceiver = data.sysSms.esReceiver
                this.dataForm.esParam = data.sysSms.esParam
                this.dataForm.esContent = data.sysSms.esContent
                this.dataForm.esSendTime = data.sysSms.esSendTime
                this.dataForm.esSendStatus = data.sysSms.esSendStatus
                this.dataForm.esSendNum = data.sysSms.esSendNum
                this.dataForm.esResult = data.sysSms.esResult
                this.dataForm.remark = data.sysSms.remark
                this.dataForm.createBy = data.sysSms.createBy
                this.dataForm.createTime = data.sysSms.createTime
                this.dataForm.updateBy = data.sysSms.updateBy
                this.dataForm.updateTime = data.sysSms.updateTime
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
              url: this.$http.adornUrl(`/ware/syssms/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'esTitle': this.dataForm.esTitle,
                'esType': this.dataForm.esType,
                'esReceiver': this.dataForm.esReceiver,
                'esParam': this.dataForm.esParam,
                'esContent': this.dataForm.esContent,
                'esSendTime': this.dataForm.esSendTime,
                'esSendStatus': this.dataForm.esSendStatus,
                'esSendNum': this.dataForm.esSendNum,
                'esResult': this.dataForm.esResult,
                'remark': this.dataForm.remark,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
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
