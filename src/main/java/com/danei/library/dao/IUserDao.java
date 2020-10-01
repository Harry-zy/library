package com.danei.library.dao;

import com.danei.library.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *	用户Dao接口
 */
public interface IUserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
	/**
	 * 根据用户名查询用户数量
	 *
	 * @param username 用户名
	 * @return 用户数量
	 */
	int countByUsername(String username);

	/**
	 * 根据昵称查询用户数量
	 *
	 * @param nickname 昵称
	 * @return 用户数量
	 */
	int countByNickname(String nickname);
}
