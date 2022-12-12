<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="表ID" prop="cgformHeadId">
      <el-input v-model="dataForm.cgformHeadId" placeholder="表ID"></el-input>
    </el-form-item>
    <el-form-item label="字段名字" prop="dbFieldName">
      <el-input v-model="dataForm.dbFieldName" placeholder="字段名字"></el-input>
    </el-form-item>
    <el-form-item label="字段备注" prop="dbFieldTxt">
      <el-input v-model="dataForm.dbFieldTxt" placeholder="字段备注"></el-input>
    </el-form-item>
    <el-form-item label="原字段名" prop="dbFieldNameOld">
      <el-input v-model="dataForm.dbFieldNameOld" placeholder="原字段名"></el-input>
    </el-form-item>
    <el-form-item label="是否主键 0否 1是" prop="dbIsKey">
      <el-input v-model="dataForm.dbIsKey" placeholder="是否主键 0否 1是"></el-input>
    </el-form-item>
    <el-form-item label="是否允许为空0否 1是" prop="dbIsNull">
      <el-input v-model="dataForm.dbIsNull" placeholder="是否允许为空0否 1是"></el-input>
    </el-form-item>
    <el-form-item label="是否需要同步数据库字段， 1是0否" prop="dbIsPersist">
      <el-input v-model="dataForm.dbIsPersist" placeholder="是否需要同步数据库字段， 1是0否"></el-input>
    </el-form-item>
    <el-form-item label="数据库字段类型" prop="dbType">
      <el-input v-model="dataForm.dbType" placeholder="数据库字段类型"></el-input>
    </el-form-item>
    <el-form-item label="数据库字段长度" prop="dbLength">
      <el-input v-model="dataForm.dbLength" placeholder="数据库字段长度"></el-input>
    </el-form-item>
    <el-form-item label="小数点" prop="dbPointLength">
      <el-input v-model="dataForm.dbPointLength" placeholder="小数点"></el-input>
    </el-form-item>
    <el-form-item label="表字段默认值" prop="dbDefaultVal">
      <el-input v-model="dataForm.dbDefaultVal" placeholder="表字段默认值"></el-input>
    </el-form-item>
    <el-form-item label="字典code" prop="dictField">
      <el-input v-model="dataForm.dictField" placeholder="字典code"></el-input>
    </el-form-item>
    <el-form-item label="字典表" prop="dictTable">
      <el-input v-model="dataForm.dictTable" placeholder="字典表"></el-input>
    </el-form-item>
    <el-form-item label="字典Text" prop="dictText">
      <el-input v-model="dataForm.dictText" placeholder="字典Text"></el-input>
    </el-form-item>
    <el-form-item label="表单控件类型" prop="fieldShowType">
      <el-input v-model="dataForm.fieldShowType" placeholder="表单控件类型"></el-input>
    </el-form-item>
    <el-form-item label="跳转URL" prop="fieldHref">
      <el-input v-model="dataForm.fieldHref" placeholder="跳转URL"></el-input>
    </el-form-item>
    <el-form-item label="表单控件长度" prop="fieldLength">
      <el-input v-model="dataForm.fieldLength" placeholder="表单控件长度"></el-input>
    </el-form-item>
    <el-form-item label="表单字段校验规则" prop="fieldValidType">
      <el-input v-model="dataForm.fieldValidType" placeholder="表单字段校验规则"></el-input>
    </el-form-item>
    <el-form-item label="字段是否必填" prop="fieldMustInput">
      <el-input v-model="dataForm.fieldMustInput" placeholder="字段是否必填"></el-input>
    </el-form-item>
    <el-form-item label="扩展参数JSON" prop="fieldExtendJson">
      <el-input v-model="dataForm.fieldExtendJson" placeholder="扩展参数JSON"></el-input>
    </el-form-item>
    <el-form-item label="控件默认值，不同的表达式展示不同的结果。
1. 纯字符串直接赋给默认值；
2. #{普通变量}；
3. {{ 动态JS表达式 }}；
4. ${填值规则编码}；
填值规则表达式只允许存在一个，且不能和其他规则混用。" prop="fieldDefaultValue">
      <el-input v-model="dataForm.fieldDefaultValue" placeholder="控件默认值，不同的表达式展示不同的结果。
