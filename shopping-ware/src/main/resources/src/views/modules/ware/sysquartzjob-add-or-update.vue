<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="删除状态" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="删除状态"></el-input>
    </el-form-item>
    <el-form-item label="修改人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="修改人"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="任务类名" prop="jobClassName">
      <el-input v-model="dataForm.jobClassName" placeholder="任务类名"></el-input>
    </el-form-item>
    <el-form-item label="cron表达式" prop="cronExpression">
      <el-input v-model="dataForm.cronExpression" placeholder="cron表达式"></el-input>
    </el-form-item>
    <el-form-item label="参数" prop="parameter">
      <el-input v-model="dataForm.parameter" placeholder="参数"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="description">
      <el-input v-model="dataForm.description" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="状态 0正常 -1停止" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态 0正常 -1停止"></el-input>
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
          createBy: '',
          createTime: '',
          delFlag: '',
          updateBy: '',
          updateTime: '',
          jobClassName: '',
          cronExpression: '',
          parameter: '',
          description: '',
          status: ''
        },
        dataRule: {
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          delFlag: [
            { required: true, message: '删除状态不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '修改人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          jobClassName: [
            { required: true, message: '任务类名不能为空', trigger: 'blur' }
          ],
          cronExpression: [
            { required: true, message: 'cron表达式不能为空', trigger: 'blur' }
          ],
          parameter: [
            { required: true, message: '参数不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态 0正常 -1停止不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysquartzjob/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.createBy = data.sysQuartzJob.createBy
                this.dataForm.createTime = data.sysQuartzJob.createTime
                this.dataForm.delFlag = data.sysQuartzJob.delFlag
                this.dataForm.updateBy = data.sysQuartzJob.updateBy
                this.dataForm.updateTime = data.sysQuartzJob.updateTime
                this.dataForm.jobClassName = data.sysQuartzJob.jobClassName
                this.dataForm.cronExpression = data.sysQuartzJob.cronExpression
                this.dataForm.parameter = data.sysQuartzJob.parameter
                this.dataForm.description = data.sysQuartzJob.description
                this.dataForm.status = data.sysQuartzJob.status
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
              url: this.$http.adornUrl(`/ware/sysquartzjob/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'delFlag': this.dataForm.delFlag,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'jobClassName': this.dataForm.jobClassName,
                'cronExpression': this.dataForm.cronExpression,
                'parameter': this.dataForm.parameter,
                'description': this.dataForm.description,
                'status': this.dataForm.status
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
