package com.danei.library.service.impl;

import com.danei.library.dao.IRoleDao;
import com.danei.library.dao.IUserDao;
import com.danei.library.pojo.Role;
import com.danei.library.pojo.User;
import com.danei.library.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SuppressWarnings("ConstantConditions")
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

	@Resource
	IUserService userService;

	@Resource
	IUserDao userDao;

	@Resource
	IRoleDao roleDao;

	@Test
	public void save() {
		User user = new User();
		user.setUsername("Harry");
		user.setPassword("5203344");
		user.setNickname("Harry");
		this.userService.save(user);
	}

	@Test
	public void update() {
		User user = this.userDao.findById("4028fc8774e56ac40174e56ad9ac0000").orElseGet(null);
		System.out.println(user);
		Role role = this.roleDao.findByRoleName("管理员");
		user.setRole(role);
		user = this.userService.update(user);
		System.out.println(user);
	}

	@Test
	public void countByUsername() {
		int count = this.userService.countByUsername("Harry");
		System.out.println("count = " + count);
	}

	@Test
	public void countByNickname() {
		int count = this.userService.countByNickname("Harry");
		System.out.println("count = " + count);
	}
}