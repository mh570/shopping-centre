<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="积木设计器id" prop="reportId">
      <el-input v-model="dataForm.reportId" placeholder="积木设计器id"></el-input>
    </el-form-item>
    <el-form-item label="参数" prop="parameter">
      <el-input v-model="dataForm.parameter" placeholder="参数"></el-input>
    </el-form-item>
    <el-form-item label="弹出方式（0 当前页面 1 新窗口）" prop="ejectType">
      <el-input v-model="dataForm.ejectType" placeholder="弹出方式（0 当前页面 1 新窗口）"></el-input>
    </el-form-item>
    <el-form-item label="链接名称" prop="linkName">
      <el-input v-model="dataForm.linkName" placeholder="链接名称"></el-input>
    </el-form-item>
    <el-form-item label="请求方法0-get,1-post" prop="apiMethod">
      <el-input v-model="dataForm.apiMethod" placeholder="请求方法0-get,1-post"></el-input>
    </el-form-item>
    <el-form-item label="链接方式(0 网络报表 1 网络连接 2 图表联动)" prop="linkType">
      <el-input v-model="dataForm.linkType" placeholder="链接方式(0 网络报表 1 网络连接 2 图表联动)"></el-input>
    </el-form-item>
    <el-form-item label="外网api" prop="apiUrl">
      <el-input v-model="dataForm.apiUrl" placeholder="外网api"></el-input>
    </el-form-item>
    <el-form-item label="联动图表的ID" prop="linkChartId">
      <el-input v-model="dataForm.linkChartId" placeholder="联动图表的ID"></el-input>
    </el-form-item>
    <el-form-item label="条件" prop="requirement">
      <el-input v-model="dataForm.requirement" placeholder="条件"></el-input>
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
          parameter: '',
          ejectType: '',
          linkName: '',
          apiMethod: '',
          linkType: '',
          apiUrl: '',
          linkChartId: '',
          requirement: ''
        },
        dataRule: {
          reportId: [
            { required: true, message: '积木设计器id不能为空', trigger: 'blur' }
          ],
          parameter: [
            { required: true, message: '参数不能为空', trigger: 'blur' }
          ],
          ejectType: [
            { required: true, message: '弹出方式（0 当前页面 1 新窗口）不能为空', trigger: 'blur' }
          ],
          linkName: [
            { required: true, message: '链接名称不能为空', trigger: 'blur' }
          ],
          apiMethod: [
            { required: true, message: '请求方法0-get,1-post不能为空', trigger: 'blur' }
          ],
          linkType: [
            { required: true, message: '链接方式(0 网络报表 1 网络连接 2 图表联动)不能为空', trigger: 'blur' }
          ],
          apiUrl: [
            { required: true, message: '外网api不能为空', trigger: 'blur' }
          ],
          linkChartId: [
            { required: true, message: '联动图表的ID不能为空', trigger: 'blur' }
          ],
          requirement: [
            { required: true, message: '条件不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jimureportlink/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.reportId = data.jimuReportLink.reportId
                this.dataForm.parameter = data.jimuReportLink.parameter
                this.dataForm.ejectType = data.jimuReportLink.ejectType
                this.dataForm.linkName = data.jimuReportLink.linkName
                this.dataForm.apiMethod = data.jimuReportLink.apiMethod
                this.dataForm.linkType = data.jimuReportLink.linkType
                this.dataForm.apiUrl = data.jimuReportLink.apiUrl
                this.dataForm.linkChartId = data.jimuReportLink.linkChartId
                this.dataForm.requirement = data.jimuReportLink.requirement
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
              url: this.$http.adornUrl(`/ware/jimureportlink/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'reportId': this.dataForm.reportId,
                'parameter': this.dataForm.parameter,
                'ejectType': this.dataForm.ejectType,
                'linkName': this.dataForm.linkName,
                'apiMethod': this.dataForm.apiMethod,
                'linkType': this.dataForm.linkType,
                'apiUrl': this.dataForm.apiUrl,
                'linkChartId': this.dataForm.linkChartId,
                'requirement': this.dataForm.requirement
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
