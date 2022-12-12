<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="标题" prop="titile">
      <el-input v-model="dataForm.titile" placeholder="标题"></el-input>
    </el-form-item>
    <el-form-item label="内容" prop="msgContent">
      <el-input v-model="dataForm.msgContent" placeholder="内容"></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="开始时间"></el-input>
    </el-form-item>
    <el-form-item label="结束时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="结束时间"></el-input>
    </el-form-item>
    <el-form-item label="发布人" prop="sender">
      <el-input v-model="dataForm.sender" placeholder="发布人"></el-input>
    </el-form-item>
    <el-form-item label="优先级（L低，M中，H高）" prop="priority">
      <el-input v-model="dataForm.priority" placeholder="优先级（L低，M中，H高）"></el-input>
    </el-form-item>
    <el-form-item label="消息类型1:通知公告2:系统消息" prop="msgCategory">
      <el-input v-model="dataForm.msgCategory" placeholder="消息类型1:通知公告2:系统消息"></el-input>
    </el-form-item>
    <el-form-item label="通告对象类型（USER:指定用户，ALL:全体用户）" prop="msgType">
      <el-input v-model="dataForm.msgType" placeholder="通告对象类型（USER:指定用户，ALL:全体用户）"></el-input>
    </el-form-item>
    <el-form-item label="发布状态（0未发布，1已发布，2已撤销）" prop="sendStatus">
      <el-input v-model="dataForm.sendStatus" placeholder="发布状态（0未发布，1已发布，2已撤销）"></el-input>
    </el-form-item>
    <el-form-item label="发布时间" prop="sendTime">
      <el-input v-model="dataForm.sendTime" placeholder="发布时间"></el-input>
    </el-form-item>
    <el-form-item label="撤销时间" prop="cancelTime">
      <el-input v-model="dataForm.cancelTime" placeholder="撤销时间"></el-input>
    </el-form-item>
    <el-form-item label="删除状态（0，正常，1已删除）" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="删除状态（0，正常，1已删除）"></el-input>
    </el-form-item>
    <el-form-item label="业务类型(email:邮件 bpm:流程)" prop="busType">
      <el-input v-model="dataForm.busType" placeholder="业务类型(email:邮件 bpm:流程)"></el-input>
    </el-form-item>
    <el-form-item label="业务id" prop="busId">
      <el-input v-model="dataForm.busId" placeholder="业务id"></el-input>
    </el-form-item>
    <el-form-item label="打开方式(组件：component 路由：url)" prop="openType">
      <el-input v-model="dataForm.openType" placeholder="打开方式(组件：component 路由：url)"></el-input>
    </el-form-item>
    <el-form-item label="组件/路由 地址" prop="openPage">
      <el-input v-model="dataForm.openPage" placeholder="组件/路由 地址"></el-input>
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
    <el-form-item label="指定用户" prop="userIds">
      <el-input v-model="dataForm.userIds" placeholder="指定用户"></el-input>
    </el-form-item>
    <el-form-item label="摘要" prop="msgAbstract">
      <el-input v-model="dataForm.msgAbstract" placeholder="摘要"></el-input>
    </el-form-item>
    <el-form-item label="钉钉task_id，用于撤回消息" prop="dtTaskId">
      <el-input v-model="dataForm.dtTaskId" placeholder="钉钉task_id，用于撤回消息"></el-input>
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
          titile: '',
          msgContent: '',
          startTime: '',
          endTime: '',
          sender: '',
          priority: '',
          msgCategory: '',
          msgType: '',
          sendStatus: '',
          sendTime: '',
          cancelTime: '',
          delFlag: '',
          busType: '',
          busId: '',
          openType: '',
          openPage: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          userIds: '',
          msgAbstract: '',
          dtTaskId: ''
        },
        dataRule: {
          titile: [
            { required: true, message: '标题不能为空', trigger: 'blur' }
          ],
          msgContent: [
            { required: true, message: '内容不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '开始时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '结束时间不能为空', trigger: 'blur' }
          ],
          sender: [
            { required: true, message: '发布人不能为空', trigger: 'blur' }
          ],
          priority: [
            { required: true, message: '优先级（L低，M中，H高）不能为空', trigger: 'blur' }
          ],
          msgCategory: [
            { required: true, message: '消息类型1:通知公告2:系统消息不能为空', trigger: 'blur' }
          ],
          msgType: [
            { required: true, message: '通告对象类型（USER:指定用户，ALL:全体用户）不能为空', trigger: 'blur' }
          ],
          sendStatus: [
            { required: true, message: '发布状态（0未发布，1已发布，2已撤销）不能为空', trigger: 'blur' }
          ],
          sendTime: [
            { required: true, message: '发布时间不能为空', trigger: 'blur' }
          ],
          cancelTime: [
            { required: true, message: '撤销时间不能为空', trigger: 'blur' }
          ],
          delFlag: [
            { required: true, message: '删除状态（0，正常，1已删除）不能为空', trigger: 'blur' }
          ],
          busType: [
            { required: true, message: '业务类型(email:邮件 bpm:流程)不能为空', trigger: 'blur' }
          ],
          busId: [
            { required: true, message: '业务id不能为空', trigger: 'blur' }
          ],
          openType: [
            { required: true, message: '打开方式(组件：component 路由：url)不能为空', trigger: 'blur' }
          ],
          openPage: [
            { required: true, message: '组件/路由 地址不能为空', trigger: 'blur' }
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
          ],
          userIds: [
            { required: true, message: '指定用户不能为空', trigger: 'blur' }
          ],
          msgAbstract: [
            { required: true, message: '摘要不能为空', trigger: 'blur' }
          ],
          dtTaskId: [
            { required: true, message: '钉钉task_id，用于撤回消息不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysannouncement/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.titile = data.sysAnnouncement.titile
                this.dataForm.msgContent = data.sysAnnouncement.msgContent
                this.dataForm.startTime = data.sysAnnouncement.startTime
                this.dataForm.endTime = data.sysAnnouncement.endTime
                this.dataForm.sender = data.sysAnnouncement.sender
                this.dataForm.priority = data.sysAnnouncement.priority
                this.dataForm.msgCategory = data.sysAnnouncement.msgCategory
                this.dataForm.msgType = data.sysAnnouncement.msgType
                this.dataForm.sendStatus = data.sysAnnouncement.sendStatus
                this.dataForm.sendTime = data.sysAnnouncement.sendTime
                this.dataForm.cancelTime = data.sysAnnouncement.cancelTime
                this.dataForm.delFlag = data.sysAnnouncement.delFlag
                this.dataForm.busType = data.sysAnnouncement.busType
                this.dataForm.busId = data.sysAnnouncement.busId
                this.dataForm.openType = data.sysAnnouncement.openType
                this.dataForm.openPage = data.sysAnnouncement.openPage
                this.dataForm.createBy = data.sysAnnouncement.createBy
                this.dataForm.createTime = data.sysAnnouncement.createTime
                this.dataForm.updateBy = data.sysAnnouncement.updateBy
                this.dataForm.updateTime = data.sysAnnouncement.updateTime
                this.dataForm.userIds = data.sysAnnouncement.userIds
                this.dataForm.msgAbstract = data.sysAnnouncement.msgAbstract
                this.dataForm.dtTaskId = data.sysAnnouncement.dtTaskId
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
              url: this.$http.adornUrl(`/ware/sysannouncement/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'titile': this.dataForm.titile,
                'msgContent': this.dataForm.msgContent,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime,
                'sender': this.dataForm.sender,
                'priority': this.dataForm.priority,
                'msgCategory': this.dataForm.msgCategory,
                'msgType': this.dataForm.msgType,
                'sendStatus': this.dataForm.sendStatus,
                'sendTime': this.dataForm.sendTime,
                'cancelTime': this.dataForm.cancelTime,
                'delFlag': this.dataForm.delFlag,
                'busType': this.dataForm.busType,
                'busId': this.dataForm.busId,
                'openType': this.dataForm.openType,
                'openPage': this.dataForm.openPage,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'userIds': this.dataForm.userIds,
                'msgAbstract': this.dataForm.msgAbstract,
                'dtTaskId': this.dataForm.dtTaskId
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
