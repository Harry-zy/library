package com.danei.library.controller;

import com.danei.library.dto.UserRegisterDto;
import com.danei.library.service.IUserService;
import com.danei.library.utils.JsonResult;
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
		if (userService.save(userRegisterDto)) {
			return jr.createSuccessJsonResult("注册成功!");
		} else {
			return jr.createErrorJsonResult("注册失败,请稍后再试!");
		}
	}
}
