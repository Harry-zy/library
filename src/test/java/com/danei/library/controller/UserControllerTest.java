package com.danei.library.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.danei.library.dto.UserRegisterDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
	@Resource
	private UserController userController;
	private MockMvc mockMvc;

	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void saveUser() throws Exception {
		UserRegisterDto userRegisterDto = new UserRegisterDto();
//		userRegisterDto.setUsername("yangjuju");
		userRegisterDto.setPassword("5203344");
		userRegisterDto.setNickname("小歘歘");
		MockHttpServletRequestBuilder params1 = MockMvcRequestBuilders.post("/user")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(JSON.toJSONString(userRegisterDto));
		MvcResult mvcResult = mockMvc.perform(params1)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		System.out.println("请求状态码：" + status);
		String result = mvcResult.getResponse().getContentAsString();
		JSONObject resultObj = JSON.parseObject(result);
		System.out.println("接口返回结果：" + resultObj);
	}
}