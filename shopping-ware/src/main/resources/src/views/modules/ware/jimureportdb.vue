<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('ware:jimureportdb:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('ware:jimureportdb:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
        label="id">
      </el-table-column>
      <el-table-column
        prop="jimuReportId"
        header-align="center"
        align="center"
        label="主键字段">
      </el-table-column>
      <el-table-column
        prop="createBy"
        header-align="center"
        align="center"
        label="创建人登录名称">
      </el-table-column>
      <el-table-column
        prop="updateBy"
        header-align="center"
        align="center"
        label="更新人登录名称">
      </el-table-column>
      <el-table-column
        prop="createTime"
        header-align="center"
        align="center"
        label="创建日期">
      </el-table-column>
      <el-table-column
        prop="updateTime"
        header-align="center"
        align="center"
        label="更新日期">
      </el-table-column>
      <el-table-column
        prop="dbCode"
        header-align="center"
        align="center"
        label="数据集编码">
      </el-table-column>
      <el-table-column
        prop="dbChName"
        header-align="center"
        align="center"
        label="数据集名字">
      </el-table-column>
      <el-table-column
        prop="dbType"
        header-align="center"
        align="center"
        label="数据源类型">
      </el-table-column>
      <el-table-column
        prop="dbTableName"
        header-align="center"
        align="center"
        label="数据库表名">
      </el-table-column>
      <el-table-column
        prop="dbDynSql"
        header-align="center"
        align="center"
        label="动态查询SQL">
      </el-table-column>
      <el-table-column
        prop="dbKey"
        header-align="center"
        align="center"
        label="数据源KEY">
      </el-table-column>
      <el-table-column
        prop="tbDbKey"
        header-align="center"
        align="center"
        label="填报数据源">
      </el-table-column>
      <el-table-column
        prop="tbDbTableName"
        header-align="center"
        align="center"
        label="填报数据表">
      </el-table-column>
      <el-table-column
        prop="javaType"
        header-align="center"
        align="center"
        label="java类数据集  类型（spring:springkey,class:java类名）">
      </el-table-column>
      <el-table-column
        prop="javaValue"
        header-align="center"
        align="center"
        label="java类数据源  数值（bean key/java类名）">
      </el-table-column>
      <el-table-column
        prop="apiUrl"
        header-align="center"
        align="center"
        label="请求地址">
      </el-table-column>
      <el-table-column
        prop="apiMethod"
        header-align="center"
        align="center"
        label="请求方法0-get,1-post">
      </el-table-column>
      <el-table-column
        prop="isList"
        header-align="center"
        align="center"
        label="是否是列表0否1是 默认0">
      </el-table-column>
      <el-table-column
        prop="isPage"
        header-align="center"
        align="center"
        label="是否作为分页,0:不分页，1:分页">
      </el-table-column>
      <el-table-column
        prop="dbSource"
        header-align="center"
        align="center"
        label="数据源">
      </el-table-column>
      <el-table-column
        prop="dbSourceType"
        header-align="center"
        align="center"
        label="数据库类型 MYSQL ORACLE SQLSERVER">
      </el-table-column>
      <el-table-column
        prop="jsonData"
        header-align="center"
        align="center"
        label="json数据，直接解析json内容">
      </el-table-column>
      <el-table-column
        prop="apiConvert"
        header-align="center"
        align="center"
        label="api转换器">
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
  import AddOrUpdate from './jimureportdb-add-or-update'
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
          url: this.$http.adornUrl('/ware/jimureportdb/list'),
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
            url: this.$http.adornUrl('/ware/jimureportdb/delete'),
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
