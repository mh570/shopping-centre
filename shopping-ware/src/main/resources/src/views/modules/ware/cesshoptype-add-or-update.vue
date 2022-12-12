<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
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
    <el-form-item label="分类名字" prop="name">
      <el-input v-model="dataForm.name" placeholder="分类名字"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="content">
      <el-input v-model="dataForm.content" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="图片" prop="pics">
      <el-input v-model="dataForm.pics" placeholder="图片"></el-input>
    </el-form-item>
    <el-form-item label="父级节点" prop="pid">
      <el-input v-model="dataForm.pid" placeholder="父级节点"></el-input>
    </el-form-item>
    <el-form-item label="是否有子节点" prop="hasChild">
      <el-input v-model="dataForm.hasChild" placeholder="是否有子节点"></el-input>
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
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          sysOrgCode: '',
          name: '',
          content: '',
          pics: '',
          pid: '',
          hasChild: ''
        },
        dataRule: {
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
          ],
          name: [
            { required: true, message: '分类名字不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          pics: [
            { required: true, message: '图片不能为空', trigger: 'blur' }
          ],
          pid: [
            { required: true, message: '父级节点不能为空', trigger: 'blur' }
          ],
          hasChild: [
            { required: true, message: '是否有子节点不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/cesshoptype/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.createBy = data.cesShopType.createBy
                this.dataForm.createTime = data.cesShopType.createTime
                this.dataForm.updateBy = data.cesShopType.updateBy
                this.dataForm.updateTime = data.cesShopType.updateTime
                this.dataForm.sysOrgCode = data.cesShopType.sysOrgCode
                this.dataForm.name = data.cesShopType.name
                this.dataForm.content = data.cesShopType.content
                this.dataForm.pics = data.cesShopType.pics
                this.dataForm.pid = data.cesShopType.pid
                this.dataForm.hasChild = data.cesShopType.hasChild
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
              url: this.$http.adornUrl(`/ware/cesshoptype/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'sysOrgCode': this.dataForm.sysOrgCode,
                'name': this.dataForm.name,
                'content': this.dataForm.content,
                'pics': this.dataForm.pics,
                'pid': this.dataForm.pid,
                'hasChild': this.dataForm.hasChild
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
