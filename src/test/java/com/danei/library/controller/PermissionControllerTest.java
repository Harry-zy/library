package com.danei.library.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
public class PermissionControllerTest {
	@Resource
	private PermissionController permissionController;
	private MockMvc mockMvc;

	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(permissionController).build();
	}

	@Test
	public void saveUser() throws Exception {
		MockHttpServletRequestBuilder params1 = MockMvcRequestBuilders.patch("/per");
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