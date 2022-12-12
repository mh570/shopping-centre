<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="online表id" prop="cgformId">
      <el-input v-model="dataForm.cgformId" placeholder="online表id"></el-input>
    </el-form-item>
    <el-form-item label="字段名/按钮编码" prop="code">
      <el-input v-model="dataForm.code" placeholder="字段名/按钮编码"></el-input>
    </el-form-item>
    <el-form-item label="1字段 2按钮" prop="type">
      <el-input v-model="dataForm.type" placeholder="1字段 2按钮"></el-input>
    </el-form-item>
    <el-form-item label="3可编辑 5可见(仅支持两种状态值3,5)" prop="control">
      <el-input v-model="dataForm.control" placeholder="3可编辑 5可见(仅支持两种状态值3,5)"></el-input>
    </el-form-item>
    <el-form-item label="3列表 5表单(仅支持两种状态值3,5)" prop="page">
      <el-input v-model="dataForm.page" placeholder="3列表 5表单(仅支持两种状态值3,5)"></el-input>
    </el-form-item>
    <el-form-item label="1有效 0无效" prop="status">
      <el-input v-model="dataForm.status" placeholder="1有效 0无效"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="更新人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人"></el-input>
    </el-form-item>
    <el-form-item label="更新日期" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新日期"></el-input>
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
          cgformId: '',
          code: '',
          type: '',
          control: '',
          page: '',
          status: '',
          createTime: '',
          createBy: '',
          updateBy: '',
          updateTime: ''
        },
        dataRule: {
          cgformId: [
            { required: true, message: 'online表id不能为空', trigger: 'blur' }
          ],
          code: [
            { required: true, message: '字段名/按钮编码不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '1字段 2按钮不能为空', trigger: 'blur' }
          ],
          control: [
            { required: true, message: '3可编辑 5可见(仅支持两种状态值3,5)不能为空', trigger: 'blur' }
          ],
          page: [
            { required: true, message: '3列表 5表单(仅支持两种状态值3,5)不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '1有效 0无效不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/onlauthpage/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.cgformId = data.onlAuthPage.cgformId
                this.dataForm.code = data.onlAuthPage.code
                this.dataForm.type = data.onlAuthPage.type
                this.dataForm.control = data.onlAuthPage.control
                this.dataForm.page = data.onlAuthPage.page
                this.dataForm.status = data.onlAuthPage.status
                this.dataForm.createTime = data.onlAuthPage.createTime
                this.dataForm.createBy = data.onlAuthPage.createBy
                this.dataForm.updateBy = data.onlAuthPage.updateBy
                this.dataForm.updateTime = data.onlAuthPage.updateTime
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
              url: this.$http.adornUrl(`/ware/onlauthpage/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'cgformId': this.dataForm.cgformId,
                'code': this.dataForm.code,
                'type': this.dataForm.type,
                'control': this.dataForm.control,
                'page': this.dataForm.page,
                'status': this.dataForm.status,
                'createTime': this.dataForm.createTime,
                'createBy': this.dataForm.createBy,
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
