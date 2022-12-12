<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="在线excel设计器id" prop="reportId">
      <el-input v-model="dataForm.reportId" placeholder="在线excel设计器id"></el-input>
    </el-form-item>
    <el-form-item label="预览地址" prop="previewUrl">
      <el-input v-model="dataForm.previewUrl" placeholder="预览地址"></el-input>
    </el-form-item>
    <el-form-item label="密码锁" prop="previewLock">
      <el-input v-model="dataForm.previewLock" placeholder="密码锁"></el-input>
    </el-form-item>
    <el-form-item label="最后更新时间" prop="lastUpdateTime">
      <el-input v-model="dataForm.lastUpdateTime" placeholder="最后更新时间"></el-input>
    </el-form-item>
    <el-form-item label="有效期(0:永久有效，1:1天，2:7天)" prop="termOfValidity">
      <el-input v-model="dataForm.termOfValidity" placeholder="有效期(0:永久有效，1:1天，2:7天)"></el-input>
    </el-form-item>
    <el-form-item label="是否过期(0未过期，1已过期)" prop="status">
      <el-input v-model="dataForm.status" placeholder="是否过期(0未过期，1已过期)"></el-input>
    </el-form-item>
    <el-form-item label="是否为密码锁(0 否,1是)" prop="previewLockStatus">
      <el-input v-model="dataForm.previewLockStatus" placeholder="是否为密码锁(0 否,1是)"></el-input>
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
          reportId: '',
          previewUrl: '',
          previewLock: '',
          lastUpdateTime: '',
          termOfValidity: '',
          status: '',
          previewLockStatus: ''
        },
        dataRule: {
          reportId: [
            { required: true, message: '在线excel设计器id不能为空', trigger: 'blur' }
          ],
          previewUrl: [
            { required: true, message: '预览地址不能为空', trigger: 'blur' }
          ],
          previewLock: [
            { required: true, message: '密码锁不能为空', trigger: 'blur' }
          ],
          lastUpdateTime: [
            { required: true, message: '最后更新时间不能为空', trigger: 'blur' }
          ],
          termOfValidity: [
            { required: true, message: '有效期(0:永久有效，1:1天，2:7天)不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '是否过期(0未过期，1已过期)不能为空', trigger: 'blur' }
          ],
          previewLockStatus: [
            { required: true, message: '是否为密码锁(0 否,1是)不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jimureportshare/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.reportId = data.jimuReportShare.reportId
                this.dataForm.previewUrl = data.jimuReportShare.previewUrl
                this.dataForm.previewLock = data.jimuReportShare.previewLock
                this.dataForm.lastUpdateTime = data.jimuReportShare.lastUpdateTime
                this.dataForm.termOfValidity = data.jimuReportShare.termOfValidity
                this.dataForm.status = data.jimuReportShare.status
                this.dataForm.previewLockStatus = data.jimuReportShare.previewLockStatus
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
              url: this.$http.adornUrl(`/ware/jimureportshare/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'reportId': this.dataForm.reportId,
                'previewUrl': this.dataForm.previewUrl,
                'previewLock': this.dataForm.previewLock,
                'lastUpdateTime': this.dataForm.lastUpdateTime,
                'termOfValidity': this.dataForm.termOfValidity,
                'status': this.dataForm.status,
                'previewLockStatus': this.dataForm.previewLockStatus
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
