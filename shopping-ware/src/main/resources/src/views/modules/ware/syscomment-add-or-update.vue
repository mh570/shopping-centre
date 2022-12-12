<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="表名" prop="tableName">
      <el-input v-model="dataForm.tableName" placeholder="表名"></el-input>
    </el-form-item>
    <el-form-item label="数据id" prop="tableDataId">
      <el-input v-model="dataForm.tableDataId" placeholder="数据id"></el-input>
    </el-form-item>
    <el-form-item label="来源用户id" prop="fromUserId">
      <el-input v-model="dataForm.fromUserId" placeholder="来源用户id"></el-input>
    </el-form-item>
    <el-form-item label="发送给用户id(允许为空)" prop="toUserId">
      <el-input v-model="dataForm.toUserId" placeholder="发送给用户id(允许为空)"></el-input>
    </el-form-item>
    <el-form-item label="评论id(允许为空，不为空时，则为回复)" prop="commentId">
      <el-input v-model="dataForm.commentId" placeholder="评论id(允许为空，不为空时，则为回复)"></el-input>
    </el-form-item>
    <el-form-item label="回复内容" prop="commentContent">
      <el-input v-model="dataForm.commentContent" placeholder="回复内容"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="创建日期" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建日期"></el-input>
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
          tableName: '',
          tableDataId: '',
          fromUserId: '',
          toUserId: '',
          commentId: '',
          commentContent: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: ''
        },
        dataRule: {
          tableName: [
            { required: true, message: '表名不能为空', trigger: 'blur' }
          ],
          tableDataId: [
            { required: true, message: '数据id不能为空', trigger: 'blur' }
          ],
          fromUserId: [
            { required: true, message: '来源用户id不能为空', trigger: 'blur' }
          ],
          toUserId: [
            { required: true, message: '发送给用户id(允许为空)不能为空', trigger: 'blur' }
          ],
          commentId: [
            { required: true, message: '评论id(允许为空，不为空时，则为回复)不能为空', trigger: 'blur' }
          ],
          commentContent: [
            { required: true, message: '回复内容不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/syscomment/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tableName = data.sysComment.tableName
                this.dataForm.tableDataId = data.sysComment.tableDataId
                this.dataForm.fromUserId = data.sysComment.fromUserId
                this.dataForm.toUserId = data.sysComment.toUserId
                this.dataForm.commentId = data.sysComment.commentId
                this.dataForm.commentContent = data.sysComment.commentContent
                this.dataForm.createBy = data.sysComment.createBy
                this.dataForm.createTime = data.sysComment.createTime
                this.dataForm.updateBy = data.sysComment.updateBy
                this.dataForm.updateTime = data.sysComment.updateTime
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
              url: this.$http.adornUrl(`/ware/syscomment/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'tableName': this.dataForm.tableName,
                'tableDataId': this.dataForm.tableDataId,
                'fromUserId': this.dataForm.fromUserId,
                'toUserId': this.dataForm.toUserId,
                'commentId': this.dataForm.commentId,
                'commentContent': this.dataForm.commentContent,
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
