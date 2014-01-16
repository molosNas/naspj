package com.nas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nas.beans.base.BaseBean;

/**
 * 关系表：型号种类组件种类 多对多
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "ref_model_component")
public class RefModelComponent extends BaseBean {

	/**
	 * 型号引用
	 */
	@Column(name = "model_ref")
	private Integer modelRef;
	/**
	 * 组件引用
	 */
	@Column(name = "component_ref")
	private Integer componentRef;
	/**
	 * 种类（基本，特例）
	 */
	@Column(name = "annextype_ref")
	private Integer annextypeRef;

	public Integer getModelRef() {
		return modelRef;
	}

	public void setModelRef(Integer modelRef) {
		this.modelRef = modelRef;
	}

	public Integer getComponentRef() {
		return componentRef;
	}

	public void setComponentRef(Integer componentRef) {
		this.componentRef = componentRef;
	}

	public Integer getAnnextypeRef() {
		return annextypeRef;
	}

	public void setAnnextypeRef(Integer annextypeRef) {
		this.annextypeRef = annextypeRef;
	}

	public RefModelComponent() {

	}
}