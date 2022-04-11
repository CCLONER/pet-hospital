<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="宠物名称" prop="petName">
        <el-input
          v-model="queryParams.petName"
          placeholder="请输入宠物名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="美容类型" prop="petShape">
        <el-select
          v-model="queryParams.petShape"
          placeholder="请选择美容类型"
          clearable
        >
          <el-option
            v-for="dict in dict.type.pet_shape"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="处理时间" prop="cpTime">
        <el-date-picker
          clearable
          v-model="queryParams.cpTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择处理时间"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="主人手机" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入主人手机"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="主人姓名" prop="masterName">
        <el-input
          v-model="queryParams.masterName"
          placeholder="请输入主人姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:model:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:model:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:model:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:model:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="modelList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="宠物名称" align="center" prop="petName" />
      <!-- <el-table-column label="医生id" align="center" prop="doctor" /> -->
      <el-table-column label="美容类型" align="center" prop="petShape">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.pet_shape"
            :value="scope.row.petShape"
          />
        </template>
      </el-table-column>
      <el-table-column
        label="处理时间"
        align="center"
        prop="cpTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.cpTime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="主人手机" align="center" prop="phone" />
      <el-table-column label="主人姓名" align="center" prop="masterName" />
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:model:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:model:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改美容造型对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="宠物名称" prop="petName">
          <el-input v-model="form.petName" placeholder="请输入宠物名称" />
        </el-form-item>
        <el-form-item label="美容类型" prop="petShape">
          <el-select v-model="form.petShape" placeholder="请选择美容类型">
            <el-option
              v-for="dict in dict.type.pet_shape"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="美容师" prop="doctor">
          <el-select v-model="form.doctor" placeholder="请选择主治医生/美容师">
            <el-option
              v-for="item in doctorsList"
              :key="item.userId"
              :label="item.nickName"
              :value="item.userId"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="处理时间" prop="cpTime">
          <el-date-picker
            clearable
            v-model="form.cpTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择处理时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主人手机" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入主人手机" />
        </el-form-item>
        <el-form-item label="主人姓名" prop="masterName">
          <el-input v-model="form.masterName" placeholder="请输入主人姓名" />
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
import {
  listModel,
  getModel,
  delModel,
  addModel,
  updateModel,
} from "@/api/system/model";

import { getDoctors } from "@/api/system/user";

export default {
  name: "Model",
  dicts: ["pet_shape"],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 美容造型表格数据
      modelList: [],
      //美容师 医生列表
      doctorsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        petName: null,
        doctor: null,
        petShape: null,
        cpTime: null,
        phone: null,
        masterName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        doctor: [
          { required: true, message: "医生id不能为空", trigger: "change" },
        ],
        petShape: [
          { required: true, message: "美容类型不能为空", trigger: "change" },
        ],
      },
    };
  },
  created() {
    this.getList();
    this.getDoctors();
  },
  methods: {
    //查询医生 美容师用户列表
    getDoctors() {
      getDoctors().then((response) => {
        this.doctorsList = response.doctor;
        console.log(JSON.stringify(this.doctorsList));
      });
    },

    /** 查询美容造型列表 */
    getList() {
      this.loading = true;
      listModel(this.queryParams).then((response) => {
        this.modelList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
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
        petName: null,
        doctor: null,
        petShape: null,
        cpTime: null,
        phone: null,
        masterName: null,
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
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加美容造型";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getModel(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改美容造型";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateModel(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addModel(this.form).then((response) => {
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
      this.$modal
        .confirm('是否确认删除美容造型编号为"' + ids + '"的数据项？')
        .then(function () {
          return delModel(ids);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "system/model/export",
        {
          ...this.queryParams,
        },
        `model_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
