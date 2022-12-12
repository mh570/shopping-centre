<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="主键字段" prop="jimuReportId">
      <el-input v-model="dataForm.jimuReportId" placeholder="主键字段"></el-input>
    </el-form-item>
    <el-form-item label="创建人登录名称" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人登录名称"></el-input>
    </el-form-item>
    <el-form-item label="更新人登录名称" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人登录名称"></el-input>
    </el-form-item>
    <el-form-item label="创建日期" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建日期"></el-input>
    </el-form-item>
    <el-form-item label="更新日期" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新日期"></el-input>
    </el-form-item>
    <el-form-item label="数据集编码" prop="dbCode">
      <el-input v-model="dataForm.dbCode" placeholder="数据集编码"></el-input>
    </el-form-item>
    <el-form-item label="数据集名字" prop="dbChName">
      <el-input v-model="dataForm.dbChName" placeholder="数据集名字"></el-input>
    </el-form-item>
    <el-form-item label="数据源类型" prop="dbType">
      <el-input v-model="dataForm.dbType" placeholder="数据源类型"></el-input>
    </el-form-item>
    <el-form-item label="数据库表名" prop="dbTableName">
      <el-input v-model="dataForm.dbTableName" placeholder="数据库表名"></el-input>
    </el-form-item>
    <el-form-item label="动态查询SQL" prop="dbDynSql">
      <el-input v-model="dataForm.dbDynSql" placeholder="动态查询SQL"></el-input>
    </el-form-item>
    <el-form-item label="数据源KEY" prop="dbKey">
      <el-input v-model="dataForm.dbKey" placeholder="数据源KEY"></el-input>
    </el-form-item>
    <el-form-item label="填报数据源" prop="tbDbKey">
      <el-input v-model="dataForm.tbDbKey" placeholder="填报数据源"></el-input>
    </el-form-item>
    <el-form-item label="填报数据表" prop="tbDbTableName">
      <el-input v-model="dataForm.tbDbTableName" placeholder="填报数据表"></el-input>
    </el-form-item>
    <el-form-item label="java类数据集  类型（spring:springkey,class:java类名）" prop="javaType">
      <el-input v-model="dataForm.javaType" placeholder="java类数据集  类型（spring:springkey,class:java类名）"></el-input>
    </el-form-item>
    <el-form-item label="java类数据源  数值（bean key/java类名）" prop="javaValue">
      <el-input v-model="dataForm.javaValue" placeholder="java类数据源  数值（bean key/java类名）"></el-input>
    </el-form-item>
    <el-form-item label="请求地址" prop="apiUrl">
      <el-input v-model="dataForm.apiUrl" placeholder="请求地址"></el-input>
    </el-form-item>
    <el-form-item label="请求方法0-get,1-post" prop="apiMethod">
      <el-input v-model="dataForm.apiMethod" placeholder="请求方法0-get,1-post"></el-input>
    </el-form-item>
    <el-form-item label="是否是列表0否1是 默认0" prop="isList">
      <el-input v-model="dataForm.isList" placeholder="是否是列表0否1是 默认0"></el-input>
    </el-form-item>
    <el-form-item label="是否作为分页,0:不分页，1:分页" prop="isPage">
      <el-input v-model="dataForm.isPage" placeholder="是否作为分页,0:不分页，1:分页"></el-input>
    </el-form-item>
    <el-form-item label="数据源" prop="dbSource">
      <el-input v-model="dataForm.dbSource" placeholder="数据源"></el-input>
    </el-form-item>
    <el-form-item label="数据库类型 MYSQL ORACLE SQLSERVER" prop="dbSourceType">
      <el-input v-model="dataForm.dbSourceType" placeholder="数据库类型 MYSQL ORACLE SQLSERVER"></el-input>
    </el-form-item>
    <el-form-item label="json数据，直接解析json内容" prop="jsonData">
      <el-input v-model="dataForm.jsonData" placeholder="json数据，直接解析json内容"></el-input>
    </el-form-item>
    <el-form-item label="api转换器" prop="apiConvert">
      <el-input v-model="dataForm.apiConvert" placeholder="api转换器"></el-input>
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
          jimuReportId: '',
          createBy: '',
          updateBy: '',
          createTime: '',
          updateTime: '',
          dbCode: '',
          dbChName: '',
          dbType: '',
          dbTableName: '',
          dbDynSql: '',
          dbKey: '',
          tbDbKey: '',
          tbDbTableName: '',
          javaType: '',
          javaValue: '',
          apiUrl: '',
          apiMethod: '',
          isList: '',
          isPage: '',
          dbSource: '',
          dbSourceType: '',
          jsonData: '',
          apiConvert: ''
        },
        dataRule: {
          jimuReportId: [
            { required: true, message: '主键字段不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人登录名称不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人登录名称不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建日期不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新日期不能为空', trigger: 'blur' }
          ],
          dbCode: [
            { required: true, message: '数据集编码不能为空', trigger: 'blur' }
          ],
          dbChName: [
            { required: true, message: '数据集名字不能为空', trigger: 'blur' }
          ],
          dbType: [
            { required: true, message: '数据源类型不能为空', trigger: 'blur' }
          ],
          dbTableName: [
            { required: true, message: '数据库表名不能为空', trigger: 'blur' }
          ],
          dbDynSql: [
            { required: true, message: '动态查询SQL不能为空', trigger: 'blur' }
          ],
          dbKey: [
            { required: true, message: '数据源KEY不能为空', trigger: 'blur' }
          ],
          tbDbKey: [
            { required: true, message: '填报数据源不能为空', trigger: 'blur' }
          ],
          tbDbTableName: [
            { required: true, message: '填报数据表不能为空', trigger: 'blur' }
          ],
          javaType: [
            { required: true, message: 'java类数据集  类型（spring:springkey,class:java类名）不能为空', trigger: 'blur' }
          ],
          javaValue: [
            { required: true, message: 'java类数据源  数值（bean key/java类名）不能为空', trigger: 'blur' }
          ],
          apiUrl: [
            { required: true, message: '请求地址不能为空', trigger: 'blur' }
          ],
          apiMethod: [
            { required: true, message: '请求方法0-get,1-post不能为空', trigger: 'blur' }
          ],
          isList: [
            { required: true, message: '是否是列表0否1是 默认0不能为空', trigger: 'blur' }
          ],
          isPage: [
            { required: true, message: '是否作为分页,0:不分页，1:分页不能为空', trigger: 'blur' }
          ],
          dbSource: [
            { required: true, message: '数据源不能为空', trigger: 'blur' }
          ],
          dbSourceType: [
            { required: true, message: '数据库类型 MYSQL ORACLE SQLSERVER不能为空', trigger: 'blur' }
          ],
          jsonData: [
            { required: true, message: 'json数据，直接解析json内容不能为空', trigger: 'blur' }
          ],
          apiConvert: [
            { required: true, message: 'api转换器不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jimureportdb/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.jimuReportId = data.jimuReportDb.jimuReportId
                this.dataForm.createBy = data.jimuReportDb.createBy
                this.dataForm.updateBy = data.jimuReportDb.updateBy
                this.dataForm.createTime = data.jimuReportDb.createTime
                this.dataForm.updateTime = data.jimuReportDb.updateTime
                this.dataForm.dbCode = data.jimuReportDb.dbCode
                this.dataForm.dbChName = data.jimuReportDb.dbChName
                this.dataForm.dbType = data.jimuReportDb.dbType
                this.dataForm.dbTableName = data.jimuReportDb.dbTableName
                this.dataForm.dbDynSql = data.jimuReportDb.dbDynSql
                this.dataForm.dbKey = data.jimuReportDb.dbKey
                this.dataForm.tbDbKey = data.jimuReportDb.tbDbKey
                this.dataForm.tbDbTableName = data.jimuReportDb.tbDbTableName
                this.dataForm.javaType = data.jimuReportDb.javaType
                this.dataForm.javaValue = data.jimuReportDb.javaValue
                this.dataForm.apiUrl = data.jimuReportDb.apiUrl
                this.dataForm.apiMethod = data.jimuReportDb.apiMethod
                this.dataForm.isList = data.jimuReportDb.isList
                this.dataForm.isPage = data.jimuReportDb.isPage
                this.dataForm.dbSource = data.jimuReportDb.dbSource
                this.dataForm.dbSourceType = data.jimuReportDb.dbSourceType
                this.dataForm.jsonData = data.jimuReportDb.jsonData
                this.dataForm.apiConvert = data.jimuReportDb.apiConvert
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
              url: this.$http.adornUrl(`/ware/jimureportdb/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'jimuReportId': this.dataForm.jimuReportId,
                'createBy': this.dataForm.createBy,
                'updateBy': this.dataForm.updateBy,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'dbCode': this.dataForm.dbCode,
                'dbChName': this.dataForm.dbChName,
                'dbType': this.dataForm.dbType,
                'dbTableName': this.dataForm.dbTableName,
                'dbDynSql': this.dataForm.dbDynSql,
                'dbKey': this.dataForm.dbKey,
                'tbDbKey': this.dataForm.tbDbKey,
                'tbDbTableName': this.dataForm.tbDbTableName,
                'javaType': this.dataForm.javaType,
                'javaValue': this.dataForm.javaValue,
                'apiUrl': this.dataForm.apiUrl,
                'apiMethod': this.dataForm.apiMethod,
                'isList': this.dataForm.isList,
                'isPage': this.dataForm.isPage,
                'dbSource': this.dataForm.dbSource,
                'dbSourceType': this.dataForm.dbSourceType,
                'jsonData': this.dataForm.jsonData,
                'apiConvert': this.dataForm.apiConvert
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
