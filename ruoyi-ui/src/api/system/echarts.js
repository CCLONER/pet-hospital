import request from "@/utils/request";

export function getbar() {
  return request({
    url: "/system/echarts/bar",
    method: "get",
  });
}
