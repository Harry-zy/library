package com.danei.library.service.impl;

import com.danei.library.dao.IPermissionDao;
import com.danei.library.pojo.Permission;
import com.danei.library.service.IPermissionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * 权限业务实现类
 *
 * @author Harry
 * @Date 2020/10/8 10:57
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

	@Resource
	IPermissionDao permissionDao;

	@Override
	public boolean save(Permission permission) {
		try {
			this.permissionDao.save(permission);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int countByCode(String permissionName) {
		return this.permissionDao.countByCode(permissionName);
	}

	@Override
	public List<Permission> findAll() {
		return this.permissionDao.findAll();
	}

	@Override
	public List<Permission> findAll(List<String> idList) {
		return this.permissionDao.findAllById(idList);
	}

	/**
	 * 构建分页参数
	 *
	 * @param pageNumber 当前页数
	 * @param pageSize   每页条数
	 * @return 分页参数
	 */
	private PageRequest buildPageRequest(int pageNumber, int pageSize) {
		return PageRequest.of(pageNumber - 1, pageSize);
	}
}