1. 纯字符串直接赋给默认值；
2. #{普通变量}；
3. {{ 动态JS表达式 }}；
4. ${填值规则编码}；
填值规则表达式只允许存在一个，且不能和其他规则混用。"></el-input>
    </el-form-item>
    <el-form-item label="是否查询条件0否 1是" prop="isQuery">
      <el-input v-model="dataForm.isQuery" placeholder="是否查询条件0否 1是"></el-input>
    </el-form-item>
    <el-form-item label="表单是否显示0否 1是" prop="isShowForm">
      <el-input v-model="dataForm.isShowForm" placeholder="表单是否显示0否 1是"></el-input>
    </el-form-item>
    <el-form-item label="列表是否显示0否 1是" prop="isShowList">
      <el-input v-model="dataForm.isShowList" placeholder="列表是否显示0否 1是"></el-input>
    </el-form-item>
    <el-form-item label="是否是只读（1是 0否）" prop="isReadOnly">
      <el-input v-model="dataForm.isReadOnly" placeholder="是否是只读（1是 0否）"></el-input>
    </el-form-item>
    <el-form-item label="查询模式" prop="queryMode">
      <el-input v-model="dataForm.queryMode" placeholder="查询模式"></el-input>
    </el-form-item>
    <el-form-item label="外键主表名" prop="mainTable">
      <el-input v-model="dataForm.mainTable" placeholder="外键主表名"></el-input>
    </el-form-item>
    <el-form-item label="外键主键字段" prop="mainField">
      <el-input v-model="dataForm.mainField" placeholder="外键主键字段"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="orderNum">
      <el-input v-model="dataForm.orderNum" placeholder="排序"></el-input>
    </el-form-item>
    <el-form-item label="修改人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="修改人"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="自定义值转换器" prop="converter">
      <el-input v-model="dataForm.converter" placeholder="自定义值转换器"></el-input>
    </el-form-item>
    <el-form-item label="查询默认值" prop="queryDefVal">
      <el-input v-model="dataForm.queryDefVal" placeholder="查询默认值"></el-input>
    </el-form-item>
    <el-form-item label="查询配置字典text" prop="queryDictText">
      <el-input v-model="dataForm.queryDictText" placeholder="查询配置字典text"></el-input>
    </el-form-item>
    <el-form-item label="查询配置字典code" prop="queryDictField">
      <el-input v-model="dataForm.queryDictField" placeholder="查询配置字典code"></el-input>
    </el-form-item>
    <el-form-item label="查询配置字典table" prop="queryDictTable">
      <el-input v-model="dataForm.queryDictTable" placeholder="查询配置字典table"></el-input>
    </el-form-item>
    <el-form-item label="查询显示控件" prop="queryShowType">
      <el-input v-model="dataForm.queryShowType" placeholder="查询显示控件"></el-input>
    </el-form-item>
    <el-form-item label="是否启用查询配置1是0否" prop="queryConfigFlag">
      <el-input v-model="dataForm.queryConfigFlag" placeholder="是否启用查询配置1是0否"></el-input>
    </el-form-item>
    <el-form-item label="查询字段校验类型" prop="queryValidType">
      <el-input v-model="dataForm.queryValidType" placeholder="查询字段校验类型"></el-input>
    </el-form-item>
    <el-form-item label="查询字段是否必填1是0否" prop="queryMustInput">
      <el-input v-model="dataForm.queryMustInput" placeholder="查询字段是否必填1是0否"></el-input>
    </el-form-item>
    <el-form-item label="是否支持排序1是0否" prop="sortFlag">
      <el-input v-model="dataForm.sortFlag" placeholder="是否支持排序1是0否"></el-input>
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
          cgformHeadId: '',
          dbFieldName: '',
          dbFieldTxt: '',
          dbFieldNameOld: '',
          dbIsKey: '',
          dbIsNull: '',
          dbIsPersist: '',
          dbType: '',
          dbLength: '',
          dbPointLength: '',
          dbDefaultVal: '',
          dictField: '',
          dictTable: '',
          dictText: '',
          fieldShowType: '',
          fieldHref: '',
          fieldLength: '',
          fieldValidType: '',
          fieldMustInput: '',
          fieldExtendJson: '',
          fieldDefaultValue: '',
          isQuery: '',
          isShowForm: '',
          isShowList: '',
          isReadOnly: '',
          queryMode: '',
          mainTable: '',
          mainField: '',
          orderNum: '',
          updateBy: '',
          updateTime: '',
          createTime: '',
          createBy: '',
          converter: '',
          queryDefVal: '',
          queryDictText: '',
          queryDictField: '',
          queryDictTable: '',
          queryShowType: '',
          queryConfigFlag: '',
          queryValidType: '',
          queryMustInput: '',
          sortFlag: ''
        },
        dataRule: {
          cgformHeadId: [
            { required: true, message: '表ID不能为空', trigger: 'blur' }
          ],
          dbFieldName: [
            { required: true, message: '字段名字不能为空', trigger: 'blur' }
          ],
          dbFieldTxt: [
            { required: true, message: '字段备注不能为空', trigger: 'blur' }
          ],
          dbFieldNameOld: [
            { required: true, message: '原字段名不能为空', trigger: 'blur' }
          ],
          dbIsKey: [
            { required: true, message: '是否主键 0否 1是不能为空', trigger: 'blur' }
          ],
          dbIsNull: [
            { required: true, message: '是否允许为空0否 1是不能为空', trigger: 'blur' }
          ],
          dbIsPersist: [
            { required: true, message: '是否需要同步数据库字段， 1是0否不能为空', trigger: 'blur' }
          ],
          dbType: [
            { required: true, message: '数据库字段类型不能为空', trigger: 'blur' }
          ],
          dbLength: [
            { required: true, message: '数据库字段长度不能为空', trigger: 'blur' }
          ],
          dbPointLength: [
            { required: true, message: '小数点不能为空', trigger: 'blur' }
          ],
          dbDefaultVal: [
            { required: true, message: '表字段默认值不能为空', trigger: 'blur' }
          ],
          dictField: [
            { required: true, message: '字典code不能为空', trigger: 'blur' }
          ],
          dictTable: [
            { required: true, message: '字典表不能为空', trigger: 'blur' }
          ],
          dictText: [
            { required: true, message: '字典Text不能为空', trigger: 'blur' }
          ],
          fieldShowType: [
            { required: true, message: '表单控件类型不能为空', trigger: 'blur' }
          ],
          fieldHref: [
            { required: true, message: '跳转URL不能为空', trigger: 'blur' }
          ],
          fieldLength: [
            { required: true, message: '表单控件长度不能为空', trigger: 'blur' }
          ],
          fieldValidType: [
            { required: true, message: '表单字段校验规则不能为空', trigger: 'blur' }
          ],
          fieldMustInput: [
            { required: true, message: '字段是否必填不能为空', trigger: 'blur' }
          ],
          fieldExtendJson: [
            { required: true, message: '扩展参数JSON不能为空', trigger: 'blur' }
          ],
          fieldDefaultValue: [
            { required: true, message: '控件默认值，不同的表达式展示不同的结果。
1. 纯字符串直接赋给默认值；
2. #{普通变量}；
3. {{ 动态JS表达式 }}；
4. ${填值规则编码}；
填值规则表达式只允许存在一个，且不能和其他规则混用。不能为空', trigger: 'blur' }
          ],
          isQuery: [
            { required: true, message: '是否查询条件0否 1是不能为空', trigger: 'blur' }
          ],
          isShowForm: [
            { required: true, message: '表单是否显示0否 1是不能为空', trigger: 'blur' }
          ],
          isShowList: [
            { required: true, message: '列表是否显示0否 1是不能为空', trigger: 'blur' }
          ],
          isReadOnly: [
            { required: true, message: '是否是只读（1是 0否）不能为空', trigger: 'blur' }
          ],
          queryMode: [
            { required: true, message: '查询模式不能为空', trigger: 'blur' }
          ],
          mainTable: [
            { required: true, message: '外键主表名不能为空', trigger: 'blur' }
          ],
          mainField: [
            { required: true, message: '外键主键字段不能为空', trigger: 'blur' }
          ],
          orderNum: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '修改人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          converter: [
            { required: true, message: '自定义值转换器不能为空', trigger: 'blur' }
          ],
          queryDefVal: [
            { required: true, message: '查询默认值不能为空', trigger: 'blur' }
          ],
          queryDictText: [
            { required: true, message: '查询配置字典text不能为空', trigger: 'blur' }
          ],
          queryDictField: [
            { required: true, message: '查询配置字典code不能为空', trigger: 'blur' }
          ],
          queryDictTable: [
            { required: true, message: '查询配置字典table不能为空', trigger: 'blur' }
          ],
          queryShowType: [
            { required: true, message: '查询显示控件不能为空', trigger: 'blur' }
          ],
          queryConfigFlag: [
            { required: true, message: '是否启用查询配置1是0否不能为空', trigger: 'blur' }
          ],
          queryValidType: [
            { required: true, message: '查询字段校验类型不能为空', trigger: 'blur' }
          ],
          queryMustInput: [
            { required: true, message: '查询字段是否必填1是0否不能为空', trigger: 'blur' }
          ],
          sortFlag: [
            { required: true, message: '是否支持排序1是0否不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/onlcgformfield/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.cgformHeadId = data.onlCgformField.cgformHeadId
                this.dataForm.dbFieldName = data.onlCgformField.dbFieldName
                this.dataForm.dbFieldTxt = data.onlCgformField.dbFieldTxt
                this.dataForm.dbFieldNameOld = data.onlCgformField.dbFieldNameOld
                this.dataForm.dbIsKey = data.onlCgformField.dbIsKey
                this.dataForm.dbIsNull = data.onlCgformField.dbIsNull
                this.dataForm.dbIsPersist = data.onlCgformField.dbIsPersist
                this.dataForm.dbType = data.onlCgformField.dbType
                this.dataForm.dbLength = data.onlCgformField.dbLength
                this.dataForm.dbPointLength = data.onlCgformField.dbPointLength
                this.dataForm.dbDefaultVal = data.onlCgformField.dbDefaultVal
                this.dataForm.dictField = data.onlCgformField.dictField
                this.dataForm.dictTable = data.onlCgformField.dictTable
                this.dataForm.dictText = data.onlCgformField.dictText
                this.dataForm.fieldShowType = data.onlCgformField.fieldShowType
                this.dataForm.fieldHref = data.onlCgformField.fieldHref
                this.dataForm.fieldLength = data.onlCgformField.fieldLength
                this.dataForm.fieldValidType = data.onlCgformField.fieldValidType
                this.dataForm.fieldMustInput = data.onlCgformField.fieldMustInput
                this.dataForm.fieldExtendJson = data.onlCgformField.fieldExtendJson
                this.dataForm.fieldDefaultValue = data.onlCgformField.fieldDefaultValue
                this.dataForm.isQuery = data.onlCgformField.isQuery
                this.dataForm.isShowForm = data.onlCgformField.isShowForm
                this.dataForm.isShowList = data.onlCgformField.isShowList
                this.dataForm.isReadOnly = data.onlCgformField.isReadOnly
                this.dataForm.queryMode = data.onlCgformField.queryMode
                this.dataForm.mainTable = data.onlCgformField.mainTable
                this.dataForm.mainField = data.onlCgformField.mainField
                this.dataForm.orderNum = data.onlCgformField.orderNum
                this.dataForm.updateBy = data.onlCgformField.updateBy
                this.dataForm.updateTime = data.onlCgformField.updateTime
                this.dataForm.createTime = data.onlCgformField.createTime
                this.dataForm.createBy = data.onlCgformField.createBy
                this.dataForm.converter = data.onlCgformField.converter
                this.dataForm.queryDefVal = data.onlCgformField.queryDefVal
                this.dataForm.queryDictText = data.onlCgformField.queryDictText
                this.dataForm.queryDictField = data.onlCgformField.queryDictField
                this.dataForm.queryDictTable = data.onlCgformField.queryDictTable
                this.dataForm.queryShowType = data.onlCgformField.queryShowType
                this.dataForm.queryConfigFlag = data.onlCgformField.queryConfigFlag
                this.dataForm.queryValidType = data.onlCgformField.queryValidType
                this.dataForm.queryMustInput = data.onlCgformField.queryMustInput
                this.dataForm.sortFlag = data.onlCgformField.sortFlag
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
              url: this.$http.adornUrl(`/ware/onlcgformfield/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'cgformHeadId': this.dataForm.cgformHeadId,
                'dbFieldName': this.dataForm.dbFieldName,
                'dbFieldTxt': this.dataForm.dbFieldTxt,
                'dbFieldNameOld': this.dataForm.dbFieldNameOld,
                'dbIsKey': this.dataForm.dbIsKey,
                'dbIsNull': this.dataForm.dbIsNull,
                'dbIsPersist': this.dataForm.dbIsPersist,
                'dbType': this.dataForm.dbType,
                'dbLength': this.dataForm.dbLength,
                'dbPointLength': this.dataForm.dbPointLength,
                'dbDefaultVal': this.dataForm.dbDefaultVal,
                'dictField': this.dataForm.dictField,
                'dictTable': this.dataForm.dictTable,
                'dictText': this.dataForm.dictText,
                'fieldShowType': this.dataForm.fieldShowType,
                'fieldHref': this.dataForm.fieldHref,
                'fieldLength': this.dataForm.fieldLength,
                'fieldValidType': this.dataForm.fieldValidType,
                'fieldMustInput': this.dataForm.fieldMustInput,
                'fieldExtendJson': this.dataForm.fieldExtendJson,
                'fieldDefaultValue': this.dataForm.fieldDefaultValue,
                'isQuery': this.dataForm.isQuery,
                'isShowForm': this.dataForm.isShowForm,
                'isShowList': this.dataForm.isShowList,
                'isReadOnly': this.dataForm.isReadOnly,
                'queryMode': this.dataForm.queryMode,
                'mainTable': this.dataForm.mainTable,
                'mainField': this.dataForm.mainField,
                'orderNum': this.dataForm.orderNum,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'createTime': this.dataForm.createTime,
                'createBy': this.dataForm.createBy,
                'converter': this.dataForm.converter,
                'queryDefVal': this.dataForm.queryDefVal,
                'queryDictText': this.dataForm.queryDictText,
                'queryDictField': this.dataForm.queryDictField,
                'queryDictTable': this.dataForm.queryDictTable,
                'queryShowType': this.dataForm.queryShowType,
                'queryConfigFlag': this.dataForm.queryConfigFlag,
                'queryValidType': this.dataForm.queryValidType,
                'queryMustInput': this.dataForm.queryMustInput,
                'sortFlag': this.dataForm.sortFlag
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
