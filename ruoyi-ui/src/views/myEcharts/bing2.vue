<template>
  <div id="bing2" :style="{ width: '800px', height: '600px' }"></div>
</template>
<script>
export default {
  name: "Echarts",
  mounted() {
    // 基于准备好的dom，初始化echarts实例
    let bing2 = this.$echarts.init(document.getElementById("bing2"));
    // 绘制图表 setOption方法
    bing2.setOption({
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
