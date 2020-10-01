package com.danei.library.controller;

import freemarker.template.utility.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Harry
 * @Date 2020/9/19 11:01
 */
@Controller
@RequestMapping("/")
public class IndexController {

	/**
	 * 跳转首页
	 *
	 * @return	首页
	 */
	@GetMapping(value = "/", produces = "text/html;charset=UTF-8")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	/**
	 * 跳转成功页面
	 *
	 * @param function	功能名称
	 * @return	成功页面
	 */
	@GetMapping(value = "/success/{function}", produces = "text/html;charset=UTF-8")
	public ModelAndView register(@PathVariable String function) {
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("function", function);
		return modelAndView;
	}
}
