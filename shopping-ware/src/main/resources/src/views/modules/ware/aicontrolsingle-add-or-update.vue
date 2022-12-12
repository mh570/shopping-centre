<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
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
    <el-form-item label="所属部门" prop="sysOrgCode">
      <el-input v-model="dataForm.sysOrgCode" placeholder="所属部门"></el-input>
    </el-form-item>
    <el-form-item label="单价" prop="price">
      <el-input v-model="dataForm.price" placeholder="单价"></el-input>
    </el-form-item>
    <el-form-item label="用户名" prop="name">
      <el-input v-model="dataForm.name" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="miMa">
      <el-input v-model="dataForm.miMa" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="字典下拉" prop="xiala">
      <el-input v-model="dataForm.xiala" placeholder="字典下拉"></el-input>
    </el-form-item>
    <el-form-item label="字典单选" prop="danxuan">
      <el-input v-model="dataForm.danxuan" placeholder="字典单选"></el-input>
    </el-form-item>
    <el-form-item label="字典多选" prop="duoxuan">
      <el-input v-model="dataForm.duoxuan" placeholder="字典多选"></el-input>
    </el-form-item>
    <el-form-item label="开关" prop="kaiguan">
      <el-input v-model="dataForm.kaiguan" placeholder="开关"></el-input>
    </el-form-item>
    <el-form-item label="日期" prop="riqi">
      <el-input v-model="dataForm.riqi" placeholder="日期"></el-input>
    </el-form-item>
    <el-form-item label="年月日时分秒" prop="nyrsfm">
      <el-input v-model="dataForm.nyrsfm" placeholder="年月日时分秒"></el-input>
    </el-form-item>
    <el-form-item label="时间" prop="shijian">
      <el-input v-model="dataForm.shijian" placeholder="时间"></el-input>
    </el-form-item>
    <el-form-item label="文件" prop="wenjian">
      <el-input v-model="dataForm.wenjian" placeholder="文件"></el-input>
    </el-form-item>
    <el-form-item label="图片" prop="tupian">
      <el-input v-model="dataForm.tupian" placeholder="图片"></el-input>
    </el-form-item>
    <el-form-item label="多行文本框" prop="dhwb">
      <el-input v-model="dataForm.dhwb" placeholder="多行文本框"></el-input>
    </el-form-item>
    <el-form-item label="字典下拉多选框" prop="xldx">
      <el-input v-model="dataForm.xldx" placeholder="字典下拉多选框"></el-input>
    </el-form-item>
    <el-form-item label="字典表下拉搜索框" prop="xlss">
      <el-input v-model="dataForm.xlss" placeholder="字典表下拉搜索框"></el-input>
    </el-form-item>
    <el-form-item label="popup弹窗" prop="popup">
      <el-input v-model="dataForm.popup" placeholder="popup弹窗"></el-input>
    </el-form-item>
    <el-form-item label="popback" prop="popback">
      <el-input v-model="dataForm.popback" placeholder="popback"></el-input>
    </el-form-item>
    <el-form-item label="分类字典树" prop="flzds">
      <el-input v-model="dataForm.flzds" placeholder="分类字典树"></el-input>
    </el-form-item>
    <el-form-item label="部门选择" prop="bmxz">
      <el-input v-model="dataForm.bmxz" placeholder="部门选择"></el-input>
    </el-form-item>
    <el-form-item label="用户选择" prop="yhxz">
      <el-input v-model="dataForm.yhxz" placeholder="用户选择"></el-input>
    </el-form-item>
    <el-form-item label="富文本" prop="fwb">
      <el-input v-model="dataForm.fwb" placeholder="富文本"></el-input>
    </el-form-item>
    <el-form-item label="markdown" prop="markdown">
      <el-input v-model="dataForm.markdown" placeholder="markdown"></el-input>
    </el-form-item>
    <el-form-item label="省市区" prop="shq">
      <el-input v-model="dataForm.shq" placeholder="省市区"></el-input>
    </el-form-item>
    <el-form-item label="联动组件一" prop="ldzuy">
      <el-input v-model="dataForm.ldzuy" placeholder="联动组件一"></el-input>
    </el-form-item>
    <el-form-item label="联动组件二" prop="ldzje">
      <el-input v-model="dataForm.ldzje" placeholder="联动组件二"></el-input>
    </el-form-item>
    <el-form-item label="联动组件三" prop="ldzjs">
      <el-input v-model="dataForm.ldzjs" placeholder="联动组件三"></el-input>
    </el-form-item>
    <el-form-item label="自定义树" prop="zdys">
      <el-input v-model="dataForm.zdys" placeholder="自定义树"></el-input>
    </el-form-item>
    <el-form-item label="double类型" prop="yuanjia">
      <el-input v-model="dataForm.yuanjia" placeholder="double类型"></el-input>
    </el-form-item>
    <el-form-item label="integer类型" prop="geshu">
      <el-input v-model="dataForm.geshu" placeholder="integer类型"></el-input>
    </el-form-item>
    <el-form-item label="唯一检验" prop="jycs">
      <el-input v-model="dataForm.jycs" placeholder="唯一检验"></el-input>
    </el-form-item>
    <el-form-item label="输入2到10位的字母" prop="province">
      <el-input v-model="dataForm.province" placeholder="输入2到10位的字母"></el-input>
    </el-form-item>
    <el-form-item label="自定义查询" prop="zdmrz">
      <el-input v-model="dataForm.zdmrz" placeholder="自定义查询"></el-input>
    </el-form-item>
    <el-form-item label="字典表下拉" prop="zdbxl">
      <el-input v-model="dataForm.zdbxl" placeholder="字典表下拉"></el-input>
    </el-form-item>
    <el-form-item label="字典表单选" prop="zdbdx">
      <el-input v-model="dataForm.zdbdx" placeholder="字典表单选"></el-input>
    </el-form-item>
    <el-form-item label="字典表多选" prop="zdbduoxuan">
      <el-input v-model="dataForm.zdbduoxuan" placeholder="字典表多选"></el-input>
    </el-form-item>
    <el-form-item label="字典表下拉多选" prop="zdbxldx">
      <el-input v-model="dataForm.zdbxldx" placeholder="字典表下拉多选"></el-input>
    </el-form-item>
    <el-form-item label="字典表带条件下拉" prop="zddtjxl">
      <el-input v-model="dataForm.zddtjxl" placeholder="字典表带条件下拉"></el-input>
    </el-form-item>
    <el-form-item label="字典表带条件单选" prop="zddtjdx">
      <el-input v-model="dataForm.zddtjdx" placeholder="字典表带条件单选"></el-input>
    </el-form-item>
    <el-form-item label="字典表带条件多选" prop="zddtjduox">
      <el-input v-model="dataForm.zddtjduox" placeholder="字典表带条件多选"></el-input>
    </el-form-item>
    <el-form-item label="字典表带条件下拉多选" prop="zddtjxldx">
      <el-input v-model="dataForm.zddtjxldx" placeholder="字典表带条件下拉多选"></el-input>
    </el-form-item>
    <el-form-item label="字典表带条件下拉搜索" prop="zddtjxlss">
      <el-input v-model="dataForm.zddtjxlss" placeholder="字典表带条件下拉搜索"></el-input>
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
          price: '',
          name: '',
          miMa: '',
          xiala: '',
          danxuan: '',
          duoxuan: '',
          kaiguan: '',
          riqi: '',
          nyrsfm: '',
          shijian: '',
          wenjian: '',
          tupian: '',
          dhwb: '',
          xldx: '',
          xlss: '',
          popup: '',
          popback: '',
          flzds: '',
          bmxz: '',
          yhxz: '',
          fwb: '',
          markdown: '',
          shq: '',
          ldzuy: '',
          ldzje: '',
          ldzjs: '',
          zdys: '',
          yuanjia: '',
          geshu: '',
          jycs: '',
          province: '',
          zdmrz: '',
          zdbxl: '',
          zdbdx: '',
          zdbduoxuan: '',
          zdbxldx: '',
          zddtjxl: '',
          zddtjdx: '',
          zddtjduox: '',
          zddtjxldx: '',
          zddtjxlss: ''
        },
        dataRule: {
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
          sysOrgCode: [
            { required: true, message: '所属部门不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '单价不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          miMa: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          xiala: [
            { required: true, message: '字典下拉不能为空', trigger: 'blur' }
          ],
          danxuan: [
            { required: true, message: '字典单选不能为空', trigger: 'blur' }
          ],
          duoxuan: [
            { required: true, message: '字典多选不能为空', trigger: 'blur' }
          ],
          kaiguan: [
            { required: true, message: '开关不能为空', trigger: 'blur' }
          ],
          riqi: [
            { required: true, message: '日期不能为空', trigger: 'blur' }
          ],
          nyrsfm: [
            { required: true, message: '年月日时分秒不能为空', trigger: 'blur' }
          ],
          shijian: [
            { required: true, message: '时间不能为空', trigger: 'blur' }
          ],
          wenjian: [
            { required: true, message: '文件不能为空', trigger: 'blur' }
          ],
          tupian: [
            { required: true, message: '图片不能为空', trigger: 'blur' }
          ],
          dhwb: [
            { required: true, message: '多行文本框不能为空', trigger: 'blur' }
          ],
          xldx: [
            { required: true, message: '字典下拉多选框不能为空', trigger: 'blur' }
          ],
          xlss: [
            { required: true, message: '字典表下拉搜索框不能为空', trigger: 'blur' }
          ],
          popup: [
            { required: true, message: 'popup弹窗不能为空', trigger: 'blur' }
          ],
          popback: [
            { required: true, message: 'popback不能为空', trigger: 'blur' }
          ],
          flzds: [
            { required: true, message: '分类字典树不能为空', trigger: 'blur' }
          ],
          bmxz: [
            { required: true, message: '部门选择不能为空', trigger: 'blur' }
          ],
          yhxz: [
            { required: true, message: '用户选择不能为空', trigger: 'blur' }
          ],
          fwb: [
            { required: true, message: '富文本不能为空', trigger: 'blur' }
          ],
          markdown: [
            { required: true, message: 'markdown不能为空', trigger: 'blur' }
          ],
          shq: [
            { required: true, message: '省市区不能为空', trigger: 'blur' }
          ],
          ldzuy: [
            { required: true, message: '联动组件一不能为空', trigger: 'blur' }
          ],
          ldzje: [
            { required: true, message: '联动组件二不能为空', trigger: 'blur' }
          ],
          ldzjs: [
            { required: true, message: '联动组件三不能为空', trigger: 'blur' }
          ],
          zdys: [
            { required: true, message: '自定义树不能为空', trigger: 'blur' }
          ],
          yuanjia: [
            { required: true, message: 'double类型不能为空', trigger: 'blur' }
          ],
          geshu: [
            { required: true, message: 'integer类型不能为空', trigger: 'blur' }
          ],
          jycs: [
            { required: true, message: '唯一检验不能为空', trigger: 'blur' }
          ],
          province: [
            { required: true, message: '输入2到10位的字母不能为空', trigger: 'blur' }
          ],
          zdmrz: [
            { required: true, message: '自定义查询不能为空', trigger: 'blur' }
          ],
          zdbxl: [
            { required: true, message: '字典表下拉不能为空', trigger: 'blur' }
          ],
          zdbdx: [
            { required: true, message: '字典表单选不能为空', trigger: 'blur' }
          ],
          zdbduoxuan: [
            { required: true, message: '字典表多选不能为空', trigger: 'blur' }
          ],
          zdbxldx: [
            { required: true, message: '字典表下拉多选不能为空', trigger: 'blur' }
          ],
          zddtjxl: [
            { required: true, message: '字典表带条件下拉不能为空', trigger: 'blur' }
          ],
          zddtjdx: [
            { required: true, message: '字典表带条件单选不能为空', trigger: 'blur' }
          ],
          zddtjduox: [
            { required: true, message: '字典表带条件多选不能为空', trigger: 'blur' }
          ],
          zddtjxldx: [
            { required: true, message: '字典表带条件下拉多选不能为空', trigger: 'blur' }
          ],
          zddtjxlss: [
            { required: true, message: '字典表带条件下拉搜索不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/aicontrolsingle/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.createBy = data.aiControlSingle.createBy
                this.dataForm.createTime = data.aiControlSingle.createTime
                this.dataForm.updateBy = data.aiControlSingle.updateBy
                this.dataForm.updateTime = data.aiControlSingle.updateTime
                this.dataForm.sysOrgCode = data.aiControlSingle.sysOrgCode
                this.dataForm.price = data.aiControlSingle.price
                this.dataForm.name = data.aiControlSingle.name
                this.dataForm.miMa = data.aiControlSingle.miMa
                this.dataForm.xiala = data.aiControlSingle.xiala
                this.dataForm.danxuan = data.aiControlSingle.danxuan
                this.dataForm.duoxuan = data.aiControlSingle.duoxuan
                this.dataForm.kaiguan = data.aiControlSingle.kaiguan
                this.dataForm.riqi = data.aiControlSingle.riqi
                this.dataForm.nyrsfm = data.aiControlSingle.nyrsfm
                this.dataForm.shijian = data.aiControlSingle.shijian
                this.dataForm.wenjian = data.aiControlSingle.wenjian
                this.dataForm.tupian = data.aiControlSingle.tupian
                this.dataForm.dhwb = data.aiControlSingle.dhwb
                this.dataForm.xldx = data.aiControlSingle.xldx
                this.dataForm.xlss = data.aiControlSingle.xlss
                this.dataForm.popup = data.aiControlSingle.popup
                this.dataForm.popback = data.aiControlSingle.popback
                this.dataForm.flzds = data.aiControlSingle.flzds
                this.dataForm.bmxz = data.aiControlSingle.bmxz
                this.dataForm.yhxz = data.aiControlSingle.yhxz
                this.dataForm.fwb = data.aiControlSingle.fwb
                this.dataForm.markdown = data.aiControlSingle.markdown
                this.dataForm.shq = data.aiControlSingle.shq
                this.dataForm.ldzuy = data.aiControlSingle.ldzuy
                this.dataForm.ldzje = data.aiControlSingle.ldzje
                this.dataForm.ldzjs = data.aiControlSingle.ldzjs
                this.dataForm.zdys = data.aiControlSingle.zdys
                this.dataForm.yuanjia = data.aiControlSingle.yuanjia
                this.dataForm.geshu = data.aiControlSingle.geshu
                this.dataForm.jycs = data.aiControlSingle.jycs
                this.dataForm.province = data.aiControlSingle.province
                this.dataForm.zdmrz = data.aiControlSingle.zdmrz
                this.dataForm.zdbxl = data.aiControlSingle.zdbxl
                this.dataForm.zdbdx = data.aiControlSingle.zdbdx
                this.dataForm.zdbduoxuan = data.aiControlSingle.zdbduoxuan
                this.dataForm.zdbxldx = data.aiControlSingle.zdbxldx
                this.dataForm.zddtjxl = data.aiControlSingle.zddtjxl
                this.dataForm.zddtjdx = data.aiControlSingle.zddtjdx
                this.dataForm.zddtjduox = data.aiControlSingle.zddtjduox
                this.dataForm.zddtjxldx = data.aiControlSingle.zddtjxldx
                this.dataForm.zddtjxlss = data.aiControlSingle.zddtjxlss
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
              url: this.$http.adornUrl(`/ware/aicontrolsingle/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'sysOrgCode': this.dataForm.sysOrgCode,
                'price': this.dataForm.price,
                'name': this.dataForm.name,
                'miMa': this.dataForm.miMa,
                'xiala': this.dataForm.xiala,
                'danxuan': this.dataForm.danxuan,
                'duoxuan': this.dataForm.duoxuan,
                'kaiguan': this.dataForm.kaiguan,
                'riqi': this.dataForm.riqi,
                'nyrsfm': this.dataForm.nyrsfm,
                'shijian': this.dataForm.shijian,
                'wenjian': this.dataForm.wenjian,
                'tupian': this.dataForm.tupian,
                'dhwb': this.dataForm.dhwb,
                'xldx': this.dataForm.xldx,
                'xlss': this.dataForm.xlss,
                'popup': this.dataForm.popup,
                'popback': this.dataForm.popback,
                'flzds': this.dataForm.flzds,
                'bmxz': this.dataForm.bmxz,
                'yhxz': this.dataForm.yhxz,
                'fwb': this.dataForm.fwb,
                'markdown': this.dataForm.markdown,
                'shq': this.dataForm.shq,
                'ldzuy': this.dataForm.ldzuy,
                'ldzje': this.dataForm.ldzje,
                'ldzjs': this.dataForm.ldzjs,
                'zdys': this.dataForm.zdys,
                'yuanjia': this.dataForm.yuanjia,
                'geshu': this.dataForm.geshu,
                'jycs': this.dataForm.jycs,
                'province': this.dataForm.province,
                'zdmrz': this.dataForm.zdmrz,
                'zdbxl': this.dataForm.zdbxl,
                'zdbdx': this.dataForm.zdbdx,
                'zdbduoxuan': this.dataForm.zdbduoxuan,
                'zdbxldx': this.dataForm.zdbxldx,
                'zddtjxl': this.dataForm.zddtjxl,
                'zddtjdx': this.dataForm.zddtjdx,
                'zddtjduox': this.dataForm.zddtjduox,
                'zddtjxldx': this.dataForm.zddtjxldx,
                'zddtjxlss': this.dataForm.zddtjxlss
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
