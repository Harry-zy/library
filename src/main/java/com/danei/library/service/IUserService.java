package com.danei.library.service;

import com.danei.library.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Harry
 * @since 2020-08-31
 */
public interface IUserService extends IService<User> {
    void insertUser(User user);
}
