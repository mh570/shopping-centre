<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="按钮编码" prop="buttonCode">
      <el-input v-model="dataForm.buttonCode" placeholder="按钮编码"></el-input>
    </el-form-item>
    <el-form-item label="SQL内容" prop="cgbSql">
      <el-input v-model="dataForm.cgbSql" placeholder="SQL内容"></el-input>
    </el-form-item>
    <el-form-item label="Sql名称" prop="cgbSqlName">
      <el-input v-model="dataForm.cgbSqlName" placeholder="Sql名称"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="content">
      <el-input v-model="dataForm.content" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="表单ID" prop="cgformHeadId">
      <el-input v-model="dataForm.cgformHeadId" placeholder="表单ID"></el-input>
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
          buttonCode: '',
          cgbSql: '',
          cgbSqlName: '',
          content: '',
          cgformHeadId: ''
        },
        dataRule: {
          buttonCode: [
            { required: true, message: '按钮编码不能为空', trigger: 'blur' }
          ],
          cgbSql: [
            { required: true, message: 'SQL内容不能为空', trigger: 'blur' }
          ],
          cgbSqlName: [
            { required: true, message: 'Sql名称不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          cgformHeadId: [
            { required: true, message: '表单ID不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/onlcgformenhancesql/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.buttonCode = data.onlCgformEnhanceSql.buttonCode
                this.dataForm.cgbSql = data.onlCgformEnhanceSql.cgbSql
                this.dataForm.cgbSqlName = data.onlCgformEnhanceSql.cgbSqlName
                this.dataForm.content = data.onlCgformEnhanceSql.content
                this.dataForm.cgformHeadId = data.onlCgformEnhanceSql.cgformHeadId
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
              url: this.$http.adornUrl(`/ware/onlcgformenhancesql/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'buttonCode': this.dataForm.buttonCode,
                'cgbSql': this.dataForm.cgbSql,
                'cgbSqlName': this.dataForm.cgbSqlName,
                'content': this.dataForm.content,
                'cgformHeadId': this.dataForm.cgformHeadId
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
