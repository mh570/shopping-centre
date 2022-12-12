<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="父机构ID" prop="parentId">
      <el-input v-model="dataForm.parentId" placeholder="父机构ID"></el-input>
    </el-form-item>
    <el-form-item label="机构/部门名称" prop="departName">
      <el-input v-model="dataForm.departName" placeholder="机构/部门名称"></el-input>
    </el-form-item>
    <el-form-item label="英文名" prop="departNameEn">
      <el-input v-model="dataForm.departNameEn" placeholder="英文名"></el-input>
    </el-form-item>
    <el-form-item label="缩写" prop="departNameAbbr">
      <el-input v-model="dataForm.departNameAbbr" placeholder="缩写"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="departOrder">
      <el-input v-model="dataForm.departOrder" placeholder="排序"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="description">
      <el-input v-model="dataForm.description" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="机构类别 1公司，2组织机构，2岗位" prop="orgCategory">
      <el-input v-model="dataForm.orgCategory" placeholder="机构类别 1公司，2组织机构，2岗位"></el-input>
    </el-form-item>
    <el-form-item label="机构类型 1一级部门 2子部门" prop="orgType">
      <el-input v-model="dataForm.orgType" placeholder="机构类型 1一级部门 2子部门"></el-input>
    </el-form-item>
    <el-form-item label="机构编码" prop="orgCode">
      <el-input v-model="dataForm.orgCode" placeholder="机构编码"></el-input>
    </el-form-item>
    <el-form-item label="手机号" prop="mobile">
      <el-input v-model="dataForm.mobile" placeholder="手机号"></el-input>
    </el-form-item>
    <el-form-item label="传真" prop="fax">
      <el-input v-model="dataForm.fax" placeholder="传真"></el-input>
    </el-form-item>
    <el-form-item label="地址" prop="address">
      <el-input v-model="dataForm.address" placeholder="地址"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="memo">
      <el-input v-model="dataForm.memo" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="状态（1启用，0不启用）" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态（1启用，0不启用）"></el-input>
    </el-form-item>
    <el-form-item label="删除状态（0，正常，1已删除）" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="删除状态（0，正常，1已删除）"></el-input>
    </el-form-item>
    <el-form-item label="对接企业微信的ID" prop="qywxIdentifier">
      <el-input v-model="dataForm.qywxIdentifier" placeholder="对接企业微信的ID"></el-input>
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
          parentId: '',
          departName: '',
          departNameEn: '',
          departNameAbbr: '',
          departOrder: '',
          description: '',
          orgCategory: '',
          orgType: '',
          orgCode: '',
          mobile: '',
          fax: '',
          address: '',
          memo: '',
          status: '',
          delFlag: '',
          qywxIdentifier: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: ''
        },
        dataRule: {
          parentId: [
            { required: true, message: '父机构ID不能为空', trigger: 'blur' }
          ],
          departName: [
            { required: true, message: '机构/部门名称不能为空', trigger: 'blur' }
          ],
          departNameEn: [
            { required: true, message: '英文名不能为空', trigger: 'blur' }
          ],
          departNameAbbr: [
            { required: true, message: '缩写不能为空', trigger: 'blur' }
          ],
          departOrder: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          orgCategory: [
            { required: true, message: '机构类别 1公司，2组织机构，2岗位不能为空', trigger: 'blur' }
          ],
          orgType: [
            { required: true, message: '机构类型 1一级部门 2子部门不能为空', trigger: 'blur' }
          ],
          orgCode: [
            { required: true, message: '机构编码不能为空', trigger: 'blur' }
          ],
          mobile: [
            { required: true, message: '手机号不能为空', trigger: 'blur' }
          ],
          fax: [
            { required: true, message: '传真不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '地址不能为空', trigger: 'blur' }
          ],
          memo: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态（1启用，0不启用）不能为空', trigger: 'blur' }
          ],
          delFlag: [
            { required: true, message: '删除状态（0，正常，1已删除）不能为空', trigger: 'blur' }
          ],
          qywxIdentifier: [
            { required: true, message: '对接企业微信的ID不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/sysdepart/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.parentId = data.sysDepart.parentId
                this.dataForm.departName = data.sysDepart.departName
                this.dataForm.departNameEn = data.sysDepart.departNameEn
                this.dataForm.departNameAbbr = data.sysDepart.departNameAbbr
                this.dataForm.departOrder = data.sysDepart.departOrder
                this.dataForm.description = data.sysDepart.description
                this.dataForm.orgCategory = data.sysDepart.orgCategory
                this.dataForm.orgType = data.sysDepart.orgType
                this.dataForm.orgCode = data.sysDepart.orgCode
                this.dataForm.mobile = data.sysDepart.mobile
                this.dataForm.fax = data.sysDepart.fax
                this.dataForm.address = data.sysDepart.address
                this.dataForm.memo = data.sysDepart.memo
                this.dataForm.status = data.sysDepart.status
                this.dataForm.delFlag = data.sysDepart.delFlag
                this.dataForm.qywxIdentifier = data.sysDepart.qywxIdentifier
                this.dataForm.createBy = data.sysDepart.createBy
                this.dataForm.createTime = data.sysDepart.createTime
                this.dataForm.updateBy = data.sysDepart.updateBy
                this.dataForm.updateTime = data.sysDepart.updateTime
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
              url: this.$http.adornUrl(`/ware/sysdepart/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'parentId': this.dataForm.parentId,
                'departName': this.dataForm.departName,
                'departNameEn': this.dataForm.departNameEn,
                'departNameAbbr': this.dataForm.departNameAbbr,
                'departOrder': this.dataForm.departOrder,
                'description': this.dataForm.description,
                'orgCategory': this.dataForm.orgCategory,
                'orgType': this.dataForm.orgType,
                'orgCode': this.dataForm.orgCode,
                'mobile': this.dataForm.mobile,
                'fax': this.dataForm.fax,
                'address': this.dataForm.address,
                'memo': this.dataForm.memo,
                'status': this.dataForm.status,
                'delFlag': this.dataForm.delFlag,
                'qywxIdentifier': this.dataForm.qywxIdentifier,
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
