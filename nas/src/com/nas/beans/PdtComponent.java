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
	@Column(name = "component_id")
	private Integer componentId;
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

	public Integer getComponentId() {
		return componentId;
	}

	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
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