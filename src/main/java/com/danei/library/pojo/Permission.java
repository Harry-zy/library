package com.danei.library.pojo;

import com.danei.library.base.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 权限实体类
 *
 * @author Harry
 * @Date 2020/10/8 10:35
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Permission extends BasePojo {
	private static final long serialVersionUID = 8386351755311060498L;

	/**
	 * 权限名称
	 */
	@Column(length = 32)
	private String permissionName;

	/**
	 * 权限代码
	 */
	@Column(length = 32)
	private String code;

	/**
	 * 描述
	 */
	@Column(name = "`describe`")
	private String describe;
}
