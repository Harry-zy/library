package com.danei.library.service;

import com.danei.library.pojo.Role;

public interface IRoleService {
	boolean save(Role role);

	Role findByRoleName(String roleName);
}
