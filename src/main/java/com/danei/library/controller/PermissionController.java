package com.danei.library.controller;

import com.danei.library.dto.PermissionSaveDto;
import com.danei.library.pojo.Permission;
import com.danei.library.service.IPermissionService;
import com.danei.library.utils.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 权限控制器
 *
 * @author Harry
 * @Date 2020/10/8 11:00
 */
@RestController
@RequestMapping("/per")
public class PermissionController {

	@Resource
	IPermissionService permissionService;

	/**
	 * 新增权限保存
	 *
	 * @param permissionSaveDto 权限保存Dto
	 * @param bindingResult     参数校验结果
	 * @return 权限保存结果
	 */
	@PostMapping(produces = "application/json;charset=UTF-8")
	public JsonResult<PermissionSaveDto> save(@RequestBody @Valid PermissionSaveDto permissionSaveDto, BindingResult bindingResult) {
		JsonResult<PermissionSaveDto> jr = new JsonResult<>();
		if (bindingResult.hasErrors()) {
			jr.createErrorJsonResult(bindingResult);
			return jr;
		}
		int i = this.permissionService.countByCode(permissionSaveDto.getCode());
		if (i > 0) {
			jr.createErrorJsonResult("权限代码已存在!");
			return jr;
		}
		Permission permission = new Permission();
		BeanUtils.copyProperties(permissionSaveDto, permission);
		if (this.permissionService.save(permission)) {
			jr.createSuccessJsonResult("权限保存成功!");
		} else {
			jr.createErrorJsonResult("权限保存失败!");
		}
		return jr;
	}

	/**
	 * 获取权限集合
	 *
	 * @return 权限集合
	 */
	@PatchMapping(produces = "application/json;charset=UTF-8")
	JsonResult<Permission> findAll() {
		JsonResult<Permission> jr = new JsonResult<>();
		List<Permission> permissionList = this.permissionService.findAll();
		jr.createSuccessJsonResult(permissionList);
		return jr;
	}
}
