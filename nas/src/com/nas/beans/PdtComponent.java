package com.nas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nas.beans.base.BaseBean;

/**
 * 基本表：组件
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "pdt_component")
public class PdtComponent extends BaseBean {

	/**
	 * 组件编码，候补键，命名规范
	 */
	@Column(name = "code_id")
	private String codeId;
	/**
	 * 组件名称
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 组件描述
	 */
	@Column(name = "description")
	private String description;

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

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

	public PdtComponent() {

	}
}