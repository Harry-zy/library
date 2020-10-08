package com.danei.library.service;

import com.danei.library.pojo.Permission;

import java.util.List;

public interface IPermissionService {
	/**
	 * 保存权限
	 *
	 * @param permission 权限
	 * @return 保存结果
	 */
	boolean save(Permission permission);

	/**
	 * 根据权限名称查询权限数量
	 *
	 * @param permissionName 权限名称
	 * @return 权限数量
	 */
	int countByCode(String permissionName);

	List<Permission> findAll();

	List<Permission> findAll(List<String> idList);
}
