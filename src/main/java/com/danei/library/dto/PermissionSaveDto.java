package com.danei.library.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 权限保存Dto
 *
 * @author Harry
 * @Date 2020/10/8 11:03
 */
@Data
public class PermissionSaveDto {

	/**
	 * 权限名称
	 */
	@NotBlank(message = "权限名称不能为空!")
	private String permissionName;

	/**
	 * 权限代码
	 */
	@NotBlank(message = "权限代码不能为空!")
	private String code;

	/**
	 * 描述
	 */
	private String describe;
}
