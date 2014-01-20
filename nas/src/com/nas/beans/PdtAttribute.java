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
 * 基本表：属性
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "pdt_attribute")
public class PdtAttribute extends BaseBean {

	/**
	 * 属性编码
	 */
	@Column(name = "code_id")
	private String codeId;
	/**
	 * 属性名称
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 属性描述
	 */
	@Column(name = "description")
	private String description;

	@OneToOne(targetEntity = TypediversAttributetype.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "attributetype_ref", updatable = true)
	private TypediversAttributetype attributetype;

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

	// public String getTypeName() {
	// return attributetype.getName();
	// }

	// public void setTypeName(String typeName) {
	// this.typeName = typeName;
	// }
	//
	// public int getTypeId() {
	// return attributetype.getId();
	// }
	//
	// public void setTypeId(int typeId) {
	// this.typeId = typeId;
	// }

	public PdtAttribute() {

	}
}