/*
 * @Author: 一日看尽长安花
 * @since: 2019-09-04 20:55:14
 * @LastEditTime: 2020-03-15 10:59:27
 * @LastEditors: 一日看尽长安花
 * @Description:
 */
import request from '@/utils/request';

export function login(data) {
  return request({
    url: '/user/login',
    method: 'post',
    data
  });
}

export function getInfo(token) {
  return request({
    url: '/user/info',
    method: 'get'
    // params: { token }
  });
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'post'
  });
}

export function users(params) {
  return request({
    url: '/users',
    method: 'get',
    params
  });
}

export function usersMetadata() {
  return request({
    url: '/users/metadata',
    method: 'get'
  });
}

export function saveUserData(data) {
  return request({
    url: '/users',
    method: 'post',
    data
  });
}

export function updateUserData(data) {
  return request({
    url: '/users',
    method: 'put',
    data
  });
}

export function deleteUserData(data) {
  return request({
    url: '/users',
    method: 'delete',
    data
  });
}

export function exportExcelUserData(data) {
  return request({
    url: '/users/excel/export',
    method: 'post',
    data
  });
}

export function getUserRoles(params) {
  return request({
    url: '/users/roles',
    method: 'get',
    params
  });
}
