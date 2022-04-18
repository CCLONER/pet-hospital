<template>
  <div id="bing1" :style="{ width: '300px', height: '300px' }"></div>
</template>
<script>
export default {
  name: "Echarts",
  mounted() {
    // 基于准备好的dom，初始化echarts实例
    let bing1 = this.$echarts.init(document.getElementById("bing1"));
    // 绘制图表 setOption方法
    bing1.setOption({
      series: [
        {
          type: "pie",
          data: [
            {
              value: 335,
              name: "直接访问",
            },
            {
              value: 234,
              name: "联盟广告",
            },
            {
              value: 1548,
              name: "搜索引擎",
            },
          ],
        },
      ],
    });
  },
};
</script>
