<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="租户名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="租户名称"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="beginDate">
      <el-input v-model="dataForm.beginDate" placeholder="开始时间"></el-input>
    </el-form-item>
    <el-form-item label="结束时间" prop="endDate">
      <el-input v-model="dataForm.endDate" placeholder="结束时间"></el-input>
    </el-form-item>
    <el-form-item label="状态 1正常 0冻结" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态 1正常 0冻结"></el-input>
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
          name: '',
          createTime: '',
          createBy: '',
          beginDate: '',
          endDate: '',
          status: ''
        },
        dataRule: {
          name: [
            { required: true, message: '租户名称不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          beginDate: [
            { required: true, message: '开始时间不能为空', trigger: 'blur' }
          ],
          endDate: [
            { required: true, message: '结束时间不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态 1正常 0冻结不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/systenant/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.sysTenant.name
                this.dataForm.createTime = data.sysTenant.createTime
                this.dataForm.createBy = data.sysTenant.createBy
                this.dataForm.beginDate = data.sysTenant.beginDate
                this.dataForm.endDate = data.sysTenant.endDate
                this.dataForm.status = data.sysTenant.status
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
              url: this.$http.adornUrl(`/ware/systenant/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'createTime': this.dataForm.createTime,
                'createBy': this.dataForm.createBy,
                'beginDate': this.dataForm.beginDate,
                'endDate': this.dataForm.endDate,
                'status': this.dataForm.status
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
