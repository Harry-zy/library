package com.danei.library.controller;

import com.danei.library.dto.PermissionSaveDto;
import com.danei.library.dto.RoleSaveDto;
import com.danei.library.pojo.Permission;
import com.danei.library.pojo.Role;
import com.danei.library.service.IPermissionService;
import com.danei.library.service.IRoleService;
import com.danei.library.utils.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 角色控制器
 *
 * @author Harry
 * @Date 2020/10/8 11:00
 */
@RestController
@RequestMapping("/role")
public class RoleController {

	@Resource
	IRoleService roleService;

	@Resource
	IPermissionService permissionService;

	/**
	 * 新增角色保存
	 *
	 * @param roleSaveDto 角色保存Dto
	 * @param bindingResult     参数校验结果
	 * @return 角色保存结果
	 */
	@PostMapping(produces = "application/json;charset=UTF-8")
	public JsonResult<PermissionSaveDto> save(@RequestBody @Valid RoleSaveDto roleSaveDto, BindingResult bindingResult) {
		JsonResult<PermissionSaveDto> jr = new JsonResult<>();
		if (bindingResult.hasErrors()) {
			jr.createErrorJsonResult(bindingResult);
			return jr;
		}
		int i = this.roleService.countByCode(roleSaveDto.getCode());
		if (i > 0) {
			jr.createErrorJsonResult("角色代码已存在!");
			return jr;
		}
		List<Permission> permissionList = this.permissionService.findAll(roleSaveDto.getPermissionIds());
		Role role = new Role();
		BeanUtils.copyProperties(roleSaveDto, role);
		role.setPermissions(permissionList);
		if (this.roleService.save(role)) {
			jr.createSuccessJsonResult("角色保存成功!");
		} else {
			jr.createErrorJsonResult("角色保存失败!");
		}
		return jr;
	}
}
