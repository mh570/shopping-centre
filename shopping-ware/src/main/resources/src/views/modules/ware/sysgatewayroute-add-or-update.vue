<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="路由ID" prop="routerId">
      <el-input v-model="dataForm.routerId" placeholder="路由ID"></el-input>
    </el-form-item>
    <el-form-item label="服务名" prop="name">
      <el-input v-model="dataForm.name" placeholder="服务名"></el-input>
    </el-form-item>
    <el-form-item label="服务地址" prop="uri">
      <el-input v-model="dataForm.uri" placeholder="服务地址"></el-input>
    </el-form-item>
    <el-form-item label="断言" prop="predicates">
      <el-input v-model="dataForm.predicates" placeholder="断言"></el-input>
    </el-form-item>
    <el-form-item label="过滤器" prop="filters">
      <el-input v-model="dataForm.filters" placeholder="过滤器"></el-input>
    </el-form-item>
    <el-form-item label="是否重试:0-否 1-是" prop="retryable">
      <el-input v-model="dataForm.retryable" placeholder="是否重试:0-否 1-是"></el-input>
    </el-form-item>
    <el-form-item label="是否忽略前缀0-否 1-是" prop="stripPrefix">
      <el-input v-model="dataForm.stripPrefix" placeholder="是否忽略前缀0-否 1-是"></el-input>
    </el-form-item>
    <el-form-item label="是否为保留数据:0-否 1-是" prop="persistable">
      <el-input v-model="dataForm.persistable" placeholder="是否为保留数据:0-否 1-是"></el-input>
    </el-form-item>
    <el-form-item label="是否在接口文档中展示:0-否 1-是" prop="showApi">
      <el-input v-model="dataForm.showApi" placeholder="是否在接口文档中展示:0-否 1-是"></el-input>
    </el-form-item>
    <el-form-item label="状态:0-无效 1-有效" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态:0-无效 1-有效"></el-input>
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
    <el-form-item label="所属部门" prop="sysOrgCode">
      <el-input v-model="dataForm.sysOrgCode" placeholder="所属部门"></el-input>
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
          routerId: '',
          name: '',
          uri: '',
          predicates: '',
          filters: '',
          retryable: '',
          stripPrefix: '',
          persistable: '',
          showApi: '',
          status: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          sysOrgCode: ''
        },
        dataRule: {
          routerId: [
            { required: true, message: '路由ID不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '服务名不能为空', trigger: 'blur' }
          ],
          uri: [
            { required: true, message: '服务地址不能为空', trigger: 'blur' }
          ],
          predicates: [
            { required: true, message: '断言不能为空', trigger: 'blur' }
          ],
          filters: [
            { required: true, message: '过滤器不能为空', trigger: 'blur' }
          ],
          retryable: [
            { required: true, message: '是否重试:0-否 1-是不能为空', trigger: 'blur' }
          ],
          stripPrefix: [
            { required: true, message: '是否忽略前缀0-否 1-是不能为空', trigger: 'blur' }
          ],
          persistable: [
            { required: true, message: '是否为保留数据:0-否 1-是不能为空', trigger: 'blur' }
          ],
          showApi: [
            { required: true, message: '是否在接口文档中展示:0-否 1-是不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态:0-无效 1-有效不能为空', trigger: 'blur' }
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
          ],
          sysOrgCode: [
            { required: true, message: '所属部门不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysgatewayroute/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.routerId = data.sysGatewayRoute.routerId
                this.dataForm.name = data.sysGatewayRoute.name
                this.dataForm.uri = data.sysGatewayRoute.uri
                this.dataForm.predicates = data.sysGatewayRoute.predicates
                this.dataForm.filters = data.sysGatewayRoute.filters
                this.dataForm.retryable = data.sysGatewayRoute.retryable
                this.dataForm.stripPrefix = data.sysGatewayRoute.stripPrefix
                this.dataForm.persistable = data.sysGatewayRoute.persistable
                this.dataForm.showApi = data.sysGatewayRoute.showApi
                this.dataForm.status = data.sysGatewayRoute.status
                this.dataForm.createBy = data.sysGatewayRoute.createBy
                this.dataForm.createTime = data.sysGatewayRoute.createTime
                this.dataForm.updateBy = data.sysGatewayRoute.updateBy
                this.dataForm.updateTime = data.sysGatewayRoute.updateTime
                this.dataForm.sysOrgCode = data.sysGatewayRoute.sysOrgCode
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
              url: this.$http.adornUrl(`/ware/sysgatewayroute/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'routerId': this.dataForm.routerId,
                'name': this.dataForm.name,
                'uri': this.dataForm.uri,
                'predicates': this.dataForm.predicates,
                'filters': this.dataForm.filters,
                'retryable': this.dataForm.retryable,
                'stripPrefix': this.dataForm.stripPrefix,
                'persistable': this.dataForm.persistable,
                'showApi': this.dataForm.showApi,
                'status': this.dataForm.status,
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
