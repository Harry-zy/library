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
}
