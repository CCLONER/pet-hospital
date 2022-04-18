<template>
  <div class="app-container home">
    <el-container>
                   <el-aside width="600px"><bar /></el-aside>            
       <el-container>
                       <el-main width="500px"
          ><bing1 /> <br /><bing2
        /></el-main>
                     </el-container
      >
                 </el-container
    >
  </div>
</template>

<script>
import Bar from "../views/myEcharts/Bar.vue";
import Bing1 from "../views/myEcharts/bing1.vue";
import Bing2 from "../views/myEcharts/bing2.vue";
export default {
  components: { Bar, Bing1, Bing2 },
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.1",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>
