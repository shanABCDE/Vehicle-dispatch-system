import request from '@/utils/request'

// 查询
export function listDriver(query) {
  return request({
    url: '/system/driver/list',
    method: 'get',
    params: query
  })
}

// 获取详细信息
export function getDriver(id) {
  return request({
    url: '/system/driver/' + id,
    method: 'get'
  })
}

// 新增【功能】
export function addDriver(data)
{
  return request({
    url: '/system/driver',
    method: 'post',
    data: data
  })
}

// 修改【功能】
export function updateDriver(data) {
  return request({
    url: '/system/driver',
    method: 'put',
    data: data
  })
}

// 删除【功能】
export function delDriver(id) {
  return request({
    url: '/system/driver/' + id,
    method: 'delete'
  })
}
