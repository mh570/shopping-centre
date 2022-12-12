<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('ware:onlcgformfield:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('ware:onlcgformfield:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
        prop="cgformHeadId"
        header-align="center"
        align="center"
        label="表ID">
      </el-table-column>
      <el-table-column
        prop="dbFieldName"
        header-align="center"
        align="center"
        label="字段名字">
      </el-table-column>
      <el-table-column
        prop="dbFieldTxt"
        header-align="center"
        align="center"
        label="字段备注">
      </el-table-column>
      <el-table-column
        prop="dbFieldNameOld"
        header-align="center"
        align="center"
        label="原字段名">
      </el-table-column>
      <el-table-column
        prop="dbIsKey"
        header-align="center"
        align="center"
        label="是否主键 0否 1是">
      </el-table-column>
      <el-table-column
        prop="dbIsNull"
        header-align="center"
        align="center"
        label="是否允许为空0否 1是">
      </el-table-column>
      <el-table-column
        prop="dbIsPersist"
        header-align="center"
        align="center"
        label="是否需要同步数据库字段， 1是0否">
      </el-table-column>
      <el-table-column
        prop="dbType"
        header-align="center"
        align="center"
        label="数据库字段类型">
      </el-table-column>
      <el-table-column
        prop="dbLength"
        header-align="center"
        align="center"
        label="数据库字段长度">
      </el-table-column>
      <el-table-column
        prop="dbPointLength"
        header-align="center"
        align="center"
        label="小数点">
      </el-table-column>
      <el-table-column
        prop="dbDefaultVal"
        header-align="center"
        align="center"
        label="表字段默认值">
      </el-table-column>
      <el-table-column
        prop="dictField"
        header-align="center"
        align="center"
        label="字典code">
      </el-table-column>
      <el-table-column
        prop="dictTable"
        header-align="center"
        align="center"
        label="字典表">
      </el-table-column>
      <el-table-column
        prop="dictText"
        header-align="center"
        align="center"
        label="字典Text">
      </el-table-column>
      <el-table-column
        prop="fieldShowType"
        header-align="center"
        align="center"
        label="表单控件类型">
      </el-table-column>
      <el-table-column
        prop="fieldHref"
        header-align="center"
        align="center"
        label="跳转URL">
      </el-table-column>
      <el-table-column
        prop="fieldLength"
        header-align="center"
        align="center"
        label="表单控件长度">
      </el-table-column>
      <el-table-column
        prop="fieldValidType"
        header-align="center"
        align="center"
        label="表单字段校验规则">
      </el-table-column>
      <el-table-column
        prop="fieldMustInput"
        header-align="center"
        align="center"
        label="字段是否必填">
      </el-table-column>
      <el-table-column
        prop="fieldExtendJson"
        header-align="center"
        align="center"
        label="扩展参数JSON">
      </el-table-column>
      <el-table-column
        prop="fieldDefaultValue"
        header-align="center"
        align="center"
        label="控件默认值，不同的表达式展示不同的结果。
1. 纯字符串直接赋给默认值；
2. #{普通变量}；
3. {{ 动态JS表达式 }}；
4. ${填值规则编码}；
填值规则表达式只允许存在一个，且不能和其他规则混用。">
      </el-table-column>
      <el-table-column
        prop="isQuery"
        header-align="center"
        align="center"
        label="是否查询条件0否 1是">
      </el-table-column>
      <el-table-column
        prop="isShowForm"
        header-align="center"
        align="center"
        label="表单是否显示0否 1是">
      </el-table-column>
      <el-table-column
        prop="isShowList"
        header-align="center"
        align="center"
        label="列表是否显示0否 1是">
      </el-table-column>
      <el-table-column
        prop="isReadOnly"
        header-align="center"
        align="center"
        label="是否是只读（1是 0否）">
      </el-table-column>
      <el-table-column
        prop="queryMode"
        header-align="center"
        align="center"
        label="查询模式">
      </el-table-column>
      <el-table-column
        prop="mainTable"
        header-align="center"
        align="center"
        label="外键主表名">
      </el-table-column>
      <el-table-column
        prop="mainField"
        header-align="center"
        align="center"
        label="外键主键字段">
      </el-table-column>
      <el-table-column
        prop="orderNum"
        header-align="center"
        align="center"
        label="排序">
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
        prop="createTime"
        header-align="center"
        align="center"
        label="创建时间">
      </el-table-column>
      <el-table-column
        prop="createBy"
        header-align="center"
        align="center"
        label="创建人">
      </el-table-column>
      <el-table-column
        prop="converter"
        header-align="center"
        align="center"
        label="自定义值转换器">
      </el-table-column>
      <el-table-column
        prop="queryDefVal"
        header-align="center"
        align="center"
        label="查询默认值">
      </el-table-column>
      <el-table-column
        prop="queryDictText"
        header-align="center"
        align="center"
        label="查询配置字典text">
      </el-table-column>
      <el-table-column
        prop="queryDictField"
        header-align="center"
        align="center"
        label="查询配置字典code">
      </el-table-column>
      <el-table-column
        prop="queryDictTable"
        header-align="center"
        align="center"
        label="查询配置字典table">
      </el-table-column>
      <el-table-column
        prop="queryShowType"
        header-align="center"
        align="center"
        label="查询显示控件">
      </el-table-column>
      <el-table-column
        prop="queryConfigFlag"
        header-align="center"
        align="center"
        label="是否启用查询配置1是0否">
      </el-table-column>
      <el-table-column
        prop="queryValidType"
        header-align="center"
        align="center"
        label="查询字段校验类型">
      </el-table-column>
      <el-table-column
        prop="queryMustInput"
        header-align="center"
        align="center"
        label="查询字段是否必填1是0否">
      </el-table-column>
      <el-table-column
        prop="sortFlag"
        header-align="center"
        align="center"
        label="是否支持排序1是0否">
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
  import AddOrUpdate from './onlcgformfield-add-or-update'
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
          url: this.$http.adornUrl('/ware/onlcgformfield/list'),
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
            url: this.$http.adornUrl('/ware/onlcgformfield/delete'),
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
