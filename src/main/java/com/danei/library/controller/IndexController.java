package com.danei.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Harry
 * @Date 2020/9/19 11:01
 */
@Controller
@RequestMapping("/")
public class IndexController {

	/**
	 * 跳转index
	 *
	 * @return resMap
	 */
	@GetMapping(value = "/", produces = "text/html;charset=UTF-8")
	public Object index() {
		return "index";
	}
}
