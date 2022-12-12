<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="父id" prop="parentId">
      <el-input v-model="dataForm.parentId" placeholder="父id"></el-input>
    </el-form-item>
    <el-form-item label="菜单标题" prop="name">
      <el-input v-model="dataForm.name" placeholder="菜单标题"></el-input>
    </el-form-item>
    <el-form-item label="路径" prop="url">
      <el-input v-model="dataForm.url" placeholder="路径"></el-input>
    </el-form-item>
    <el-form-item label="组件" prop="component">
      <el-input v-model="dataForm.component" placeholder="组件"></el-input>
    </el-form-item>
    <el-form-item label="是否路由菜单: 0:不是  1:是（默认值1）" prop="isRoute">
      <el-input v-model="dataForm.isRoute" placeholder="是否路由菜单: 0:不是  1:是（默认值1）"></el-input>
    </el-form-item>
    <el-form-item label="组件名字" prop="componentName">
      <el-input v-model="dataForm.componentName" placeholder="组件名字"></el-input>
    </el-form-item>
    <el-form-item label="一级菜单跳转地址" prop="redirect">
      <el-input v-model="dataForm.redirect" placeholder="一级菜单跳转地址"></el-input>
    </el-form-item>
    <el-form-item label="菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)" prop="menuType">
      <el-input v-model="dataForm.menuType" placeholder="菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)"></el-input>
    </el-form-item>
    <el-form-item label="菜单权限编码" prop="perms">
      <el-input v-model="dataForm.perms" placeholder="菜单权限编码"></el-input>
    </el-form-item>
    <el-form-item label="权限策略1显示2禁用" prop="permsType">
      <el-input v-model="dataForm.permsType" placeholder="权限策略1显示2禁用"></el-input>
    </el-form-item>
    <el-form-item label="菜单排序" prop="sortNo">
      <el-input v-model="dataForm.sortNo" placeholder="菜单排序"></el-input>
    </el-form-item>
    <el-form-item label="聚合子路由: 1是0否" prop="alwaysShow">
      <el-input v-model="dataForm.alwaysShow" placeholder="聚合子路由: 1是0否"></el-input>
    </el-form-item>
    <el-form-item label="菜单图标" prop="icon">
      <el-input v-model="dataForm.icon" placeholder="菜单图标"></el-input>
    </el-form-item>
    <el-form-item label="是否叶子节点:    1是0否" prop="isLeaf">
      <el-input v-model="dataForm.isLeaf" placeholder="是否叶子节点:    1是0否"></el-input>
    </el-form-item>
    <el-form-item label="是否缓存该页面:    1:是   0:不是" prop="keepAlive">
      <el-input v-model="dataForm.keepAlive" placeholder="是否缓存该页面:    1:是   0:不是"></el-input>
    </el-form-item>
    <el-form-item label="是否隐藏路由: 0否,1是" prop="hidden">
      <el-input v-model="dataForm.hidden" placeholder="是否隐藏路由: 0否,1是"></el-input>
    </el-form-item>
    <el-form-item label="是否隐藏tab: 0否,1是" prop="hideTab">
      <el-input v-model="dataForm.hideTab" placeholder="是否隐藏tab: 0否,1是"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="description">
      <el-input v-model="dataForm.description" placeholder="描述"></el-input>
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
    <el-form-item label="删除状态 0正常 1已删除" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="删除状态 0正常 1已删除"></el-input>
    </el-form-item>
    <el-form-item label="是否添加数据权限1是0否" prop="ruleFlag">
      <el-input v-model="dataForm.ruleFlag" placeholder="是否添加数据权限1是0否"></el-input>
    </el-form-item>
    <el-form-item label="按钮权限状态(0无效1有效)" prop="status">
      <el-input v-model="dataForm.status" placeholder="按钮权限状态(0无效1有效)"></el-input>
    </el-form-item>
    <el-form-item label="外链菜单打开方式 0/内部打开 1/外部打开" prop="internalOrExternal">
      <el-input v-model="dataForm.internalOrExternal" placeholder="外链菜单打开方式 0/内部打开 1/外部打开"></el-input>
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
          parentId: '',
          name: '',
          url: '',
          component: '',
          isRoute: '',
          componentName: '',
          redirect: '',
          menuType: '',
          perms: '',
          permsType: '',
          sortNo: '',
          alwaysShow: '',
          icon: '',
          isLeaf: '',
          keepAlive: '',
          hidden: '',
          hideTab: '',
          description: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          delFlag: '',
          ruleFlag: '',
          status: '',
          internalOrExternal: ''
        },
        dataRule: {
          parentId: [
            { required: true, message: '父id不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '菜单标题不能为空', trigger: 'blur' }
          ],
          url: [
            { required: true, message: '路径不能为空', trigger: 'blur' }
          ],
          component: [
            { required: true, message: '组件不能为空', trigger: 'blur' }
          ],
          isRoute: [
            { required: true, message: '是否路由菜单: 0:不是  1:是（默认值1）不能为空', trigger: 'blur' }
          ],
          componentName: [
            { required: true, message: '组件名字不能为空', trigger: 'blur' }
          ],
          redirect: [
            { required: true, message: '一级菜单跳转地址不能为空', trigger: 'blur' }
          ],
          menuType: [
            { required: true, message: '菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)不能为空', trigger: 'blur' }
          ],
          perms: [
            { required: true, message: '菜单权限编码不能为空', trigger: 'blur' }
          ],
          permsType: [
            { required: true, message: '权限策略1显示2禁用不能为空', trigger: 'blur' }
          ],
          sortNo: [
            { required: true, message: '菜单排序不能为空', trigger: 'blur' }
          ],
          alwaysShow: [
            { required: true, message: '聚合子路由: 1是0否不能为空', trigger: 'blur' }
          ],
          icon: [
            { required: true, message: '菜单图标不能为空', trigger: 'blur' }
          ],
          isLeaf: [
            { required: true, message: '是否叶子节点:    1是0否不能为空', trigger: 'blur' }
          ],
          keepAlive: [
            { required: true, message: '是否缓存该页面:    1:是   0:不是不能为空', trigger: 'blur' }
          ],
          hidden: [
            { required: true, message: '是否隐藏路由: 0否,1是不能为空', trigger: 'blur' }
          ],
          hideTab: [
            { required: true, message: '是否隐藏tab: 0否,1是不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
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
          delFlag: [
            { required: true, message: '删除状态 0正常 1已删除不能为空', trigger: 'blur' }
          ],
          ruleFlag: [
            { required: true, message: '是否添加数据权限1是0否不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '按钮权限状态(0无效1有效)不能为空', trigger: 'blur' }
          ],
          internalOrExternal: [
            { required: true, message: '外链菜单打开方式 0/内部打开 1/外部打开不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/syspermission/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.parentId = data.sysPermission.parentId
                this.dataForm.name = data.sysPermission.name
                this.dataForm.url = data.sysPermission.url
                this.dataForm.component = data.sysPermission.component
                this.dataForm.isRoute = data.sysPermission.isRoute
                this.dataForm.componentName = data.sysPermission.componentName
                this.dataForm.redirect = data.sysPermission.redirect
                this.dataForm.menuType = data.sysPermission.menuType
                this.dataForm.perms = data.sysPermission.perms
                this.dataForm.permsType = data.sysPermission.permsType
                this.dataForm.sortNo = data.sysPermission.sortNo
                this.dataForm.alwaysShow = data.sysPermission.alwaysShow
                this.dataForm.icon = data.sysPermission.icon
                this.dataForm.isLeaf = data.sysPermission.isLeaf
                this.dataForm.keepAlive = data.sysPermission.keepAlive
                this.dataForm.hidden = data.sysPermission.hidden
                this.dataForm.hideTab = data.sysPermission.hideTab
                this.dataForm.description = data.sysPermission.description
                this.dataForm.createBy = data.sysPermission.createBy
                this.dataForm.createTime = data.sysPermission.createTime
                this.dataForm.updateBy = data.sysPermission.updateBy
                this.dataForm.updateTime = data.sysPermission.updateTime
                this.dataForm.delFlag = data.sysPermission.delFlag
                this.dataForm.ruleFlag = data.sysPermission.ruleFlag
                this.dataForm.status = data.sysPermission.status
                this.dataForm.internalOrExternal = data.sysPermission.internalOrExternal
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
              url: this.$http.adornUrl(`/ware/syspermission/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'parentId': this.dataForm.parentId,
                'name': this.dataForm.name,
                'url': this.dataForm.url,
                'component': this.dataForm.component,
                'isRoute': this.dataForm.isRoute,
                'componentName': this.dataForm.componentName,
                'redirect': this.dataForm.redirect,
                'menuType': this.dataForm.menuType,
                'perms': this.dataForm.perms,
                'permsType': this.dataForm.permsType,
                'sortNo': this.dataForm.sortNo,
                'alwaysShow': this.dataForm.alwaysShow,
                'icon': this.dataForm.icon,
                'isLeaf': this.dataForm.isLeaf,
                'keepAlive': this.dataForm.keepAlive,
                'hidden': this.dataForm.hidden,
                'hideTab': this.dataForm.hideTab,
                'description': this.dataForm.description,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'delFlag': this.dataForm.delFlag,
                'ruleFlag': this.dataForm.ruleFlag,
                'status': this.dataForm.status,
                'internalOrExternal': this.dataForm.internalOrExternal
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
