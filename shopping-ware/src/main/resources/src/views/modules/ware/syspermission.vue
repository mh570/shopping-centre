<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('ware:syspermission:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('ware:syspermission:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
        label="主键id">
      </el-table-column>
      <el-table-column
        prop="parentId"
        header-align="center"
        align="center"
        label="父id">
      </el-table-column>
      <el-table-column
        prop="name"
        header-align="center"
        align="center"
        label="菜单标题">
      </el-table-column>
      <el-table-column
        prop="url"
        header-align="center"
        align="center"
        label="路径">
      </el-table-column>
      <el-table-column
        prop="component"
        header-align="center"
        align="center"
        label="组件">
      </el-table-column>
      <el-table-column
        prop="isRoute"
        header-align="center"
        align="center"
        label="是否路由菜单: 0:不是  1:是（默认值1）">
      </el-table-column>
      <el-table-column
        prop="componentName"
        header-align="center"
        align="center"
        label="组件名字">
      </el-table-column>
      <el-table-column
        prop="redirect"
        header-align="center"
        align="center"
        label="一级菜单跳转地址">
      </el-table-column>
      <el-table-column
        prop="menuType"
        header-align="center"
        align="center"
        label="菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)">
      </el-table-column>
      <el-table-column
        prop="perms"
        header-align="center"
        align="center"
        label="菜单权限编码">
      </el-table-column>
      <el-table-column
        prop="permsType"
        header-align="center"
        align="center"
        label="权限策略1显示2禁用">
      </el-table-column>
      <el-table-column
        prop="sortNo"
        header-align="center"
        align="center"
        label="菜单排序">
      </el-table-column>
      <el-table-column
        prop="alwaysShow"
        header-align="center"
        align="center"
        label="聚合子路由: 1是0否">
      </el-table-column>
      <el-table-column
        prop="icon"
        header-align="center"
        align="center"
        label="菜单图标">
      </el-table-column>
      <el-table-column
        prop="isLeaf"
        header-align="center"
        align="center"
        label="是否叶子节点:    1是0否">
      </el-table-column>
      <el-table-column
        prop="keepAlive"
        header-align="center"
        align="center"
        label="是否缓存该页面:    1:是   0:不是">
      </el-table-column>
      <el-table-column
        prop="hidden"
        header-align="center"
        align="center"
        label="是否隐藏路由: 0否,1是">
      </el-table-column>
      <el-table-column
        prop="hideTab"
        header-align="center"
        align="center"
        label="是否隐藏tab: 0否,1是">
      </el-table-column>
      <el-table-column
        prop="description"
        header-align="center"
        align="center"
        label="描述">
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
        prop="updateBy"
        header-align="center"
        align="center"
        label="更新人">
      </el-table-column>
      <el-table-column
        prop="updateTime"
        header-align="center"
        align="center"
        label="更新时间">
      </el-table-column>
      <el-table-column
        prop="delFlag"
        header-align="center"
        align="center"
        label="删除状态 0正常 1已删除">
      </el-table-column>
      <el-table-column
        prop="ruleFlag"
        header-align="center"
        align="center"
        label="是否添加数据权限1是0否">
      </el-table-column>
      <el-table-column
        prop="status"
        header-align="center"
        align="center"
        label="按钮权限状态(0无效1有效)">
      </el-table-column>
      <el-table-column
        prop="internalOrExternal"
        header-align="center"
        align="center"
        label="外链菜单打开方式 0/内部打开 1/外部打开">
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
  import AddOrUpdate from './syspermission-add-or-update'
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
          url: this.$http.adornUrl('/ware/syspermission/list'),
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
            url: this.$http.adornUrl('/ware/syspermission/delete'),
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
