package com.danei.library.dao;

import com.danei.library.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *	用户Dao接口
 */
public interface IUserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
	int countByUsername(String username);
	int countByNickname(String nickname);
}
