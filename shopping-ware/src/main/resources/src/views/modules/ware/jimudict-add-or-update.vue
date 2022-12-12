<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="字典名称" prop="dictName">
      <el-input v-model="dataForm.dictName" placeholder="字典名称"></el-input>
    </el-form-item>
    <el-form-item label="字典编码" prop="dictCode">
      <el-input v-model="dataForm.dictCode" placeholder="字典编码"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="description">
      <el-input v-model="dataForm.description" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="删除状态" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="删除状态"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="更新人"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="字典类型0为string,1为number" prop="type">
      <el-input v-model="dataForm.type" placeholder="字典类型0为string,1为number"></el-input>
    </el-form-item>
    <el-form-item label="多租户标识" prop="tenantId">
      <el-input v-model="dataForm.tenantId" placeholder="多租户标识"></el-input>
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
          dictName: '',
          dictCode: '',
          description: '',
          delFlag: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          type: '',
          tenantId: ''
        },
        dataRule: {
          dictName: [
            { required: true, message: '字典名称不能为空', trigger: 'blur' }
          ],
          dictCode: [
            { required: true, message: '字典编码不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          delFlag: [
            { required: true, message: '删除状态不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '更新人不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '字典类型0为string,1为number不能为空', trigger: 'blur' }
          ],
          tenantId: [
            { required: true, message: '多租户标识不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jimudict/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.dictName = data.jimuDict.dictName
                this.dataForm.dictCode = data.jimuDict.dictCode
                this.dataForm.description = data.jimuDict.description
                this.dataForm.delFlag = data.jimuDict.delFlag
                this.dataForm.createBy = data.jimuDict.createBy
                this.dataForm.createTime = data.jimuDict.createTime
                this.dataForm.updateBy = data.jimuDict.updateBy
                this.dataForm.updateTime = data.jimuDict.updateTime
                this.dataForm.type = data.jimuDict.type
                this.dataForm.tenantId = data.jimuDict.tenantId
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
              url: this.$http.adornUrl(`/ware/jimudict/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'dictName': this.dataForm.dictName,
                'dictCode': this.dataForm.dictCode,
                'description': this.dataForm.description,
                'delFlag': this.dataForm.delFlag,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'type': this.dataForm.type,
                'tenantId': this.dataForm.tenantId
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
