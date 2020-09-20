package com.danei.library.service.impl;

import com.danei.library.pojo.User;
import com.danei.library.mapper.UserMapper;
import com.danei.library.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author Harry
 * @since 2020-08-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
