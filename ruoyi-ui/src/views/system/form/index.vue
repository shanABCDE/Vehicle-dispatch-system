<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">




      <el-form-item label="状态" prop="state">
           <el-select v-model="queryParams.state" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
          <el-option  label="未派单"
            value="0" ></el-option>
               <el-option  label="运输中"
            value="1" ></el-option>
                    <el-option  label="已完成"
            value="2" ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>



    <el-table v-loading="loading" :data="formList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="客户" align="center" prop="clienteleName" />
    <el-table-column label="出发地址" align="center" prop="depart" />
      <el-table-column label="到达地址" align="center" prop="arrive" />
      <el-table-column label="交易金额" align="center" prop="sum" />
       <el-table-column label="客户电话" align="center" prop="clienteleRelation" />
      <el-table-column label="驾驶员" align="center" prop="driverName" />
          <el-table-column label="驾驶员电话" align="center" prop="driverRelation" />
      <el-table-column label="车辆车牌" align="center" prop="vehicleLicencePlate" />
    <el-table-column label="车辆型号" align="center" prop="vehicleMotorcycleType" />
    <el-table-column label="备注" align="center" prop="remark" />
           <el-table-column label="状态" align="center" prop="state" >
        <template slot-scope="scope">
              <span>{{scope.row.state==2 ? '已完成': scope.row.state == 0 ? '未派单' : '运输中'}} </span>
            </template>
      </el-table-column>
                <el-table-column label="登记时间" align="center" prop="createTime"  width="160">
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.createTime) }}</span>
            </template>
          </el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:form:edit']"
          >派单</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="giveBack(scope.row)"
            v-hasPermi="['system:form:remove']"
          >车辆归还</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改【功能】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">

        <el-form-item label="驾驶员" prop="driverId">

            <el-select  v-model="form.driverId" placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
            <el-option v-for="(item, index) in field102Options" :key="index" :label="item.name"
              :value="item.id" :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="车辆" prop="vehicleId">
        <el-select v-model="form.vehicleId"  placeholder="请选择下拉选择" clearable :style="{width: '100%'}">
            <el-option v-for="(item, index) in  field103Options" :key="index" :label="item.licencePlate"
              :value="item.id" :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listForm, getForm, delForm, addForm, updateForm,getDriver, getVehicle,giveBack} from "@/api/system/form";

export default {
  name: "Form",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
          field102Options: [],
      field103Options: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 【功能】表格数据
      formList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        clienteleId: null,
        content: null,
        driverId: null,
        vehicleId: null,
        depart: null,
        arrive: null,
        sum: null,
        state: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询 */
    getList() {
      this.loading = true;
      listForm(this.queryParams).then(response => {
        this.formList = response.orderFormVos;
        this.total = response.data.total;
        this.loading = false;
      });
      getVehicle().then(response => {
       this.field103Options=response.data
      })

      getDriver().then(response => {
        this.field102Options=response.data
      })
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },

    // 表单重置
    reset() {
      this.form = {
        id: null,
        clienteleId: null,
        content: null,
        driverId: null,
        vehicleId: null,
        depart: null,
        arrive: null,
        sum: null,
        state: null,
        remark: null,
        createTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加【功能】";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getForm(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【功能】";
      });
    },

   giveBack(row) {
      this.reset();
      const id = row.id || this.ids
      getForm(id).then(response => {
      console.log(response.data);
            this.$modal.confirm('是否确认归还车辆车牌为"' + row.vehicleLicencePlate + '"的数据项？').then(function() {
        return giveBack(response.data);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("车辆归还成功");
      }).catch(() => {});
      });
    },



    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateForm(this.form).then(response => {
              this.$modal.msgSuccess("派单成功");
              this.open = false;
              this.getList();
            });
          } else {
            addForm(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },

    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除【功能】编号为"' + ids + '"的数据项？').then(function() {
        return delForm(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/form/export', {
        ...this.queryParams
      }, `form_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
