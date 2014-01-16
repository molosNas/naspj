package com.nas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nas.beans.base.BaseBean;

/**
 * 扩展表：属性种类
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "ref_modelcomponent_attribute_proposition")
public class RefModelcomponentAttributeProposition extends BaseBean {

	/**
	 * 型号组件关系引用
	 */
	@Column(name = "model_component_ref")
	private Integer modelComponentRef;
	/**
	 * 属性引用
	 */
	@Column(name = "attribute_ref")
	private Integer attributeRef;
	/**
	 * 类型，是否特例订制
	 */
	@Column(name = "annextype_ref")
	private Integer annextypeRef;
	/**
	 * 方案引用
	 */
	@Column(name = "proposition_ref")
	private Integer propositionRef;
	/**
	 * 对应的元工序
	 */
	@Column(name = "metaprocedure_ref")
	private Integer metaprocedureRef;

	public Integer getModelComponentRef() {
		return modelComponentRef;
	}

	public void setModelComponentRef(Integer modelComponentRef) {
		this.modelComponentRef = modelComponentRef;
	}

	public Integer getAttributeRef() {
		return attributeRef;
	}

	public void setAttributeRef(Integer attributeRef) {
		this.attributeRef = attributeRef;
	}

	public Integer getAnnextypeRef() {
		return annextypeRef;
	}

	public void setAnnextypeRef(Integer annextypeRef) {
		this.annextypeRef = annextypeRef;
	}

	public Integer getPropositionRef() {
		return propositionRef;
	}

	public void setPropositionRef(Integer propositionRef) {
		this.propositionRef = propositionRef;
	}

	public Integer getMetaprocedureRef() {
		return metaprocedureRef;
	}

	public void setMetaprocedureRef(Integer metaprocedureRef) {
		this.metaprocedureRef = metaprocedureRef;
	}

	public RefModelcomponentAttributeProposition() {

	}
}