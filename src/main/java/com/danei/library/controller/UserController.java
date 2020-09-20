package com.danei.library.controller;


import com.danei.library.pojo.User;
import com.danei.library.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
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

    @PostMapping("/saveUser")
    public boolean saveUser(){
        User user = new User();
        user.setUsername("小歘歘");
        user.setPassword("5203344");
        return userService.save(user);
    }
}
