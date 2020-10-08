package com.danei.library.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 角色保存Dto
 *
 * @author Harry
 * @Date 2020/10/8 11:03
 */
@Data
public class RoleSaveDto {

	/**
	 * 角色名称
	 */
	@NotBlank(message = "角色名称不能为空!")
	private String roleName;

	/**
	 * 角色代码
	 */
	@NotBlank(message = "角色代码不能为空!")
	private String code;

	/**
	 * 描述
	 */
	private String describe;

	private List<String> permissionIds;
}
