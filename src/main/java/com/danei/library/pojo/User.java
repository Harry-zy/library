package com.danei.library.pojo;

import com.danei.library.base.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 用户实体类
 *
 * @author Harry
 * @Date 2020/10/1 20:09
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BasePojo {

	private static final long serialVersionUID = 6093032100729553874L;
	/**
	 * 用户名
	 */
	@Column(length = 32)
	private String username;

	/**
	 * 密码
	 */
	@Column(length = 32)
	private String password;

	/**
	 * 密码
	 */
	@Column(length = 32)
	private String nickname;
}
