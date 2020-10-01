package com.danei.library.pojo;

import com.danei.library.base.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 角色实体类
 *
 * @author Harry
 * @Date 2020/10/1 22:59
 */
@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Role extends BasePojo {

	private static final long serialVersionUID = 5372690837052008452L;

	/**
	 * 角色名称
	 */
	@Column(length = 32, nullable = false)
	private String roleName;

	/**
	 * 角色描述
	 */
	@Column(name = "`describe`")
	private String describe;
}
