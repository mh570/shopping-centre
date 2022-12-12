<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="角色编码" prop="roleCode">
      <el-input v-model="dataForm.roleCode" placeholder="角色编码"></el-input>
    </el-form-item>
    <el-form-item label="路由地址" prop="url">
      <el-input v-model="dataForm.url" placeholder="路由地址"></el-input>
    </el-form-item>
    <el-form-item label="组件" prop="component">
      <el-input v-model="dataForm.component" placeholder="组件"></el-input>
    </el-form-item>
    <el-form-item label="是否路由菜单: 0:不是  1:是（默认值1）" prop="isRoute">
      <el-input v-model="dataForm.isRoute" placeholder="是否路由菜单: 0:不是  1:是（默认值1）"></el-input>
    </el-form-item>
    <el-form-item label="优先级" prop="priority">
      <el-input v-model="dataForm.priority" placeholder="优先级"></el-input>
    </el-form-item>
    <el-form-item label="状态0:无效 1:有效" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态0:无效 1:有效"></el-input>
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
          roleCode: '',
          url: '',
          component: '',
          isRoute: '',
          priority: '',
          status: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          sysOrgCode: ''
        },
        dataRule: {
          roleCode: [
            { required: true, message: '角色编码不能为空', trigger: 'blur' }
          ],
          url: [
            { required: true, message: '路由地址不能为空', trigger: 'blur' }
          ],
          component: [
            { required: true, message: '组件不能为空', trigger: 'blur' }
          ],
          isRoute: [
            { required: true, message: '是否路由菜单: 0:不是  1:是（默认值1）不能为空', trigger: 'blur' }
          ],
          priority: [
            { required: true, message: '优先级不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态0:无效 1:有效不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysroleindex/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.roleCode = data.sysRoleIndex.roleCode
                this.dataForm.url = data.sysRoleIndex.url
                this.dataForm.component = data.sysRoleIndex.component
                this.dataForm.isRoute = data.sysRoleIndex.isRoute
                this.dataForm.priority = data.sysRoleIndex.priority
                this.dataForm.status = data.sysRoleIndex.status
                this.dataForm.createBy = data.sysRoleIndex.createBy
                this.dataForm.createTime = data.sysRoleIndex.createTime
                this.dataForm.updateBy = data.sysRoleIndex.updateBy
                this.dataForm.updateTime = data.sysRoleIndex.updateTime
                this.dataForm.sysOrgCode = data.sysRoleIndex.sysOrgCode
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
              url: this.$http.adornUrl(`/ware/sysroleindex/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'roleCode': this.dataForm.roleCode,
                'url': this.dataForm.url,
                'component': this.dataForm.component,
                'isRoute': this.dataForm.isRoute,
                'priority': this.dataForm.priority,
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
