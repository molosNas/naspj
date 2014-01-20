package com.nas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	@Column(name = "code_id")
	private String codeId;
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
	@OneToOne(targetEntity = TypediversAttributetype.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "attributetype_ref", updatable = true)
	private TypediversAttributetype attributetype;
	/**
	 * 方案种类（输入，选择）
	 */
	@OneToOne(targetEntity = TypediversPropositiontype.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "propositiontype_ref", updatable = true)
	private TypediversPropositiontype propositiontype;

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

	public TypediversAttributetype getAttributetype() {
		return attributetype;
	}

	public void setAttributetype(TypediversAttributetype attributetype) {
		this.attributetype = attributetype;
	}

	public TypediversPropositiontype getPropositiontype() {
		return propositiontype;
	}

	public void setPropositiontype(TypediversPropositiontype propositiontype) {
		this.propositiontype = propositiontype;
	}

	public PdtProposition() {

	}
}