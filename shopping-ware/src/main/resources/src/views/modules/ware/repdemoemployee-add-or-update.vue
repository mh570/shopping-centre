<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="编号" prop="num">
      <el-input v-model="dataForm.num" placeholder="编号"></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="出生日期" prop="birthday">
      <el-input v-model="dataForm.birthday" placeholder="出生日期"></el-input>
    </el-form-item>
    <el-form-item label="民族" prop="nation">
      <el-input v-model="dataForm.nation" placeholder="民族"></el-input>
    </el-form-item>
    <el-form-item label="政治面貌" prop="political">
      <el-input v-model="dataForm.political" placeholder="政治面貌"></el-input>
    </el-form-item>
    <el-form-item label="籍贯" prop="nativePlace">
      <el-input v-model="dataForm.nativePlace" placeholder="籍贯"></el-input>
    </el-form-item>
    <el-form-item label="身高" prop="height">
      <el-input v-model="dataForm.height" placeholder="身高"></el-input>
    </el-form-item>
    <el-form-item label="体重" prop="weight">
      <el-input v-model="dataForm.weight" placeholder="体重"></el-input>
    </el-form-item>
    <el-form-item label="健康状况" prop="health">
      <el-input v-model="dataForm.health" placeholder="健康状况"></el-input>
    </el-form-item>
    <el-form-item label="身份证号" prop="idCard">
      <el-input v-model="dataForm.idCard" placeholder="身份证号"></el-input>
    </el-form-item>
    <el-form-item label="学历" prop="education">
      <el-input v-model="dataForm.education" placeholder="学历"></el-input>
    </el-form-item>
    <el-form-item label="毕业学校" prop="school">
      <el-input v-model="dataForm.school" placeholder="毕业学校"></el-input>
    </el-form-item>
    <el-form-item label="专业" prop="major">
      <el-input v-model="dataForm.major" placeholder="专业"></el-input>
    </el-form-item>
    <el-form-item label="联系地址" prop="address">
      <el-input v-model="dataForm.address" placeholder="联系地址"></el-input>
    </el-form-item>
    <el-form-item label="邮编" prop="zipCode">
      <el-input v-model="dataForm.zipCode" placeholder="邮编"></el-input>
    </el-form-item>
    <el-form-item label="Email" prop="email">
      <el-input v-model="dataForm.email" placeholder="Email"></el-input>
    </el-form-item>
    <el-form-item label="手机号" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="手机号"></el-input>
    </el-form-item>
    <el-form-item label="外语语种" prop="foreignLanguage">
      <el-input v-model="dataForm.foreignLanguage" placeholder="外语语种"></el-input>
    </el-form-item>
    <el-form-item label="外语水平" prop="foreignLanguageLevel">
      <el-input v-model="dataForm.foreignLanguageLevel" placeholder="外语水平"></el-input>
    </el-form-item>
    <el-form-item label="计算机水平" prop="computerLevel">
      <el-input v-model="dataForm.computerLevel" placeholder="计算机水平"></el-input>
    </el-form-item>
    <el-form-item label="毕业时间" prop="graduationTime">
      <el-input v-model="dataForm.graduationTime" placeholder="毕业时间"></el-input>
    </el-form-item>
    <el-form-item label="到职时间" prop="arrivalTime">
      <el-input v-model="dataForm.arrivalTime" placeholder="到职时间"></el-input>
    </el-form-item>
    <el-form-item label="职称" prop="positionalTitles">
      <el-input v-model="dataForm.positionalTitles" placeholder="职称"></el-input>
    </el-form-item>
    <el-form-item label="教育经历" prop="educationExperience">
      <el-input v-model="dataForm.educationExperience" placeholder="教育经历"></el-input>
    </el-form-item>
    <el-form-item label="工作经历" prop="workExperience">
      <el-input v-model="dataForm.workExperience" placeholder="工作经历"></el-input>
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
          num: '',
          name: '',
          sex: '',
          birthday: '',
          nation: '',
          political: '',
          nativePlace: '',
          height: '',
          weight: '',
          health: '',
          idCard: '',
          education: '',
          school: '',
          major: '',
          address: '',
          zipCode: '',
          email: '',
          phone: '',
          foreignLanguage: '',
          foreignLanguageLevel: '',
          computerLevel: '',
          graduationTime: '',
          arrivalTime: '',
          positionalTitles: '',
          educationExperience: '',
          workExperience: '',
          createBy: '',
          createTime: '',
          updateBy: '',
          updateTime: '',
          delFlag: ''
        },
        dataRule: {
          num: [
            { required: true, message: '编号不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          birthday: [
            { required: true, message: '出生日期不能为空', trigger: 'blur' }
          ],
          nation: [
            { required: true, message: '民族不能为空', trigger: 'blur' }
          ],
          political: [
            { required: true, message: '政治面貌不能为空', trigger: 'blur' }
          ],
          nativePlace: [
            { required: true, message: '籍贯不能为空', trigger: 'blur' }
          ],
          height: [
            { required: true, message: '身高不能为空', trigger: 'blur' }
          ],
          weight: [
            { required: true, message: '体重不能为空', trigger: 'blur' }
          ],
          health: [
            { required: true, message: '健康状况不能为空', trigger: 'blur' }
          ],
          idCard: [
            { required: true, message: '身份证号不能为空', trigger: 'blur' }
          ],
          education: [
            { required: true, message: '学历不能为空', trigger: 'blur' }
          ],
          school: [
            { required: true, message: '毕业学校不能为空', trigger: 'blur' }
          ],
          major: [
            { required: true, message: '专业不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '联系地址不能为空', trigger: 'blur' }
          ],
          zipCode: [
            { required: true, message: '邮编不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: 'Email不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '手机号不能为空', trigger: 'blur' }
          ],
          foreignLanguage: [
            { required: true, message: '外语语种不能为空', trigger: 'blur' }
          ],
          foreignLanguageLevel: [
            { required: true, message: '外语水平不能为空', trigger: 'blur' }
          ],
          computerLevel: [
            { required: true, message: '计算机水平不能为空', trigger: 'blur' }
          ],
          graduationTime: [
            { required: true, message: '毕业时间不能为空', trigger: 'blur' }
          ],
          arrivalTime: [
            { required: true, message: '到职时间不能为空', trigger: 'blur' }
          ],
          positionalTitles: [
            { required: true, message: '职称不能为空', trigger: 'blur' }
          ],
          educationExperience: [
            { required: true, message: '教育经历不能为空', trigger: 'blur' }
          ],
          workExperience: [
            { required: true, message: '工作经历不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ware/repdemoemployee/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.num = data.repDemoEmployee.num
                this.dataForm.name = data.repDemoEmployee.name
                this.dataForm.sex = data.repDemoEmployee.sex
                this.dataForm.birthday = data.repDemoEmployee.birthday
                this.dataForm.nation = data.repDemoEmployee.nation
                this.dataForm.political = data.repDemoEmployee.political
                this.dataForm.nativePlace = data.repDemoEmployee.nativePlace
                this.dataForm.height = data.repDemoEmployee.height
                this.dataForm.weight = data.repDemoEmployee.weight
                this.dataForm.health = data.repDemoEmployee.health
                this.dataForm.idCard = data.repDemoEmployee.idCard
                this.dataForm.education = data.repDemoEmployee.education
                this.dataForm.school = data.repDemoEmployee.school
                this.dataForm.major = data.repDemoEmployee.major
                this.dataForm.address = data.repDemoEmployee.address
                this.dataForm.zipCode = data.repDemoEmployee.zipCode
                this.dataForm.email = data.repDemoEmployee.email
                this.dataForm.phone = data.repDemoEmployee.phone
                this.dataForm.foreignLanguage = data.repDemoEmployee.foreignLanguage
                this.dataForm.foreignLanguageLevel = data.repDemoEmployee.foreignLanguageLevel
                this.dataForm.computerLevel = data.repDemoEmployee.computerLevel
                this.dataForm.graduationTime = data.repDemoEmployee.graduationTime
                this.dataForm.arrivalTime = data.repDemoEmployee.arrivalTime
                this.dataForm.positionalTitles = data.repDemoEmployee.positionalTitles
                this.dataForm.educationExperience = data.repDemoEmployee.educationExperience
                this.dataForm.workExperience = data.repDemoEmployee.workExperience
                this.dataForm.createBy = data.repDemoEmployee.createBy
                this.dataForm.createTime = data.repDemoEmployee.createTime
                this.dataForm.updateBy = data.repDemoEmployee.updateBy
                this.dataForm.updateTime = data.repDemoEmployee.updateTime
                this.dataForm.delFlag = data.repDemoEmployee.delFlag
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
              url: this.$http.adornUrl(`/ware/repdemoemployee/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'num': this.dataForm.num,
                'name': this.dataForm.name,
                'sex': this.dataForm.sex,
                'birthday': this.dataForm.birthday,
                'nation': this.dataForm.nation,
                'political': this.dataForm.political,
                'nativePlace': this.dataForm.nativePlace,
                'height': this.dataForm.height,
                'weight': this.dataForm.weight,
                'health': this.dataForm.health,
                'idCard': this.dataForm.idCard,
                'education': this.dataForm.education,
                'school': this.dataForm.school,
                'major': this.dataForm.major,
                'address': this.dataForm.address,
                'zipCode': this.dataForm.zipCode,
                'email': this.dataForm.email,
                'phone': this.dataForm.phone,
                'foreignLanguage': this.dataForm.foreignLanguage,
                'foreignLanguageLevel': this.dataForm.foreignLanguageLevel,
                'computerLevel': this.dataForm.computerLevel,
                'graduationTime': this.dataForm.graduationTime,
                'arrivalTime': this.dataForm.arrivalTime,
                'positionalTitles': this.dataForm.positionalTitles,
                'educationExperience': this.dataForm.educationExperience,
                'workExperience': this.dataForm.workExperience,
                'createBy': this.dataForm.createBy,
                'createTime': this.dataForm.createTime,
                'updateBy': this.dataForm.updateBy,
                'updateTime': this.dataForm.updateTime,
                'delFlag': this.dataForm.delFlag
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
