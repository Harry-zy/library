package com.danei.library.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 浏览器启动类
 *
 * @author Harry
 * @Date 2020/9/20 13:09
 */
@Component
public class MyCommandRunner implements CommandLineRunner {
	@Override
	public void run(String... args) {
		try {
			Runtime.getRuntime().exec("cmd   /c   start   http://localhost/");//可以指定自己的路径
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
