package com.danei.library.dao;

import com.danei.library.pojo.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *	权限Dao接口
 */
public interface IPermissionDao extends JpaRepository<Permission, String>, JpaSpecificationExecutor<Permission> {
	/**
	 * 根据权限代码查询权限数量
	 *
	 * @param code 权限代码
	 * @return 权限数量
	 */
	int countByCode(String code);
}
