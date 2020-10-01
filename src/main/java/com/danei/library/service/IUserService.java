package com.danei.library.service;

import com.danei.library.pojo.User;

public interface IUserService {
	boolean save(User user);

	User update(User user);

	int countByUsername(String username);

	int countByNickname(String nickname);
}
