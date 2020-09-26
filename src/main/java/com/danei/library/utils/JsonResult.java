package com.danei.library.utils;

import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Map;

@Data
public class JsonResult<T> {

	private boolean success;
	private List<T> data;
	private String msg;
	private long total;
	private T t;
	private Map<Object, Object> map;

	public JsonResult<T> createSuccessJsonResult(List<T> list) {
		this.success = true;
		this.data = list;
		return this;
	}

	public JsonResult<T> createSuccessJsonResult(T t) {
		this.success = true;
		this.t = t;
		return this;
	}

	public JsonResult<T> createSuccessJsonResult(Map<Object, Object> map) {
		this.success = true;
		this.map = map;
		return this;
	}


	public JsonResult<T> createSuccessJsonResult(long recordsTotal, List<T> list) {
		this.success = true;
		this.data = list;
		this.total = recordsTotal;
		return this;
	}

	public JsonResult<T> createSuccessJsonResult() {
		this.success = true;
		return this;
	}

	public JsonResult<T> createSuccessJsonResult(String msg) {
		this.success = true;
		this.msg = msg;
		return this;
	}


	public JsonResult<T> createErrorJsonResult(String msg) {
		this.success = false;
		this.msg = msg;
		return this;
	}

	public JsonResult<T> createErrorJsonResult() {
		this.success = false;
		return this;
	}

	public JsonResult<T> createErrorJsonResult(BindingResult bindingResult) {
		this.success = false;
		if (bindingResult.hasErrors()) {
			this.msg = bindingResult.getAllErrors()
				.stream()
				.map(ObjectError::getDefaultMessage)
				.reduce((m1, m2) -> m1 + "；" + m2)
				.orElse("参数输入有误！");
		}
		return this;
	}
}
