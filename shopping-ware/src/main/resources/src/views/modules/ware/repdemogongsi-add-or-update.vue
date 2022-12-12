<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="货品名称" prop="gname">
      <el-input v-model="dataForm.gname" placeholder="货品名称"></el-input>
    </el-form-item>
    <el-form-item label="返利" prop="gdata">
      <el-input v-model="dataForm.gdata" placeholder="返利"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="tdata">
      <el-input v-model="dataForm.tdata" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="" prop="didian">
      <el-input v-model="dataForm.didian" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="zhaiyao">
      <el-input v-model="dataForm.zhaiyao" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="num">
      <el-input v-model="dataForm.num" placeholder=""></el-input>
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
          gname: '',
          gdata: '',
          tdata: '',
          didian: '',
          zhaiyao: '',
          num: ''
        },
        dataRule: {
          gname: [
            { required: true, message: '货品名称不能为空', trigger: 'blur' }
          ],
          gdata: [
            { required: true, message: '返利不能为空', trigger: 'blur' }
          ],
          tdata: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          didian: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          zhaiyao: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          num: [
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
              url: this.$http.adornUrl(`/ware/repdemogongsi/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.gname = data.repDemoGongsi.gname
                this.dataForm.gdata = data.repDemoGongsi.gdata
                this.dataForm.tdata = data.repDemoGongsi.tdata
                this.dataForm.didian = data.repDemoGongsi.didian
                this.dataForm.zhaiyao = data.repDemoGongsi.zhaiyao
                this.dataForm.num = data.repDemoGongsi.num
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
              url: this.$http.adornUrl(`/ware/repdemogongsi/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'gname': this.dataForm.gname,
                'gdata': this.dataForm.gdata,
                'tdata': this.dataForm.tdata,
                'didian': this.dataForm.didian,
                'zhaiyao': this.dataForm.zhaiyao,
                'num': this.dataForm.num
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
