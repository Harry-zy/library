package com.danei.library.service.impl;

import com.danei.library.pojo.Role;
import com.danei.library.service.IRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleServiceImplTest {

	@Autowired
	IRoleService roleService;
	@Test
	public void save() {
		Role role = new Role();
		role.setRoleName("游客");
		this.roleService.save(role);
	}

	@Test
	public void findByRoleName() {
		Role role = this.roleService.findByRoleName("游客");
		System.out.println(role);
	}
}