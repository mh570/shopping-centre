<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="日志类型（1登录日志，2操作日志）" prop="logType">
      <el-input v-model="dataForm.logType" placeholder="日志类型（1登录日志，2操作日志）"></el-input>
    </el-form-item>
    <el-form-item label="日志内容" prop="logContent">
      <el-input v-model="dataForm.logContent" placeholder="日志内容"></el-input>
    </el-form-item>
    <el-form-item label="操作类型" prop="operateType">
      <el-input v-model="dataForm.operateType" placeholder="操作类型"></el-input>
    </el-form-item>
    <el-form-item label="操作用户账号" prop="userid">
      <el-input v-model="dataForm.userid" placeholder="操作用户账号"></el-input>
    </el-form-item>
    <el-form-item label="操作用户名称" prop="username">
      <el-input v-model="dataForm.username" placeholder="操作用户名称"></el-input>
    </el-form-item>
    <el-form-item label="IP" prop="ip">
      <el-input v-model="dataForm.ip" placeholder="IP"></el-input>
    </el-form-item>
    <el-form-item label="请求java方法" prop="method">
      <el-input v-model="dataForm.method" placeholder="请求java方法"></el-input>
    </el-form-item>
    <el-form-item label="请求路径" prop="requestUrl">
      <el-input v-model="dataForm.requestUrl" placeholder="请求路径"></el-input>
    </el-form-item>
    <el-form-item label="请求参数" prop="requestParam">
      <el-input v-model="dataForm.requestParam" placeholder="请求参数"></el-input>
    </el-form-item>
    <el-form-item label="请求类型" prop="requestType">
      <el-input v-model="dataForm.requestType" placeholder="请求类型"></el-input>
    </el-form-item>
    <el-form-item label="耗时" prop="costTime">
      <el-input v-model="dataForm.costTime" placeholder="耗时"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
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
          logType: '',
          logContent: '',
          operateType: '',
          userid: '',
          username: '',
          ip: '',
          method: '',
          requestUrl: '',
          requestParam: '',
          requestType: '',
          costTime: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: ''
        },
        dataRule: {
          logType: [
            { required: true, message: '日志类型（1登录日志，2操作日志）不能为空', trigger: 'blur' }
          ],
          logContent: [
            { required: true, message: '日志内容不能为空', trigger: 'blur' }
          ],
          operateType: [
            { required: true, message: '操作类型不能为空', trigger: 'blur' }
          ],
          userid: [
            { required: true, message: '操作用户账号不能为空', trigger: 'blur' }
          ],
          username: [
            { required: true, message: '操作用户名称不能为空', trigger: 'blur' }
          ],
          ip: [
            { required: true, message: 'IP不能为空', trigger: 'blur' }
          ],
          method: [
            { required: true, message: '请求java方法不能为空', trigger: 'blur' }
          ],
          requestUrl: [
            { required: true, message: '请求路径不能为空', trigger: 'blur' }
          ],
          requestParam: [
            { required: true, message: '请求参数不能为空', trigger: 'blur' }
          ],
          requestType: [
            { required: true, message: '请求类型不能为空', trigger: 'blur' }
          ],
          costTime: [
            { required: true, message: '耗时不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/syslog/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.logType = data.sysLog.logType
                this.dataForm.logContent = data.sysLog.logContent
                this.dataForm.operateType = data.sysLog.operateType
                this.dataForm.userid = data.sysLog.userid
                this.dataForm.username = data.sysLog.username
                this.dataForm.ip = data.sysLog.ip
                this.dataForm.method = data.sysLog.method
                this.dataForm.requestUrl = data.sysLog.requestUrl
                this.dataForm.requestParam = data.sysLog.requestParam
                this.dataForm.requestType = data.sysLog.requestType
                this.dataForm.costTime = data.sysLog.costTime
                this.dataForm.createBy = data.sysLog.createBy
                this.dataForm.createTime = data.sysLog.createTime
                this.dataForm.updateBy = data.sysLog.updateBy
                this.dataForm.updateTime = data.sysLog.updateTime
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
              url: this.$http.adornUrl(`/ware/syslog/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'logType': this.dataForm.logType,
                'logContent': this.dataForm.logContent,
                'operateType': this.dataForm.operateType,
                'userid': this.dataForm.userid,
                'username': this.dataForm.username,
                'ip': this.dataForm.ip,
                'method': this.dataForm.method,
                'requestUrl': this.dataForm.requestUrl,
                'requestParam': this.dataForm.requestParam,
                'requestType': this.dataForm.requestType,
                'costTime': this.dataForm.costTime,
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
