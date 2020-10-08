package com.danei.library.service.impl;

import com.danei.library.dao.IUserDao;
import com.danei.library.pojo.User;
import com.danei.library.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户业务实现类
 *
 * @author Harry
 * @Date 2020/10/1 22:44
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Resource
	IUserDao userDao;

	@Override
	public boolean save(User user) {
		try {
			this.userDao.save(user);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public User update(User user) {
		user = this.userDao.save(user);
		return user;
	}

	@Override
	public int countByUsername(String username) {
		return this.userDao.countByUsername(username);
	}

	@Override
	public int countByNickname(String nickname) {
		return this.userDao.countByNickname(nickname);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return this.userDao.findByUsernameAndPassword(username, password);
	}
}
