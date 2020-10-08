package com.danei.library.dao;

import com.danei.library.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *	角色Dao接口
 */
public interface IRoleDao extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {

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
