<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="通告ID" prop="anntId">
      <el-input v-model="dataForm.anntId" placeholder="通告ID"></el-input>
    </el-form-item>
    <el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="阅读状态（0未读，1已读）" prop="readFlag">
      <el-input v-model="dataForm.readFlag" placeholder="阅读状态（0未读，1已读）"></el-input>
    </el-form-item>
    <el-form-item label="阅读时间" prop="readTime">
      <el-input v-model="dataForm.readTime" placeholder="阅读时间"></el-input>
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
    <el-form-item label="标星状态( 1为标星 空/0没有标星)" prop="starFlag">
      <el-input v-model="dataForm.starFlag" placeholder="标星状态( 1为标星 空/0没有标星)"></el-input>
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
          anntId: '',
          userId: '',
          readFlag: '',
          readTime: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          starFlag: ''
        },
        dataRule: {
          anntId: [
            { required: true, message: '通告ID不能为空', trigger: 'blur' }
          ],
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          readFlag: [
            { required: true, message: '阅读状态（0未读，1已读）不能为空', trigger: 'blur' }
          ],
          readTime: [
            { required: true, message: '阅读时间不能为空', trigger: 'blur' }
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
          starFlag: [
            { required: true, message: '标星状态( 1为标星 空/0没有标星)不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysannouncementsend/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.anntId = data.sysAnnouncementSend.anntId
                this.dataForm.userId = data.sysAnnouncementSend.userId
                this.dataForm.readFlag = data.sysAnnouncementSend.readFlag
                this.dataForm.readTime = data.sysAnnouncementSend.readTime
                this.dataForm.createBy = data.sysAnnouncementSend.createBy
                this.dataForm.createTime = data.sysAnnouncementSend.createTime
                this.dataForm.updateBy = data.sysAnnouncementSend.updateBy
                this.dataForm.updateTime = data.sysAnnouncementSend.updateTime
                this.dataForm.starFlag = data.sysAnnouncementSend.starFlag
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
              url: this.$http.adornUrl(`/ware/sysannouncementsend/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'anntId': this.dataForm.anntId,
                'userId': this.dataForm.userId,
                'readFlag': this.dataForm.readFlag,
                'readTime': this.dataForm.readTime,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'starFlag': this.dataForm.starFlag
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
