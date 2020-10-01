package com.danei.library.base;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基类
 *
 * @author Harry
 * @Date 2020/10/1 19:02
 */
@MappedSuperclass
@Data
public class BasePojo implements Serializable {

	private static final long serialVersionUID = -8064405177037386547L;
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 32)
	private String id;

	/**
	 * 创建者
	 */
	@Column(length = 32)
	private String creator;

	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	/**
	 * 更新者
	 */
	@Column(length = 32)
	private String updater;

	/**
	 * 更新时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	@PrePersist
	private void entityBeforeInsert() {
		setCreateTime(new Date());
	}

	@PreUpdate
	private void entityBeforeModify() {
		setUpdateTime(new Date());
	}
}
