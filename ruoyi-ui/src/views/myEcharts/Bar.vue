<template>
  <div id="myChart" :style="{ width: '550px', height: '550px' }"></div>
</template>
<script>
import axios from "axios";
import { getbar } from "./../../api/system/echarts";
export default {
  name: "Echarts",

  mounted() {
    let _this = this;
    getbar().then((res) => {
      // 基于准备好的dom，初始化echarts实例
      let myChart = _this.$echarts.init(document.getElementById("myChart"));
      // 绘制图表 setOption方法
      myChart.setOption({
        //设置标题属性
        title: {
          text: "宠物医院岗位人员分布",
          left: "center",
          top: 20,
          textStyle: {
            color: "#555555",
          },
        },
        tooltip: {},
        //x轴
        xAxis: {
          data: res.names,
        },
        //y轴
        yAxis: {},
        //真正数据
        series: [
          {
            name: "人数",
            type: "bar",
            data: res.values,
          },
        ],
      });
    });
  },
};
</script>
