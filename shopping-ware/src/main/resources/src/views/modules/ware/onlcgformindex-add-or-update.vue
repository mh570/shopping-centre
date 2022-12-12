<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="主表id" prop="cgformHeadId">
      <el-input v-model="dataForm.cgformHeadId" placeholder="主表id"></el-input>
    </el-form-item>
    <el-form-item label="索引名称" prop="indexName">
      <el-input v-model="dataForm.indexName" placeholder="索引名称"></el-input>
    </el-form-item>
    <el-form-item label="索引栏位" prop="indexField">
      <el-input v-model="dataForm.indexField" placeholder="索引栏位"></el-input>
    </el-form-item>
    <el-form-item label="索引类型" prop="indexType">
      <el-input v-model="dataForm.indexType" placeholder="索引类型"></el-input>
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
    <el-form-item label="是否同步数据库 N未同步 Y已同步" prop="isDbSynch">
      <el-input v-model="dataForm.isDbSynch" placeholder="是否同步数据库 N未同步 Y已同步"></el-input>
    </el-form-item>
    <el-form-item label="是否删除 0未删除 1删除" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="是否删除 0未删除 1删除"></el-input>
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
          indexName: '',
          indexField: '',
          indexType: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          isDbSynch: '',
          delFlag: ''
        },
        dataRule: {
          cgformHeadId: [
            { required: true, message: '主表id不能为空', trigger: 'blur' }
          ],
          indexName: [
            { required: true, message: '索引名称不能为空', trigger: 'blur' }
          ],
          indexField: [
            { required: true, message: '索引栏位不能为空', trigger: 'blur' }
          ],
          indexType: [
            { required: true, message: '索引类型不能为空', trigger: 'blur' }
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
          isDbSynch: [
            { required: true, message: '是否同步数据库 N未同步 Y已同步不能为空', trigger: 'blur' }
          ],
          delFlag: [
            { required: true, message: '是否删除 0未删除 1删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/onlcgformindex/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.cgformHeadId = data.onlCgformIndex.cgformHeadId
                this.dataForm.indexName = data.onlCgformIndex.indexName
                this.dataForm.indexField = data.onlCgformIndex.indexField
                this.dataForm.indexType = data.onlCgformIndex.indexType
                this.dataForm.createBy = data.onlCgformIndex.createBy
                this.dataForm.createTime = data.onlCgformIndex.createTime
                this.dataForm.updateBy = data.onlCgformIndex.updateBy
                this.dataForm.updateTime = data.onlCgformIndex.updateTime
                this.dataForm.isDbSynch = data.onlCgformIndex.isDbSynch
                this.dataForm.delFlag = data.onlCgformIndex.delFlag
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
              url: this.$http.adornUrl(`/ware/onlcgformindex/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'cgformHeadId': this.dataForm.cgformHeadId,
                'indexName': this.dataForm.indexName,
                'indexField': this.dataForm.indexField,
                'indexType': this.dataForm.indexType,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'isDbSynch': this.dataForm.isDbSynch,
                'delFlag': this.dataForm.delFlag
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
