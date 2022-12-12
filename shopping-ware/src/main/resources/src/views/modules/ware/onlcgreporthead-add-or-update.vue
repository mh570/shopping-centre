<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="报表编码" prop="code">
      <el-input v-model="dataForm.code" placeholder="报表编码"></el-input>
    </el-form-item>
    <el-form-item label="报表名字" prop="name">
      <el-input v-model="dataForm.name" placeholder="报表名字"></el-input>
    </el-form-item>
    <el-form-item label="报表SQL" prop="cgrSql">
      <el-input v-model="dataForm.cgrSql" placeholder="报表SQL"></el-input>
    </el-form-item>
    <el-form-item label="返回值字段" prop="returnValField">
      <el-input v-model="dataForm.returnValField" placeholder="返回值字段"></el-input>
    </el-form-item>
    <el-form-item label="返回文本字段" prop="returnTxtField">
      <el-input v-model="dataForm.returnTxtField" placeholder="返回文本字段"></el-input>
    </el-form-item>
    <el-form-item label="返回类型，单选或多选" prop="returnType">
      <el-input v-model="dataForm.returnType" placeholder="返回类型，单选或多选"></el-input>
    </el-form-item>
    <el-form-item label="动态数据源" prop="dbSource">
      <el-input v-model="dataForm.dbSource" placeholder="动态数据源"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="content">
      <el-input v-model="dataForm.content" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="关联的应用ID" prop="lowAppId">
      <el-input v-model="dataForm.lowAppId" placeholder="关联的应用ID"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="修改人id" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="修改人id"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建人id" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人id"></el-input>
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
          code: '',
          name: '',
          cgrSql: '',
          returnValField: '',
          returnTxtField: '',
          returnType: '',
          dbSource: '',
          content: '',
          lowAppId: '',
          updateTime: '',
          updateBy: '',
          createTime: '',
          createBy: ''
        },
        dataRule: {
          code: [
            { required: true, message: '报表编码不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '报表名字不能为空', trigger: 'blur' }
          ],
          cgrSql: [
            { required: true, message: '报表SQL不能为空', trigger: 'blur' }
          ],
          returnValField: [
            { required: true, message: '返回值字段不能为空', trigger: 'blur' }
          ],
          returnTxtField: [
            { required: true, message: '返回文本字段不能为空', trigger: 'blur' }
          ],
          returnType: [
            { required: true, message: '返回类型，单选或多选不能为空', trigger: 'blur' }
          ],
          dbSource: [
            { required: true, message: '动态数据源不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          lowAppId: [
            { required: true, message: '关联的应用ID不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '修改人id不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人id不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/onlcgreporthead/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.code = data.onlCgreportHead.code
                this.dataForm.name = data.onlCgreportHead.name
                this.dataForm.cgrSql = data.onlCgreportHead.cgrSql
                this.dataForm.returnValField = data.onlCgreportHead.returnValField
                this.dataForm.returnTxtField = data.onlCgreportHead.returnTxtField
                this.dataForm.returnType = data.onlCgreportHead.returnType
                this.dataForm.dbSource = data.onlCgreportHead.dbSource
                this.dataForm.content = data.onlCgreportHead.content
                this.dataForm.lowAppId = data.onlCgreportHead.lowAppId
                this.dataForm.updateTime = data.onlCgreportHead.updateTime
                this.dataForm.updateBy = data.onlCgreportHead.updateBy
                this.dataForm.createTime = data.onlCgreportHead.createTime
                this.dataForm.createBy = data.onlCgreportHead.createBy
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
              url: this.$http.adornUrl(`/ware/onlcgreporthead/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'code': this.dataForm.code,
                'name': this.dataForm.name,
                'cgrSql': this.dataForm.cgrSql,
                'returnValField': this.dataForm.returnValField,
                'returnTxtField': this.dataForm.returnTxtField,
                'returnType': this.dataForm.returnType,
                'dbSource': this.dataForm.dbSource,
                'content': this.dataForm.content,
                'lowAppId': this.dataForm.lowAppId,
                'updateTime': this.dataForm.updateTime,
                'updateBy': this.dataForm.updateBy,
                'createTime': this.dataForm.createTime,
                'createBy': this.dataForm.createBy
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
