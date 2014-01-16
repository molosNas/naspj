package com.nas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nas.beans.base.BaseBean;

/**
 * 其他表：附加种类
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "typedivers_annextype")
public class TypediversAnnextype extends BaseBean {

	/**
	 * 附属种类名称 基本，特例
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 种类描述
	 */
	@Column(name = "description")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypediversAnnextype() {

	}
}