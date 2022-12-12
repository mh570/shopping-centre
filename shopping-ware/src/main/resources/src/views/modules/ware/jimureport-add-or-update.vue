<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="编码" prop="code">
      <el-input v-model="dataForm.code" placeholder="编码"></el-input>
    </el-form-item>
    <el-form-item label="名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="名称"></el-input>
    </el-form-item>
    <el-form-item label="说明" prop="note">
      <el-input v-model="dataForm.note" placeholder="说明"></el-input>
    </el-form-item>
    <el-form-item label="状态" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态"></el-input>
    </el-form-item>
    <el-form-item label="类型" prop="type">
      <el-input v-model="dataForm.type" placeholder="类型"></el-input>
    </el-form-item>
    <el-form-item label="json字符串" prop="jsonStr">
      <el-input v-model="dataForm.jsonStr" placeholder="json字符串"></el-input>
    </el-form-item>
    <el-form-item label="请求地址" prop="apiUrl">
      <el-input v-model="dataForm.apiUrl" placeholder="请求地址"></el-input>
    </el-form-item>
    <el-form-item label="缩略图" prop="thumb">
      <el-input v-model="dataForm.thumb" placeholder="缩略图"></el-input>
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
    <el-form-item label="删除标识0-正常,1-已删除" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="删除标识0-正常,1-已删除"></el-input>
    </el-form-item>
    <el-form-item label="请求方法0-get,1-post" prop="apiMethod">
      <el-input v-model="dataForm.apiMethod" placeholder="请求方法0-get,1-post"></el-input>
    </el-form-item>
    <el-form-item label="请求编码" prop="apiCode">
      <el-input v-model="dataForm.apiCode" placeholder="请求编码"></el-input>
    </el-form-item>
    <el-form-item label="是否是模板 0不是,1是" prop="template">
      <el-input v-model="dataForm.template" placeholder="是否是模板 0不是,1是"></el-input>
    </el-form-item>
    <el-form-item label="浏览次数" prop="viewCount">
      <el-input v-model="dataForm.viewCount" placeholder="浏览次数"></el-input>
    </el-form-item>
    <el-form-item label="css增强" prop="cssStr">
      <el-input v-model="dataForm.cssStr" placeholder="css增强"></el-input>
    </el-form-item>
    <el-form-item label="js增强" prop="jsStr">
      <el-input v-model="dataForm.jsStr" placeholder="js增强"></el-input>
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
          code: '',
          name: '',
          note: '',
          status: '',
          type: '',
          jsonStr: '',
          apiUrl: '',
          thumb: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          delFlag: '',
          apiMethod: '',
          apiCode: '',
          template: '',
          viewCount: '',
          cssStr: '',
          jsStr: '',
          tenantId: ''
        },
        dataRule: {
          code: [
            { required: true, message: '编码不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '名称不能为空', trigger: 'blur' }
          ],
          note: [
            { required: true, message: '说明不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '类型不能为空', trigger: 'blur' }
          ],
          jsonStr: [
            { required: true, message: 'json字符串不能为空', trigger: 'blur' }
          ],
          apiUrl: [
            { required: true, message: '请求地址不能为空', trigger: 'blur' }
          ],
          thumb: [
            { required: true, message: '缩略图不能为空', trigger: 'blur' }
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
          delFlag: [
            { required: true, message: '删除标识0-正常,1-已删除不能为空', trigger: 'blur' }
          ],
          apiMethod: [
            { required: true, message: '请求方法0-get,1-post不能为空', trigger: 'blur' }
          ],
          apiCode: [
            { required: true, message: '请求编码不能为空', trigger: 'blur' }
          ],
          template: [
            { required: true, message: '是否是模板 0不是,1是不能为空', trigger: 'blur' }
          ],
          viewCount: [
            { required: true, message: '浏览次数不能为空', trigger: 'blur' }
          ],
          cssStr: [
            { required: true, message: 'css增强不能为空', trigger: 'blur' }
          ],
          jsStr: [
            { required: true, message: 'js增强不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/jimureport/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.code = data.jimuReport.code
                this.dataForm.name = data.jimuReport.name
                this.dataForm.note = data.jimuReport.note
                this.dataForm.status = data.jimuReport.status
                this.dataForm.type = data.jimuReport.type
                this.dataForm.jsonStr = data.jimuReport.jsonStr
                this.dataForm.apiUrl = data.jimuReport.apiUrl
                this.dataForm.thumb = data.jimuReport.thumb
                this.dataForm.createBy = data.jimuReport.createBy
                this.dataForm.createTime = data.jimuReport.createTime
                this.dataForm.updateBy = data.jimuReport.updateBy
                this.dataForm.updateTime = data.jimuReport.updateTime
                this.dataForm.delFlag = data.jimuReport.delFlag
                this.dataForm.apiMethod = data.jimuReport.apiMethod
                this.dataForm.apiCode = data.jimuReport.apiCode
                this.dataForm.template = data.jimuReport.template
                this.dataForm.viewCount = data.jimuReport.viewCount
                this.dataForm.cssStr = data.jimuReport.cssStr
                this.dataForm.jsStr = data.jimuReport.jsStr
                this.dataForm.tenantId = data.jimuReport.tenantId
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
              url: this.$http.adornUrl(`/ware/jimureport/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'code': this.dataForm.code,
                'name': this.dataForm.name,
                'note': this.dataForm.note,
                'status': this.dataForm.status,
                'type': this.dataForm.type,
                'jsonStr': this.dataForm.jsonStr,
                'apiUrl': this.dataForm.apiUrl,
                'thumb': this.dataForm.thumb,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'delFlag': this.dataForm.delFlag,
                'apiMethod': this.dataForm.apiMethod,
                'apiCode': this.dataForm.apiCode,
                'template': this.dataForm.template,
                'viewCount': this.dataForm.viewCount,
                'cssStr': this.dataForm.cssStr,
                'jsStr': this.dataForm.jsStr,
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
