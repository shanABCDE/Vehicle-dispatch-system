import request from '@/utils/request'

// 查询
export function listForm(query) {
  return request({
    url: '/system/form/list',
    method: 'get',
    params: query
  })
}

// 获取【功能】详细
export function getForm(id) {
  return request({
    url: '/system/form/' + id,
    method: 'get'
  })
}


export function getDriver() {
  return request({
    url: '/system/driver/getDriver',
    method: 'get'
  })
}

export function getVehicle() {
  return request({
    url: '/system/vehicle/getVehicle',
    method: 'get'
  })
}



// 新增【功能】
export function addForm(data) {
  return request({
    url: '/system/form',
    method: 'post',
    data: data
  })
}

// 修改【功能】
export function updateForm(data) {
  return request({
    url: '/system/form',
    method: 'put',
    data: data
  })
}

// 归还【功能】
export function giveBack(data) {
  return request({
    url: '/system/form/giveBack',
    method: 'put',
    data: data
  })
}

// 删除【功能】
export function delForm(id) {
  return request({
    url: '/system/form/' + id,
    method: 'delete'
  })
}
