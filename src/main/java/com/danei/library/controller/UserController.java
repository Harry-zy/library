package com.danei.library.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.danei.library.dto.UserRegisterDto;
import com.danei.library.pojo.User;
import com.danei.library.service.IUserService;
import com.danei.library.utils.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Harry
 * @since 2020-08-31
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
		QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
		userQueryWrapper.eq("username", userRegisterDto.getUsername());
		int count = this.userService.count(userQueryWrapper);
		if (count > 0) {
			return jr.createErrorJsonResult("用户名已存在!");
		}
		userQueryWrapper.or(wrapper -> wrapper.eq("nickname", userRegisterDto.getNickname()));
		count = this.userService.count(userQueryWrapper);
		if (count > 0) {
			return jr.createErrorJsonResult("昵称已存在!");
		}
		User user = new User();
		BeanUtils.copyProperties(userRegisterDto, user);
		user.setCreator(user.getId());
		user.setCreateTime(new Date());
		if (userService.save(user)) {
			return jr.createSuccessJsonResult("注册成功!");
		} else {
			return jr.createErrorJsonResult("注册失败,请稍后再试!");
		}
	}
}
