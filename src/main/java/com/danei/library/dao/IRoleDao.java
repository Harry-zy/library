package com.danei.library.dao;

import com.danei.library.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *	用户Dao接口
 */
public interface IRoleDao extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {
	Role findByRoleName(String roleName);
}
