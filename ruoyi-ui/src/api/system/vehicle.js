import request from '@/utils/request'

// 查询
export function listVehicle(query) {
  return request({
    url: '/system/vehicle/list',
    method: 'get',
    params: query
  })
}

// 查询【功能】详细
export function getVehicle(id) {
  return request({
    url: '/system/vehicle/' + id,
    method: 'get'
  })
}

// 新增【功能】
export function addVehicle(data) {
  return request({
    url: '/system/vehicle',
    method: 'post',
    data: data
  })
}

// 修改【功能】
export function updateVehicle(data) {
  return request({
    url: '/system/vehicle',
    method: 'put',
    data: data
  })
}

// 删除【功能】
export function delVehicle(id) {
  return request({
    url: '/system/vehicle/' + id,
    method: 'delete'
  })
}
