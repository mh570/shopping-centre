<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="动态报表ID" prop="jimuReportHeadId">
      <el-input v-model="dataForm.jimuReportHeadId" placeholder="动态报表ID"></el-input>
    </el-form-item>
    <el-form-item label="参数字段" prop="paramName">
      <el-input v-model="dataForm.paramName" placeholder="参数字段"></el-input>
    </el-form-item>
    <el-form-item label="参数文本" prop="paramTxt">
      <el-input v-model="dataForm.paramTxt" placeholder="参数文本"></el-input>
    </el-form-item>
    <el-form-item label="参数默认值" prop="paramValue">
      <el-input v-model="dataForm.paramValue" placeholder="参数默认值"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="orderNum">
      <el-input v-model="dataForm.orderNum" placeholder="排序"></el-input>
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
    <el-form-item label="查询标识0否1是 默认0" prop="searchFlag">
      <el-input v-model="dataForm.searchFlag" placeholder="查询标识0否1是 默认0"></el-input>
    </el-form-item>
    <el-form-item label="查询控件类型" prop="widgetType">
      <el-input v-model="dataForm.widgetType" placeholder="查询控件类型"></el-input>
    </el-form-item>
    <el-form-item label="查询模式1简单2范围" prop="searchMode">
      <el-input v-model="dataForm.searchMode" placeholder="查询模式1简单2范围"></el-input>
    </el-form-item>
    <el-form-item label="字典" prop="dictCode">
      <el-input v-model="dataForm.dictCode" placeholder="字典"></el-input>
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
          jimuReportHeadId: '',
          paramName: '',
          paramTxt: '',
          paramValue: '',
          orderNum: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          searchFlag: '',
          widgetType: '',
          searchMode: '',
          dictCode: '',
          searchFormat: '',
          extJson: ''
        },
        dataRule: {
          jimuReportHeadId: [
            { required: true, message: '动态报表ID不能为空', trigger: 'blur' }
          ],
          paramName: [
            { required: true, message: '参数字段不能为空', trigger: 'blur' }
          ],
          paramTxt: [
            { required: true, message: '参数文本不能为空', trigger: 'blur' }
          ],
          paramValue: [
            { required: true, message: '参数默认值不能为空', trigger: 'blur' }
          ],
          orderNum: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
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
          ],
          searchFlag: [
            { required: true, message: '查询标识0否1是 默认0不能为空', trigger: 'blur' }
          ],
          widgetType: [
            { required: true, message: '查询控件类型不能为空', trigger: 'blur' }
          ],
          searchMode: [
            { required: true, message: '查询模式1简单2范围不能为空', trigger: 'blur' }
          ],
          dictCode: [
            { required: true, message: '字典不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jimureportdbparam/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.jimuReportHeadId = data.jimuReportDbParam.jimuReportHeadId
                this.dataForm.paramName = data.jimuReportDbParam.paramName
                this.dataForm.paramTxt = data.jimuReportDbParam.paramTxt
                this.dataForm.paramValue = data.jimuReportDbParam.paramValue
                this.dataForm.orderNum = data.jimuReportDbParam.orderNum
                this.dataForm.createBy = data.jimuReportDbParam.createBy
                this.dataForm.createTime = data.jimuReportDbParam.createTime
                this.dataForm.updateBy = data.jimuReportDbParam.updateBy
                this.dataForm.updateTime = data.jimuReportDbParam.updateTime
                this.dataForm.searchFlag = data.jimuReportDbParam.searchFlag
                this.dataForm.widgetType = data.jimuReportDbParam.widgetType
                this.dataForm.searchMode = data.jimuReportDbParam.searchMode
                this.dataForm.dictCode = data.jimuReportDbParam.dictCode
                this.dataForm.searchFormat = data.jimuReportDbParam.searchFormat
                this.dataForm.extJson = data.jimuReportDbParam.extJson
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
              url: this.$http.adornUrl(`/ware/jimureportdbparam/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'jimuReportHeadId': this.dataForm.jimuReportHeadId,
                'paramName': this.dataForm.paramName,
                'paramTxt': this.dataForm.paramTxt,
                'paramValue': this.dataForm.paramValue,
                'orderNum': this.dataForm.orderNum,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'searchFlag': this.dataForm.searchFlag,
                'widgetType': this.dataForm.widgetType,
                'searchMode': this.dataForm.searchMode,
                'dictCode': this.dataForm.dictCode,
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
