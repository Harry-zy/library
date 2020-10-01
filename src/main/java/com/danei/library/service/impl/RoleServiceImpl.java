package com.danei.library.service.impl;

import com.danei.library.dao.IRoleDao;
import com.danei.library.pojo.Role;
import com.danei.library.service.IRoleService;
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
public class RoleServiceImpl implements IRoleService {
	@Resource
	IRoleDao roleDao;

	@Override
	public boolean save(Role role) {
		try {
			this.roleDao.save(role);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
}
