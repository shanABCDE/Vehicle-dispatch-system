import request from '@/utils/request'

// 查询
export function listClientele(query) {
  return request({
    url: '/system/clientele/list',
    method: 'get',
    params: query
  })
}

// 查询【功能】详细
export function getClientele(id) {
  return request({
    url: '/system/clientele/' + id,
    method: 'get'
  })
}

// 新增【功能】
export function addClientele(data) {
  return request({
    url: '/system/clientele',
    method: 'post',
    data: data
  })
}

// 修改【功能】
export function updateClientele(data) {
  return request({
    url: '/system/clientele',
    method: 'put',
    data: data
  })
}

// 删除【功能】
export function delClientele(id) {
  return request({
    url: '/system/clientele/' + id,
    method: 'delete'
  })
}
