package com.danei.library.pojo;

import com.danei.library.base.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户实体类
 *
 * @author Harry
 * @Date 2020/10/1 20:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BasePojo {

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 密码
	 */
	private String nickname;
}
