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
}
