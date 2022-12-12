<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="字典id" prop="dictId">
      <el-input v-model="dataForm.dictId" placeholder="字典id"></el-input>
    </el-form-item>
    <el-form-item label="字典项文本" prop="itemText">
      <el-input v-model="dataForm.itemText" placeholder="字典项文本"></el-input>
    </el-form-item>
    <el-form-item label="字典项值" prop="itemValue">
      <el-input v-model="dataForm.itemValue" placeholder="字典项值"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="description">
      <el-input v-model="dataForm.description" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="sortOrder">
      <el-input v-model="dataForm.sortOrder" placeholder="排序"></el-input>
    </el-form-item>
    <el-form-item label="状态（1启用 0不启用）" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态（1启用 0不启用）"></el-input>
    </el-form-item>
    <el-form-item label="" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder=""></el-input>
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
          dictId: '',
          itemText: '',
          itemValue: '',
          description: '',
          sortOrder: '',
          status: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: ''
        },
        dataRule: {
          dictId: [
            { required: true, message: '字典id不能为空', trigger: 'blur' }
          ],
          itemText: [
            { required: true, message: '字典项文本不能为空', trigger: 'blur' }
          ],
          itemValue: [
            { required: true, message: '字典项值不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          sortOrder: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态（1启用 0不启用）不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jimudictitem/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.dictId = data.jimuDictItem.dictId
                this.dataForm.itemText = data.jimuDictItem.itemText
                this.dataForm.itemValue = data.jimuDictItem.itemValue
                this.dataForm.description = data.jimuDictItem.description
                this.dataForm.sortOrder = data.jimuDictItem.sortOrder
                this.dataForm.status = data.jimuDictItem.status
                this.dataForm.createBy = data.jimuDictItem.createBy
                this.dataForm.createTime = data.jimuDictItem.createTime
                this.dataForm.updateBy = data.jimuDictItem.updateBy
                this.dataForm.updateTime = data.jimuDictItem.updateTime
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
              url: this.$http.adornUrl(`/ware/jimudictitem/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'dictId': this.dataForm.dictId,
                'itemText': this.dataForm.itemText,
                'itemValue': this.dataForm.itemValue,
                'description': this.dataForm.description,
                'sortOrder': this.dataForm.sortOrder,
                'status': this.dataForm.status,
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
