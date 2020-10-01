package com.danei.library.controller;

import com.danei.library.dto.UserRegisterDto;
import com.danei.library.pojo.Role;
import com.danei.library.pojo.User;
import com.danei.library.service.IRoleService;
import com.danei.library.service.IUserService;
import com.danei.library.utils.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 用户控制器
 *
 * @author Harry
 * @Date 2020/10/1 20:09
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	@Resource
	private IRoleService roleService;

	/**
	 * 用户注册控制器
	 *
	 * @param userRegisterDto 用户注册Dto
	 * @param bindingResult 校验结果
	 * @return 注册结果
	 */
	@PostMapping(produces = "application/json;charset=UTF-8")
	public JsonResult<UserRegisterDto> saveUser(@RequestBody @Valid UserRegisterDto userRegisterDto, BindingResult bindingResult) {
		JsonResult<UserRegisterDto> jr = new JsonResult<>();
		if (bindingResult.hasErrors()) {
			jr.createErrorJsonResult(bindingResult);
			return jr;
		}
		int count = this.userService.countByUsername(userRegisterDto.getUsername());
		if (count > 0) {
			return jr.createErrorJsonResult("用户名已存在!");
		}
		count = this.userService.countByNickname(userRegisterDto.getNickname());
		if (count > 0) {
			return jr.createErrorJsonResult("昵称已存在!");
		}
		User user = new User();
		BeanUtils.copyProperties(userRegisterDto, user);
		Role role = this.roleService.findByRoleName("游客");
		user.setRole(role);
		if (this.userService.save(user)) {
			return jr.createSuccessJsonResult("注册成功!");
		} else {
			return jr.createErrorJsonResult("注册失败,请稍后再试!");
		}
	}
}
