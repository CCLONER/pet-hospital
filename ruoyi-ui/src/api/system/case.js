import request from '@/utils/request'

// 查询case列表
export function listCase(query) {
  return request({
    url: '/system/case/list',
    method: 'get',
    params: query
  })
}

// 查询case详细
export function getCase(id) {
  return request({
    url: '/system/case/' + id,
    method: 'get'
  })
}

// 新增case
export function addCase(data) {
  return request({
    url: '/system/case',
    method: 'post',
    data: data
  })
}

// 修改case
export function updateCase(data) {
  return request({
    url: '/system/case',
    method: 'put',
    data: data
  })
}

// 删除case
export function delCase(id) {
  return request({
    url: '/system/case/' + id,
    method: 'delete'
  })
}
