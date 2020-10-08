package com.danei.library.service;

import com.danei.library.pojo.User;

public interface IUserService {
	/**
	 * 保存用户
	 *
	 * @param user 用户
	 * @return 是否保存成功
	 */
	boolean save(User user);

	/**
	 * 更新用户
	 *
	 * @param user 用户
	 * @return 更新后用户
	 */
	User update(User user);

	/**
	 * 根据用户名统计用户数量
	 *
	 * @param username 用户名
	 * @return 用户数量
	 */
	int countByUsername(String username);

	/**
	 * 根据昵称统计用户数量
	 *
	 * @param nickname 昵称
	 * @return 用户数量
	 */
	int countByNickname(String nickname);

	/**
	 * 根据账号密码查询用户
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return 用户
	 */
	User findByUsernameAndPassword(String username, String password);
}
