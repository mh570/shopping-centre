<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('ware:onlcgformhead:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('ware:onlcgformhead:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        label="主键ID">
      </el-table-column>
      <el-table-column
        prop="tableName"
        header-align="center"
        align="center"
        label="表名">
      </el-table-column>
      <el-table-column
        prop="tableType"
        header-align="center"
        align="center"
        label="表类型: 0单表、1主表、2附表">
      </el-table-column>
      <el-table-column
        prop="tableVersion"
        header-align="center"
        align="center"
        label="表版本">
      </el-table-column>
      <el-table-column
        prop="tableTxt"
        header-align="center"
        align="center"
        label="表说明">
      </el-table-column>
      <el-table-column
        prop="isCheckbox"
        header-align="center"
        align="center"
        label="是否带checkbox">
      </el-table-column>
      <el-table-column
        prop="isDbSynch"
        header-align="center"
        align="center"
        label="同步数据库状态">
      </el-table-column>
      <el-table-column
        prop="isPage"
        header-align="center"
        align="center"
        label="是否分页">
      </el-table-column>
      <el-table-column
        prop="isTree"
        header-align="center"
        align="center"
        label="是否是树">
      </el-table-column>
      <el-table-column
        prop="idSequence"
        header-align="center"
        align="center"
        label="主键生成序列">
      </el-table-column>
      <el-table-column
        prop="idType"
        header-align="center"
        align="center"
        label="主键类型">
      </el-table-column>
      <el-table-column
        prop="queryMode"
        header-align="center"
        align="center"
        label="查询模式">
      </el-table-column>
      <el-table-column
        prop="relationType"
        header-align="center"
        align="center"
        label="映射关系 0一对多  1一对一">
      </el-table-column>
      <el-table-column
        prop="subTableStr"
        header-align="center"
        align="center"
        label="子表">
      </el-table-column>
      <el-table-column
        prop="tabOrderNum"
        header-align="center"
        align="center"
        label="附表排序序号">
      </el-table-column>
      <el-table-column
        prop="treeParentIdField"
        header-align="center"
        align="center"
        label="树形表单父id">
      </el-table-column>
      <el-table-column
        prop="treeIdField"
        header-align="center"
        align="center"
        label="树表主键字段">
      </el-table-column>
      <el-table-column
        prop="treeFieldname"
        header-align="center"
        align="center"
        label="树开表单列字段">
      </el-table-column>
      <el-table-column
        prop="formCategory"
        header-align="center"
        align="center"
        label="表单分类">
      </el-table-column>
      <el-table-column
        prop="formTemplate"
        header-align="center"
        align="center"
        label="PC表单模板">
      </el-table-column>
      <el-table-column
        prop="formTemplateMobile"
        header-align="center"
        align="center"
        label="表单模板样式(移动端)">
      </el-table-column>
      <el-table-column
        prop="scroll"
        header-align="center"
        align="center"
        label="是否有横向滚动条">
      </el-table-column>
      <el-table-column
        prop="copyVersion"
        header-align="center"
        align="center"
        label="复制版本号">
      </el-table-column>
      <el-table-column
        prop="copyType"
        header-align="center"
        align="center"
        label="复制表类型1为复制表 0为原始表">
      </el-table-column>
      <el-table-column
        prop="physicId"
        header-align="center"
        align="center"
        label="原始表ID">
      </el-table-column>
      <el-table-column
        prop="extConfigJson"
        header-align="center"
        align="center"
        label="扩展JSON">
      </el-table-column>
      <el-table-column
        prop="updateBy"
        header-align="center"
        align="center"
        label="修改人">
      </el-table-column>
      <el-table-column
        prop="updateTime"
        header-align="center"
        align="center"
        label="修改时间">
      </el-table-column>
      <el-table-column
        prop="createBy"
        header-align="center"
        align="center"
        label="创建人">
      </el-table-column>
      <el-table-column
        prop="createTime"
        header-align="center"
        align="center"
        label="创建时间">
      </el-table-column>
      <el-table-column
        prop="themeTemplate"
        header-align="center"
        align="center"
        label="主题模板">
      </el-table-column>
      <el-table-column
        prop="isDesForm"
        header-align="center"
        align="center"
        label="是否用设计器表单">
      </el-table-column>
      <el-table-column
        prop="desFormCode"
        header-align="center"
        align="center"
        label="设计器表单编码">
      </el-table-column>
      <el-table-column
        prop="lowAppId"
        header-align="center"
        align="center"
        label="关联的应用ID">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './onlcgformhead-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/ware/onlcgformhead/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/ware/onlcgformhead/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
