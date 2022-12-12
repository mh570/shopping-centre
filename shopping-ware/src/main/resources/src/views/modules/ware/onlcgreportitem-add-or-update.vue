<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="报表ID" prop="cgrheadId">
      <el-input v-model="dataForm.cgrheadId" placeholder="报表ID"></el-input>
    </el-form-item>
    <el-form-item label="字段名字" prop="fieldName">
      <el-input v-model="dataForm.fieldName" placeholder="字段名字"></el-input>
    </el-form-item>
    <el-form-item label="字段文本" prop="fieldTxt">
      <el-input v-model="dataForm.fieldTxt" placeholder="字段文本"></el-input>
    </el-form-item>
    <el-form-item label="" prop="fieldWidth">
      <el-input v-model="dataForm.fieldWidth" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="字段类型" prop="fieldType">
      <el-input v-model="dataForm.fieldType" placeholder="字段类型"></el-input>
    </el-form-item>
    <el-form-item label="查询模式" prop="searchMode">
      <el-input v-model="dataForm.searchMode" placeholder="查询模式"></el-input>
    </el-form-item>
    <el-form-item label="是否排序  0否,1是" prop="isOrder">
      <el-input v-model="dataForm.isOrder" placeholder="是否排序  0否,1是"></el-input>
    </el-form-item>
    <el-form-item label="是否查询  0否,1是" prop="isSearch">
      <el-input v-model="dataForm.isSearch" placeholder="是否查询  0否,1是"></el-input>
    </el-form-item>
    <el-form-item label="字典CODE" prop="dictCode">
      <el-input v-model="dataForm.dictCode" placeholder="字典CODE"></el-input>
    </el-form-item>
    <el-form-item label="字段跳转URL" prop="fieldHref">
      <el-input v-model="dataForm.fieldHref" placeholder="字段跳转URL"></el-input>
    </el-form-item>
    <el-form-item label="是否显示  0否,1显示" prop="isShow">
      <el-input v-model="dataForm.isShow" placeholder="是否显示  0否,1显示"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="orderNum">
      <el-input v-model="dataForm.orderNum" placeholder="排序"></el-input>
    </el-form-item>
    <el-form-item label="取值表达式" prop="replaceVal">
      <el-input v-model="dataForm.replaceVal" placeholder="取值表达式"></el-input>
    </el-form-item>
    <el-form-item label="是否合计 0否,1是（仅对数值有效）" prop="isTotal">
      <el-input v-model="dataForm.isTotal" placeholder="是否合计 0否,1是（仅对数值有效）"></el-input>
    </el-form-item>
    <el-form-item label="分组标题" prop="groupTitle">
      <el-input v-model="dataForm.groupTitle" placeholder="分组标题"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="修改人"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
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
          cgrheadId: '',
          fieldName: '',
          fieldTxt: '',
          fieldWidth: '',
          fieldType: '',
          searchMode: '',
          isOrder: '',
          isSearch: '',
          dictCode: '',
          fieldHref: '',
          isShow: '',
          orderNum: '',
          replaceVal: '',
          isTotal: '',
          groupTitle: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: ''
        },
        dataRule: {
          cgrheadId: [
            { required: true, message: '报表ID不能为空', trigger: 'blur' }
          ],
          fieldName: [
            { required: true, message: '字段名字不能为空', trigger: 'blur' }
          ],
          fieldTxt: [
            { required: true, message: '字段文本不能为空', trigger: 'blur' }
          ],
          fieldWidth: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          fieldType: [
            { required: true, message: '字段类型不能为空', trigger: 'blur' }
          ],
          searchMode: [
            { required: true, message: '查询模式不能为空', trigger: 'blur' }
          ],
          isOrder: [
            { required: true, message: '是否排序  0否,1是不能为空', trigger: 'blur' }
          ],
          isSearch: [
            { required: true, message: '是否查询  0否,1是不能为空', trigger: 'blur' }
          ],
          dictCode: [
            { required: true, message: '字典CODE不能为空', trigger: 'blur' }
          ],
          fieldHref: [
            { required: true, message: '字段跳转URL不能为空', trigger: 'blur' }
          ],
          isShow: [
            { required: true, message: '是否显示  0否,1显示不能为空', trigger: 'blur' }
          ],
          orderNum: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ],
          replaceVal: [
            { required: true, message: '取值表达式不能为空', trigger: 'blur' }
          ],
          isTotal: [
            { required: true, message: '是否合计 0否,1是（仅对数值有效）不能为空', trigger: 'blur' }
          ],
          groupTitle: [
            { required: true, message: '分组标题不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '修改人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/onlcgreportitem/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.cgrheadId = data.onlCgreportItem.cgrheadId
                this.dataForm.fieldName = data.onlCgreportItem.fieldName
                this.dataForm.fieldTxt = data.onlCgreportItem.fieldTxt
                this.dataForm.fieldWidth = data.onlCgreportItem.fieldWidth
                this.dataForm.fieldType = data.onlCgreportItem.fieldType
                this.dataForm.searchMode = data.onlCgreportItem.searchMode
                this.dataForm.isOrder = data.onlCgreportItem.isOrder
                this.dataForm.isSearch = data.onlCgreportItem.isSearch
                this.dataForm.dictCode = data.onlCgreportItem.dictCode
                this.dataForm.fieldHref = data.onlCgreportItem.fieldHref
                this.dataForm.isShow = data.onlCgreportItem.isShow
                this.dataForm.orderNum = data.onlCgreportItem.orderNum
                this.dataForm.replaceVal = data.onlCgreportItem.replaceVal
                this.dataForm.isTotal = data.onlCgreportItem.isTotal
                this.dataForm.groupTitle = data.onlCgreportItem.groupTitle
                this.dataForm.createBy = data.onlCgreportItem.createBy
                this.dataForm.createTime = data.onlCgreportItem.createTime
                this.dataForm.updateBy = data.onlCgreportItem.updateBy
                this.dataForm.updateTime = data.onlCgreportItem.updateTime
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
              url: this.$http.adornUrl(`/ware/onlcgreportitem/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'cgrheadId': this.dataForm.cgrheadId,
                'fieldName': this.dataForm.fieldName,
                'fieldTxt': this.dataForm.fieldTxt,
                'fieldWidth': this.dataForm.fieldWidth,
                'fieldType': this.dataForm.fieldType,
                'searchMode': this.dataForm.searchMode,
                'isOrder': this.dataForm.isOrder,
                'isSearch': this.dataForm.isSearch,
                'dictCode': this.dataForm.dictCode,
                'fieldHref': this.dataForm.fieldHref,
                'isShow': this.dataForm.isShow,
                'orderNum': this.dataForm.orderNum,
                'replaceVal': this.dataForm.replaceVal,
                'isTotal': this.dataForm.isTotal,
                'groupTitle': this.dataForm.groupTitle,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime
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
