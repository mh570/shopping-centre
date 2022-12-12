<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
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
    <el-form-item label="数据源ID" prop="jimuReportDbId">
      <el-input v-model="dataForm.jimuReportDbId" placeholder="数据源ID"></el-input>
    </el-form-item>
    <el-form-item label="字段名" prop="fieldName">
      <el-input v-model="dataForm.fieldName" placeholder="字段名"></el-input>
    </el-form-item>
    <el-form-item label="字段文本" prop="fieldText">
      <el-input v-model="dataForm.fieldText" placeholder="字段文本"></el-input>
    </el-form-item>
    <el-form-item label="控件类型" prop="widgetType">
      <el-input v-model="dataForm.widgetType" placeholder="控件类型"></el-input>
    </el-form-item>
    <el-form-item label="控件宽度" prop="widgetWidth">
      <el-input v-model="dataForm.widgetWidth" placeholder="控件宽度"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="orderNum">
      <el-input v-model="dataForm.orderNum" placeholder="排序"></el-input>
    </el-form-item>
    <el-form-item label="查询标识0否1是 默认0" prop="searchFlag">
      <el-input v-model="dataForm.searchFlag" placeholder="查询标识0否1是 默认0"></el-input>
    </el-form-item>
    <el-form-item label="查询模式1简单2范围" prop="searchMode">
      <el-input v-model="dataForm.searchMode" placeholder="查询模式1简单2范围"></el-input>
    </el-form-item>
    <el-form-item label="字典编码支持从表中取数据" prop="dictCode">
      <el-input v-model="dataForm.dictCode" placeholder="字典编码支持从表中取数据"></el-input>
    </el-form-item>
    <el-form-item label="查询默认值" prop="searchValue">
      <el-input v-model="dataForm.searchValue" placeholder="查询默认值"></el-input>
    </el-form-item>
    <el-form-item label="查询时间格式化表达式" prop="searchFormat">
      <el-input v-model="dataForm.searchFormat" placeholder="查询时间格式化表达式"></el-input>
    </el-form-item>
    <el-form-item label="参数配置" prop="extJson">
      <el-input v-model="dataForm.extJson" placeholder="参数配置"></el-input>
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
          updateBy: '',
          updateTime: '',
          jimuReportDbId: '',
          fieldName: '',
          fieldText: '',
          widgetType: '',
          widgetWidth: '',
          orderNum: '',
          searchFlag: '',
          searchMode: '',
          dictCode: '',
          searchValue: '',
          searchFormat: '',
          extJson: ''
        },
        dataRule: {
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
          ],
          jimuReportDbId: [
            { required: true, message: '数据源ID不能为空', trigger: 'blur' }
          ],
          fieldName: [
            { required: true, message: '字段名不能为空', trigger: 'blur' }
          ],
          fieldText: [
            { required: true, message: '字段文本不能为空', trigger: 'blur' }
          ],
          widgetType: [
            { required: true, message: '控件类型不能为空', trigger: 'blur' }
          ],
          widgetWidth: [
            { required: true, message: '控件宽度不能为空', trigger: 'blur' }
          ],
          orderNum: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ],
          searchFlag: [
            { required: true, message: '查询标识0否1是 默认0不能为空', trigger: 'blur' }
          ],
          searchMode: [
            { required: true, message: '查询模式1简单2范围不能为空', trigger: 'blur' }
          ],
          dictCode: [
            { required: true, message: '字典编码支持从表中取数据不能为空', trigger: 'blur' }
          ],
          searchValue: [
            { required: true, message: '查询默认值不能为空', trigger: 'blur' }
          ],
          searchFormat: [
            { required: true, message: '查询时间格式化表达式不能为空', trigger: 'blur' }
          ],
          extJson: [
            { required: true, message: '参数配置不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jimureportdbfield/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.createBy = data.jimuReportDbField.createBy
                this.dataForm.createTime = data.jimuReportDbField.createTime
                this.dataForm.updateBy = data.jimuReportDbField.updateBy
                this.dataForm.updateTime = data.jimuReportDbField.updateTime
                this.dataForm.jimuReportDbId = data.jimuReportDbField.jimuReportDbId
                this.dataForm.fieldName = data.jimuReportDbField.fieldName
                this.dataForm.fieldText = data.jimuReportDbField.fieldText
                this.dataForm.widgetType = data.jimuReportDbField.widgetType
                this.dataForm.widgetWidth = data.jimuReportDbField.widgetWidth
                this.dataForm.orderNum = data.jimuReportDbField.orderNum
                this.dataForm.searchFlag = data.jimuReportDbField.searchFlag
                this.dataForm.searchMode = data.jimuReportDbField.searchMode
                this.dataForm.dictCode = data.jimuReportDbField.dictCode
                this.dataForm.searchValue = data.jimuReportDbField.searchValue
                this.dataForm.searchFormat = data.jimuReportDbField.searchFormat
                this.dataForm.extJson = data.jimuReportDbField.extJson
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
              url: this.$http.adornUrl(`/ware/jimureportdbfield/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'jimuReportDbId': this.dataForm.jimuReportDbId,
                'fieldName': this.dataForm.fieldName,
                'fieldText': this.dataForm.fieldText,
                'widgetType': this.dataForm.widgetType,
                'widgetWidth': this.dataForm.widgetWidth,
                'orderNum': this.dataForm.orderNum,
                'searchFlag': this.dataForm.searchFlag,
                'searchMode': this.dataForm.searchMode,
                'dictCode': this.dataForm.dictCode,
                'searchValue': this.dataForm.searchValue,
                'searchFormat': this.dataForm.searchFormat,
                'extJson': this.dataForm.extJson
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
