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
 * 基本表：值
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "pdt_element")
public class PdtElement extends BaseBean {

	/**
	 * 元素编码
	 */
	@Column(name = "element_id")
	private String elementId;
	/**
	 * 值名称
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 属性描述
	 */
	@Column(name = "description")
	private String description;
	/**
	 * 示例路径
	 */
	@Column(name = "samplepath")
	private String samplepath;

	@OneToOne(targetEntity = TypediversAttributetype.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "attributetype_ref", updatable = true)
	private TypediversAttributetype attributetype;

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
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

	public String getSamplepath() {
		return samplepath;
	}

	public void setSamplepath(String samplepath) {
		this.samplepath = samplepath;
	}

	public TypediversAttributetype getAttributetype() {
		return attributetype;
	}

	public void setAttributetype(TypediversAttributetype attributetype) {
		this.attributetype = attributetype;
	}

	public PdtElement() {

	}
}