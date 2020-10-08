package com.danei.library.service;

import com.danei.library.pojo.Role;

public interface IRoleService {
	/**
	 * 保存角色
	 *
	 * @param role 角色
	 * @return 是否保存成功
	 */
	boolean save(Role role);

	/**
	 * 根据角色名查询角色
	 *
	 * @param roleName 角色名
	 * @return 角色
	 */
	Role findByRoleName(String roleName);

	/**
	 * 根据角色代码查询角色熟练
	 *
	 * @param code 角色代码
	 * @return 角色数量
	 */
	int countByCode(String code);
}
