<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="表名" prop="tableName">
      <el-input v-model="dataForm.tableName" placeholder="表名"></el-input>
    </el-form-item>
    <el-form-item label="表类型: 0单表、1主表、2附表" prop="tableType">
      <el-input v-model="dataForm.tableType" placeholder="表类型: 0单表、1主表、2附表"></el-input>
    </el-form-item>
    <el-form-item label="表版本" prop="tableVersion">
      <el-input v-model="dataForm.tableVersion" placeholder="表版本"></el-input>
    </el-form-item>
    <el-form-item label="表说明" prop="tableTxt">
      <el-input v-model="dataForm.tableTxt" placeholder="表说明"></el-input>
    </el-form-item>
    <el-form-item label="是否带checkbox" prop="isCheckbox">
      <el-input v-model="dataForm.isCheckbox" placeholder="是否带checkbox"></el-input>
    </el-form-item>
    <el-form-item label="同步数据库状态" prop="isDbSynch">
      <el-input v-model="dataForm.isDbSynch" placeholder="同步数据库状态"></el-input>
    </el-form-item>
    <el-form-item label="是否分页" prop="isPage">
      <el-input v-model="dataForm.isPage" placeholder="是否分页"></el-input>
    </el-form-item>
    <el-form-item label="是否是树" prop="isTree">
      <el-input v-model="dataForm.isTree" placeholder="是否是树"></el-input>
    </el-form-item>
    <el-form-item label="主键生成序列" prop="idSequence">
      <el-input v-model="dataForm.idSequence" placeholder="主键生成序列"></el-input>
    </el-form-item>
    <el-form-item label="主键类型" prop="idType">
      <el-input v-model="dataForm.idType" placeholder="主键类型"></el-input>
    </el-form-item>
    <el-form-item label="查询模式" prop="queryMode">
      <el-input v-model="dataForm.queryMode" placeholder="查询模式"></el-input>
    </el-form-item>
    <el-form-item label="映射关系 0一对多  1一对一" prop="relationType">
      <el-input v-model="dataForm.relationType" placeholder="映射关系 0一对多  1一对一"></el-input>
    </el-form-item>
    <el-form-item label="子表" prop="subTableStr">
      <el-input v-model="dataForm.subTableStr" placeholder="子表"></el-input>
    </el-form-item>
    <el-form-item label="附表排序序号" prop="tabOrderNum">
      <el-input v-model="dataForm.tabOrderNum" placeholder="附表排序序号"></el-input>
    </el-form-item>
    <el-form-item label="树形表单父id" prop="treeParentIdField">
      <el-input v-model="dataForm.treeParentIdField" placeholder="树形表单父id"></el-input>
    </el-form-item>
    <el-form-item label="树表主键字段" prop="treeIdField">
      <el-input v-model="dataForm.treeIdField" placeholder="树表主键字段"></el-input>
    </el-form-item>
    <el-form-item label="树开表单列字段" prop="treeFieldname">
      <el-input v-model="dataForm.treeFieldname" placeholder="树开表单列字段"></el-input>
    </el-form-item>
    <el-form-item label="表单分类" prop="formCategory">
      <el-input v-model="dataForm.formCategory" placeholder="表单分类"></el-input>
    </el-form-item>
    <el-form-item label="PC表单模板" prop="formTemplate">
      <el-input v-model="dataForm.formTemplate" placeholder="PC表单模板"></el-input>
    </el-form-item>
    <el-form-item label="表单模板样式(移动端)" prop="formTemplateMobile">
      <el-input v-model="dataForm.formTemplateMobile" placeholder="表单模板样式(移动端)"></el-input>
    </el-form-item>
    <el-form-item label="是否有横向滚动条" prop="scroll">
      <el-input v-model="dataForm.scroll" placeholder="是否有横向滚动条"></el-input>
    </el-form-item>
    <el-form-item label="复制版本号" prop="copyVersion">
      <el-input v-model="dataForm.copyVersion" placeholder="复制版本号"></el-input>
    </el-form-item>
    <el-form-item label="复制表类型1为复制表 0为原始表" prop="copyType">
      <el-input v-model="dataForm.copyType" placeholder="复制表类型1为复制表 0为原始表"></el-input>
    </el-form-item>
    <el-form-item label="原始表ID" prop="physicId">
      <el-input v-model="dataForm.physicId" placeholder="原始表ID"></el-input>
    </el-form-item>
    <el-form-item label="扩展JSON" prop="extConfigJson">
      <el-input v-model="dataForm.extConfigJson" placeholder="扩展JSON"></el-input>
    </el-form-item>
    <el-form-item label="修改人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="修改人"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="主题模板" prop="themeTemplate">
      <el-input v-model="dataForm.themeTemplate" placeholder="主题模板"></el-input>
    </el-form-item>
    <el-form-item label="是否用设计器表单" prop="isDesForm">
      <el-input v-model="dataForm.isDesForm" placeholder="是否用设计器表单"></el-input>
    </el-form-item>
    <el-form-item label="设计器表单编码" prop="desFormCode">
      <el-input v-model="dataForm.desFormCode" placeholder="设计器表单编码"></el-input>
    </el-form-item>
    <el-form-item label="关联的应用ID" prop="lowAppId">
      <el-input v-model="dataForm.lowAppId" placeholder="关联的应用ID"></el-input>
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
          tableName: '',
          tableType: '',
          tableVersion: '',
          tableTxt: '',
          isCheckbox: '',
          isDbSynch: '',
          isPage: '',
          isTree: '',
          idSequence: '',
          idType: '',
          queryMode: '',
          relationType: '',
          subTableStr: '',
          tabOrderNum: '',
          treeParentIdField: '',
          treeIdField: '',
          treeFieldname: '',
          formCategory: '',
          formTemplate: '',
          formTemplateMobile: '',
          scroll: '',
          copyVersion: '',
          copyType: '',
          physicId: '',
          extConfigJson: '',
          updateBy: '',
          updateTime: '',
          createBy: '',
          createTime: '',
          themeTemplate: '',
          isDesForm: '',
          desFormCode: '',
          lowAppId: ''
        },
        dataRule: {
          tableName: [
            { required: true, message: '表名不能为空', trigger: 'blur' }
          ],
          tableType: [
            { required: true, message: '表类型: 0单表、1主表、2附表不能为空', trigger: 'blur' }
          ],
          tableVersion: [
            { required: true, message: '表版本不能为空', trigger: 'blur' }
          ],
          tableTxt: [
            { required: true, message: '表说明不能为空', trigger: 'blur' }
          ],
          isCheckbox: [
            { required: true, message: '是否带checkbox不能为空', trigger: 'blur' }
          ],
          isDbSynch: [
            { required: true, message: '同步数据库状态不能为空', trigger: 'blur' }
          ],
          isPage: [
            { required: true, message: '是否分页不能为空', trigger: 'blur' }
          ],
          isTree: [
            { required: true, message: '是否是树不能为空', trigger: 'blur' }
          ],
          idSequence: [
            { required: true, message: '主键生成序列不能为空', trigger: 'blur' }
          ],
          idType: [
            { required: true, message: '主键类型不能为空', trigger: 'blur' }
          ],
          queryMode: [
            { required: true, message: '查询模式不能为空', trigger: 'blur' }
          ],
          relationType: [
            { required: true, message: '映射关系 0一对多  1一对一不能为空', trigger: 'blur' }
          ],
          subTableStr: [
            { required: true, message: '子表不能为空', trigger: 'blur' }
          ],
          tabOrderNum: [
            { required: true, message: '附表排序序号不能为空', trigger: 'blur' }
          ],
          treeParentIdField: [
            { required: true, message: '树形表单父id不能为空', trigger: 'blur' }
          ],
          treeIdField: [
            { required: true, message: '树表主键字段不能为空', trigger: 'blur' }
          ],
          treeFieldname: [
            { required: true, message: '树开表单列字段不能为空', trigger: 'blur' }
          ],
          formCategory: [
            { required: true, message: '表单分类不能为空', trigger: 'blur' }
          ],
          formTemplate: [
            { required: true, message: 'PC表单模板不能为空', trigger: 'blur' }
          ],
          formTemplateMobile: [
            { required: true, message: '表单模板样式(移动端)不能为空', trigger: 'blur' }
          ],
          scroll: [
            { required: true, message: '是否有横向滚动条不能为空', trigger: 'blur' }
          ],
          copyVersion: [
            { required: true, message: '复制版本号不能为空', trigger: 'blur' }
          ],
          copyType: [
            { required: true, message: '复制表类型1为复制表 0为原始表不能为空', trigger: 'blur' }
          ],
          physicId: [
            { required: true, message: '原始表ID不能为空', trigger: 'blur' }
          ],
          extConfigJson: [
            { required: true, message: '扩展JSON不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '修改人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          themeTemplate: [
            { required: true, message: '主题模板不能为空', trigger: 'blur' }
          ],
          isDesForm: [
            { required: true, message: '是否用设计器表单不能为空', trigger: 'blur' }
          ],
          desFormCode: [
            { required: true, message: '设计器表单编码不能为空', trigger: 'blur' }
          ],
          lowAppId: [
            { required: true, message: '关联的应用ID不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/onlcgformhead/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tableName = data.onlCgformHead.tableName
                this.dataForm.tableType = data.onlCgformHead.tableType
                this.dataForm.tableVersion = data.onlCgformHead.tableVersion
                this.dataForm.tableTxt = data.onlCgformHead.tableTxt
                this.dataForm.isCheckbox = data.onlCgformHead.isCheckbox
                this.dataForm.isDbSynch = data.onlCgformHead.isDbSynch
                this.dataForm.isPage = data.onlCgformHead.isPage
                this.dataForm.isTree = data.onlCgformHead.isTree
                this.dataForm.idSequence = data.onlCgformHead.idSequence
                this.dataForm.idType = data.onlCgformHead.idType
                this.dataForm.queryMode = data.onlCgformHead.queryMode
                this.dataForm.relationType = data.onlCgformHead.relationType
                this.dataForm.subTableStr = data.onlCgformHead.subTableStr
                this.dataForm.tabOrderNum = data.onlCgformHead.tabOrderNum
                this.dataForm.treeParentIdField = data.onlCgformHead.treeParentIdField
                this.dataForm.treeIdField = data.onlCgformHead.treeIdField
                this.dataForm.treeFieldname = data.onlCgformHead.treeFieldname
                this.dataForm.formCategory = data.onlCgformHead.formCategory
                this.dataForm.formTemplate = data.onlCgformHead.formTemplate
                this.dataForm.formTemplateMobile = data.onlCgformHead.formTemplateMobile
                this.dataForm.scroll = data.onlCgformHead.scroll
                this.dataForm.copyVersion = data.onlCgformHead.copyVersion
                this.dataForm.copyType = data.onlCgformHead.copyType
                this.dataForm.physicId = data.onlCgformHead.physicId
                this.dataForm.extConfigJson = data.onlCgformHead.extConfigJson
                this.dataForm.updateBy = data.onlCgformHead.updateBy
                this.dataForm.updateTime = data.onlCgformHead.updateTime
                this.dataForm.createBy = data.onlCgformHead.createBy
                this.dataForm.createTime = data.onlCgformHead.createTime
                this.dataForm.themeTemplate = data.onlCgformHead.themeTemplate
                this.dataForm.isDesForm = data.onlCgformHead.isDesForm
                this.dataForm.desFormCode = data.onlCgformHead.desFormCode
                this.dataForm.lowAppId = data.onlCgformHead.lowAppId
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
              url: this.$http.adornUrl(`/ware/onlcgformhead/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'tableName': this.dataForm.tableName,
                'tableType': this.dataForm.tableType,
                'tableVersion': this.dataForm.tableVersion,
                'tableTxt': this.dataForm.tableTxt,
                'isCheckbox': this.dataForm.isCheckbox,
                'isDbSynch': this.dataForm.isDbSynch,
                'isPage': this.dataForm.isPage,
                'isTree': this.dataForm.isTree,
                'idSequence': this.dataForm.idSequence,
                'idType': this.dataForm.idType,
                'queryMode': this.dataForm.queryMode,
                'relationType': this.dataForm.relationType,
                'subTableStr': this.dataForm.subTableStr,
                'tabOrderNum': this.dataForm.tabOrderNum,
                'treeParentIdField': this.dataForm.treeParentIdField,
                'treeIdField': this.dataForm.treeIdField,
                'treeFieldname': this.dataForm.treeFieldname,
                'formCategory': this.dataForm.formCategory,
                'formTemplate': this.dataForm.formTemplate,
                'formTemplateMobile': this.dataForm.formTemplateMobile,
                'scroll': this.dataForm.scroll,
                'copyVersion': this.dataForm.copyVersion,
                'copyType': this.dataForm.copyType,
                'physicId': this.dataForm.physicId,
                'extConfigJson': this.dataForm.extConfigJson,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'themeTemplate': this.dataForm.themeTemplate,
                'isDesForm': this.dataForm.isDesForm,
                'desFormCode': this.dataForm.desFormCode,
                'lowAppId': this.dataForm.lowAppId
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
