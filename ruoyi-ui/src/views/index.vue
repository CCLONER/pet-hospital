<template>
  <div class="app-container home">
    <el-container>
                   <el-aside width="600px" height="300px"><bar /></el-aside>    
                             <el-main
        ><bing1 /> <br />

        <el-calendar v-model="value"> </el-calendar>
      </el-main>
                   </el-container
    >
       
  </div>
</template>
<style></style>
<script>
import Bar from "../views/myEcharts/Bar.vue";
import Bing1 from "../views/myEcharts/bing1.vue";
export default {
  components: { Bar, Bing1 },
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.1",
      value: new Date(),
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>
<style>
.el-calendar-table .el-calendar-day {
  height: 30px;
}
</style>
