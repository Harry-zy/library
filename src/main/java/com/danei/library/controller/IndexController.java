package com.danei.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面跳转控制器啊
 *
 * @author Harry
 * @Date 2020/10/1 20:09
 */
@Controller
@RequestMapping("/")
public class IndexController {

	/**
	 * 跳转首页
	 *
	 * @return 首页
	 */
	@GetMapping(value = "/", produces = "text/html;charset=UTF-8")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	/**
	 * 跳转权限管理页面
	 *
	 * @return 首页
	 */
	@GetMapping(value = "/per", produces = "text/html;charset=UTF-8")
	public ModelAndView permission() {
		return new ModelAndView("permission");
	}

	/**
	 * 跳转角色管理页面
	 *
	 * @return 首页
	 */
	@GetMapping(value = "/role", produces = "text/html;charset=UTF-8")
	public ModelAndView role() {
		return new ModelAndView("role");
	}

	/**
	 * 跳转成功页面
	 *
	 * @param function 功能名称
	 * @return 成功页面
	 */
	@GetMapping(value = "/success/{function}", produces = "text/html;charset=UTF-8")
	public ModelAndView register(@PathVariable String function) {
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("function", function);
		return modelAndView;
	}

	/**
	 * 跳转成功页面
	 *
	 * @param function 功能名称
	 * @return 成功页面
	 */
	@GetMapping(value = "/success/{function}/{nickname}/{roleName}", produces = "text/html;charset=UTF-8")
	public ModelAndView login(@PathVariable String function, @PathVariable String nickname, @PathVariable String roleName) {
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("function", function);
		modelAndView.addObject("nickname", nickname);
		modelAndView.addObject("roleName", roleName);
		return modelAndView;
	}
}
