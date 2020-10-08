package com.danei.library.pojo;

import com.danei.library.base.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * 角色实体类
 *
 * @author Harry
 * @Date 2020/10/1 22:59
 */
@Entity
@Data
//@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Role extends BasePojo {

	private static final long serialVersionUID = 5372690837052008452L;

	/**
	 * 角色名称
	 */
	@Column(length = 32)
	private String roleName;

	/**
	 * 角色代码
	 */
	@Column(length = 32)
	private String code;

	/**
	 * 角色描述
	 */
	@Column(name = "`describe`")
	private String describe;

	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<Permission> permissions;
}
