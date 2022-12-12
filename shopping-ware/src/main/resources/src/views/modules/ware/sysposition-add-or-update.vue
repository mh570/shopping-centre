<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="职务编码" prop="code">
      <el-input v-model="dataForm.code" placeholder="职务编码"></el-input>
    </el-form-item>
    <el-form-item label="职务名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="职务名称"></el-input>
    </el-form-item>
    <el-form-item label="职级" prop="postRank">
      <el-input v-model="dataForm.postRank" placeholder="职级"></el-input>
    </el-form-item>
    <el-form-item label="公司id" prop="companyId">
      <el-input v-model="dataForm.companyId" placeholder="公司id"></el-input>
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
    <el-form-item label="组织机构编码" prop="sysOrgCode">
      <el-input v-model="dataForm.sysOrgCode" placeholder="组织机构编码"></el-input>
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
          postRank: '',
          companyId: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          sysOrgCode: ''
        },
        dataRule: {
          code: [
            { required: true, message: '职务编码不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '职务名称不能为空', trigger: 'blur' }
          ],
          postRank: [
            { required: true, message: '职级不能为空', trigger: 'blur' }
          ],
          companyId: [
            { required: true, message: '公司id不能为空', trigger: 'blur' }
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
          ],
          sysOrgCode: [
            { required: true, message: '组织机构编码不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysposition/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.code = data.sysPosition.code
                this.dataForm.name = data.sysPosition.name
                this.dataForm.postRank = data.sysPosition.postRank
                this.dataForm.companyId = data.sysPosition.companyId
                this.dataForm.createBy = data.sysPosition.createBy
                this.dataForm.createTime = data.sysPosition.createTime
                this.dataForm.updateBy = data.sysPosition.updateBy
                this.dataForm.updateTime = data.sysPosition.updateTime
                this.dataForm.sysOrgCode = data.sysPosition.sysOrgCode
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
              url: this.$http.adornUrl(`/ware/sysposition/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'code': this.dataForm.code,
                'name': this.dataForm.name,
                'postRank': this.dataForm.postRank,
                'companyId': this.dataForm.companyId,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'sysOrgCode': this.dataForm.sysOrgCode
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
