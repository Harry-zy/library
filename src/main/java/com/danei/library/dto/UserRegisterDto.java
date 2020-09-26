package com.danei.library.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;

/**
 * 用户注册Dto
 *
 * @author Harry
 * @Date 2020/9/26 12:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserRegisterDto {

	/**
	 * 用户名
	 */
	@NotBlank(message = "用户名不能为空")
	private String username;

	/**
	 * 密码
	 */
	@NotBlank(message = "密码不能为空")
	private String password;

	/**
	 * 昵称
	 */
	@NotBlank(message = "昵称不能为空")
	private String nickname;
}
