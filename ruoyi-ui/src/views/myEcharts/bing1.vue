<template>
  <div id="bing1" :style="{ width: '400px', height: '200px' }"></div>
</template>
<script>
import { getbing1 } from "./../../api/system/echarts";
export default {
  name: "Echarts",
  mounted() {
    let _this = this;

    getbing1().then((res) => {
      // 基于准备好的dom，初始化echarts实例
      let bing1 = _this.$echarts.init(document.getElementById("bing1"));
      // 绘制图表 setOption方法
      bing1.setOption({
        title: {
          text: "登记病例宠物类型分布",
          right: 10,
          top: 0,
          textStyle: {
            color: "#555555",
            fontSize: "15",
          },
        },
        tooltip: {
          trigger: "item",
        },
        legend: {
          orient: "vertical",
          left: "left",
        },
        series: [
          {
            type: "pie",
            data: res,
            radius: "70%",
            center: ["53%", "60%"],
            // emphasis: {
            //   itemStyle: {
            //     shadowBlur: 10,
            //     shadowOffsetX: 0,
            //     shadowColor: "rgba(0, 0, 0, 0.5)",
            //   },
            // },
          },
        ],
      });
    });
  },
};
</script>
