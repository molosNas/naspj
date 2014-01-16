package com.nas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nas.beans.base.BaseBean;

/**
 * 基本表：方案
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "pdt_proposition")
public class PdtProposition extends BaseBean {

	/**
	 * 方案编码
	 */
	@Column(name = "proposition_id")
	private String propositionId;
	/**
	 * 方案名称
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 方案描述
	 */
	@Column(name = "description")
	private String description;
	/**
	 * 方案所属属性大类
	 */
	@Column(name = "attributetype_ref")
	private Integer attributetypeRef;
	/**
	 * 方案种类（输入，选择）
	 */
	@Column(name = "propositiontype_ref")
	private Integer propositiontypeRef;

	public String getPropositionId() {
		return propositionId;
	}

	public void setPropositionId(String propositionId) {
		this.propositionId = propositionId;
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

	public Integer getAttributetypeRef() {
		return attributetypeRef;
	}

	public void setAttributetypeRef(Integer attributetypeRef) {
		this.attributetypeRef = attributetypeRef;
	}

	public Integer getPropositiontypeRef() {
		return propositiontypeRef;
	}

	public void setPropositiontypeRef(Integer propositiontypeRef) {
		this.propositiontypeRef = propositiontypeRef;
	}

	public PdtProposition() {

	}
}