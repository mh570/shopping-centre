<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="请假人" prop="name">
      <el-input v-model="dataForm.name" placeholder="请假人"></el-input>
    </el-form-item>
    <el-form-item label="请假天数" prop="days">
      <el-input v-model="dataForm.days" placeholder="请假天数"></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="beginDate">
      <el-input v-model="dataForm.beginDate" placeholder="开始时间"></el-input>
    </el-form-item>
    <el-form-item label="请假结束时间" prop="endDate">
      <el-input v-model="dataForm.endDate" placeholder="请假结束时间"></el-input>
    </el-form-item>
    <el-form-item label="请假原因" prop="reason">
      <el-input v-model="dataForm.reason" placeholder="请假原因"></el-input>
    </el-form-item>
    <el-form-item label="流程状态" prop="bpmStatus">
      <el-input v-model="dataForm.bpmStatus" placeholder="流程状态"></el-input>
    </el-form-item>
    <el-form-item label="创建人id" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人id"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="修改人id" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="修改人id"></el-input>
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
          name: '',
          days: '',
          beginDate: '',
          endDate: '',
          reason: '',
          bpmStatus: '',
          createBy: '',
          createTime: '',
          updateTime: '',
          updateBy: ''
        },
        dataRule: {
          name: [
            { required: true, message: '请假人不能为空', trigger: 'blur' }
          ],
          days: [
            { required: true, message: '请假天数不能为空', trigger: 'blur' }
          ],
          beginDate: [
            { required: true, message: '开始时间不能为空', trigger: 'blur' }
          ],
          endDate: [
            { required: true, message: '请假结束时间不能为空', trigger: 'blur' }
          ],
          reason: [
            { required: true, message: '请假原因不能为空', trigger: 'blur' }
          ],
          bpmStatus: [
            { required: true, message: '流程状态不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人id不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '修改人id不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/joademo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.joaDemo.name
                this.dataForm.days = data.joaDemo.days
                this.dataForm.beginDate = data.joaDemo.beginDate
                this.dataForm.endDate = data.joaDemo.endDate
                this.dataForm.reason = data.joaDemo.reason
                this.dataForm.bpmStatus = data.joaDemo.bpmStatus
                this.dataForm.createBy = data.joaDemo.createBy
                this.dataForm.createTime = data.joaDemo.createTime
                this.dataForm.updateTime = data.joaDemo.updateTime
                this.dataForm.updateBy = data.joaDemo.updateBy
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
              url: this.$http.adornUrl(`/ware/joademo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'days': this.dataForm.days,
                'beginDate': this.dataForm.beginDate,
                'endDate': this.dataForm.endDate,
                'reason': this.dataForm.reason,
                'bpmStatus': this.dataForm.bpmStatus,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'updateBy': this.dataForm.updateBy
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
