package com.danei.library.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录Dto
 *
 * @author Harry
 * @Date 2020/9/26 12:12
 */
@Data
public class LoginDto {

	/**
	 * 用户名
	 */
	@NotBlank(message = "用户名不能为空!")
	private String username;

	/**
	 * 密码
	 */
	@NotBlank(message = "密码不能为空!")
	private String password;
}
