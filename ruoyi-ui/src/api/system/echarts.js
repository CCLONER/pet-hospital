import request from "@/utils/request";

export function getbar() {
  return request({
    url: "/system/echarts/bar",
    method: "get",
  });
}

export function getbing1() {
  return request({
    url: "system/echarts/bing1",
    method: "get",
  });
}
