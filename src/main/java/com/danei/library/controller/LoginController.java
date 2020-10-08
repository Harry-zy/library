package com.danei.library.controller;

import com.danei.library.dto.LoginDto;
import com.danei.library.pojo.User;
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
 * 登录控制器
 *
 * @author Harry
 * @Date 2020/10/8 18:16
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	@Resource
	IUserService userService;

	@PostMapping(produces = "application/json;charset=UTF-8")
	public JsonResult<User> login(@RequestBody @Valid LoginDto loginDto, BindingResult bindingResult) {
		JsonResult<User> jr = new JsonResult<>();
		if (bindingResult.hasErrors()) {
			jr.createErrorJsonResult(bindingResult);
			return jr;
		}
		User user = this.userService.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		if (user != null) {
			return jr.createSuccessJsonResult(user);
		} else {
			return jr.createErrorJsonResult("登录失败!");
		}
	}
}
