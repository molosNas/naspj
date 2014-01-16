package com.nas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nas.beans.base.BaseBean;

/**
 * 扩展表：方案
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "ref_proposition_element")
public class RefPropositionElement extends BaseBean {

	/**
	 * 外键引用 方案
	 */
	@Column(name = "proposition_ref")
	private Integer propositionRef;
	/**
	 * 外键引用 值
	 */
	@Column(name = "element_ref")
	private Integer elementRef;

	public Integer getPropositionRef() {
		return propositionRef;
	}

	public void setPropositionRef(Integer propositionRef) {
		this.propositionRef = propositionRef;
	}

	public Integer getElementRef() {
		return elementRef;
	}

	public void setElementRef(Integer elementRef) {
		this.elementRef = elementRef;
	}

	public RefPropositionElement() {

	}
}