package com.danei.library.service;

import com.danei.library.dto.UserRegisterDto;

public interface IUserService {
	boolean save(UserRegisterDto userRegisterDto);

	int countByUsername(String username);

	int countByNickname(String nickname);
}
