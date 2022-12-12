<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="bnum">
      <el-input v-model="dataForm.bnum" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="ftime">
      <el-input v-model="dataForm.ftime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sfkong">
      <el-input v-model="dataForm.sfkong" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="kaishi">
      <el-input v-model="dataForm.kaishi" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="jieshu">
      <el-input v-model="dataForm.jieshu" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="hezairen">
      <el-input v-model="dataForm.hezairen" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="jpnum">
      <el-input v-model="dataForm.jpnum" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="shihelv">
      <el-input v-model="dataForm.shihelv" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sId">
      <el-input v-model="dataForm.sId" placeholder=""></el-input>
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
          bnum: '',
          ftime: '',
          sfkong: '',
          kaishi: '',
          jieshu: '',
          hezairen: '',
          jpnum: '',
          shihelv: '',
          sId: ''
        },
        dataRule: {
          bnum: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          ftime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sfkong: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          kaishi: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          jieshu: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          hezairen: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          jpnum: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          shihelv: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sId: [
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
              url: this.$http.adornUrl(`/ware/repdemojianpiao/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.bnum = data.repDemoJianpiao.bnum
                this.dataForm.ftime = data.repDemoJianpiao.ftime
                this.dataForm.sfkong = data.repDemoJianpiao.sfkong
                this.dataForm.kaishi = data.repDemoJianpiao.kaishi
                this.dataForm.jieshu = data.repDemoJianpiao.jieshu
                this.dataForm.hezairen = data.repDemoJianpiao.hezairen
                this.dataForm.jpnum = data.repDemoJianpiao.jpnum
                this.dataForm.shihelv = data.repDemoJianpiao.shihelv
                this.dataForm.sId = data.repDemoJianpiao.sId
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
              url: this.$http.adornUrl(`/ware/repdemojianpiao/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'bnum': this.dataForm.bnum,
                'ftime': this.dataForm.ftime,
                'sfkong': this.dataForm.sfkong,
                'kaishi': this.dataForm.kaishi,
                'jieshu': this.dataForm.jieshu,
                'hezairen': this.dataForm.hezairen,
                'jpnum': this.dataForm.jpnum,
                'shihelv': this.dataForm.shihelv,
                'sId': this.dataForm.sId
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
