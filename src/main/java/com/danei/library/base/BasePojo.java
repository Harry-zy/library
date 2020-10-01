package com.danei.library.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author Harry
 * @Date 2020/10/1 19:02
 */
@Data
public class BasePojo {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;

	private String creator;

	private Date createTime;

	private String updater;

	private Date updateTime;
}
