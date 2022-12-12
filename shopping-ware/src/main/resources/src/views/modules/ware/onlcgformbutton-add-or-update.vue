<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="按钮编码" prop="buttonCode">
      <el-input v-model="dataForm.buttonCode" placeholder="按钮编码"></el-input>
    </el-form-item>
    <el-form-item label="按钮图标" prop="buttonIcon">
      <el-input v-model="dataForm.buttonIcon" placeholder="按钮图标"></el-input>
    </el-form-item>
    <el-form-item label="按钮名称" prop="buttonName">
      <el-input v-model="dataForm.buttonName" placeholder="按钮名称"></el-input>
    </el-form-item>
    <el-form-item label="按钮状态" prop="buttonStatus">
      <el-input v-model="dataForm.buttonStatus" placeholder="按钮状态"></el-input>
    </el-form-item>
    <el-form-item label="按钮样式" prop="buttonStyle">
      <el-input v-model="dataForm.buttonStyle" placeholder="按钮样式"></el-input>
    </el-form-item>
    <el-form-item label="表达式" prop="exp">
      <el-input v-model="dataForm.exp" placeholder="表达式"></el-input>
    </el-form-item>
    <el-form-item label="表单ID" prop="cgformHeadId">
      <el-input v-model="dataForm.cgformHeadId" placeholder="表单ID"></el-input>
    </el-form-item>
    <el-form-item label="按钮类型" prop="optType">
      <el-input v-model="dataForm.optType" placeholder="按钮类型"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="orderNum">
      <el-input v-model="dataForm.orderNum" placeholder="排序"></el-input>
    </el-form-item>
    <el-form-item label="按钮位置1侧面 2底部" prop="optPosition">
      <el-input v-model="dataForm.optPosition" placeholder="按钮位置1侧面 2底部"></el-input>
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
          buttonCode: '',
          buttonIcon: '',
          buttonName: '',
          buttonStatus: '',
          buttonStyle: '',
          exp: '',
          cgformHeadId: '',
          optType: '',
          orderNum: '',
          optPosition: ''
        },
        dataRule: {
          buttonCode: [
            { required: true, message: '按钮编码不能为空', trigger: 'blur' }
          ],
          buttonIcon: [
            { required: true, message: '按钮图标不能为空', trigger: 'blur' }
          ],
          buttonName: [
            { required: true, message: '按钮名称不能为空', trigger: 'blur' }
          ],
          buttonStatus: [
            { required: true, message: '按钮状态不能为空', trigger: 'blur' }
          ],
          buttonStyle: [
            { required: true, message: '按钮样式不能为空', trigger: 'blur' }
          ],
          exp: [
            { required: true, message: '表达式不能为空', trigger: 'blur' }
          ],
          cgformHeadId: [
            { required: true, message: '表单ID不能为空', trigger: 'blur' }
          ],
          optType: [
            { required: true, message: '按钮类型不能为空', trigger: 'blur' }
          ],
          orderNum: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ],
          optPosition: [
            { required: true, message: '按钮位置1侧面 2底部不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/onlcgformbutton/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.buttonCode = data.onlCgformButton.buttonCode
                this.dataForm.buttonIcon = data.onlCgformButton.buttonIcon
                this.dataForm.buttonName = data.onlCgformButton.buttonName
                this.dataForm.buttonStatus = data.onlCgformButton.buttonStatus
                this.dataForm.buttonStyle = data.onlCgformButton.buttonStyle
                this.dataForm.exp = data.onlCgformButton.exp
                this.dataForm.cgformHeadId = data.onlCgformButton.cgformHeadId
                this.dataForm.optType = data.onlCgformButton.optType
                this.dataForm.orderNum = data.onlCgformButton.orderNum
                this.dataForm.optPosition = data.onlCgformButton.optPosition
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
              url: this.$http.adornUrl(`/ware/onlcgformbutton/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'buttonCode': this.dataForm.buttonCode,
                'buttonIcon': this.dataForm.buttonIcon,
                'buttonName': this.dataForm.buttonName,
                'buttonStatus': this.dataForm.buttonStatus,
                'buttonStyle': this.dataForm.buttonStyle,
                'exp': this.dataForm.exp,
                'cgformHeadId': this.dataForm.cgformHeadId,
                'optType': this.dataForm.optType,
                'orderNum': this.dataForm.orderNum,
                'optPosition': this.dataForm.optPosition
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
