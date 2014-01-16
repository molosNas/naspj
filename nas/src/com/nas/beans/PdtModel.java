package com.nas.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nas.beans.base.BaseBean;

/**
 * 基本表：型号
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "pdt_model")
public class PdtModel extends BaseBean {

	/**
	 * 型号编码，副健，编码唯一，经常用到，长度固定
	 */
	@Column(name = "model_id")
	private String modelId;
	/**
	 * 模型名称 ,命名规范
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 模型描述
	 */
	@Column(name = "description")
	private String description;
	/**
	 * 创建日期 自动添加
	 */
	@Column(name = "date_creation")
	private Timestamp dateCreation;
	/**
	 * 修改日期 自动添加
	 */
	@Column(name = "date_modification")
	private Timestamp dateModification;
	/**
	 * 删除日期 自动添加
	 */
	@Column(name = "date_delete")
	private Timestamp dateDelete;
	/**
	 * 
	 */
	@Column(name = "modeltype_ref")
	private Integer modeltypeRef;

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
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

	public Timestamp getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Timestamp getDateModification() {
		return dateModification;
	}

	public void setDateModification(Timestamp dateModification) {
		this.dateModification = dateModification;
	}

	public Timestamp getDateDelete() {
		return dateDelete;
	}

	public void setDateDelete(Timestamp dateDelete) {
		this.dateDelete = dateDelete;
	}

	public Integer getModeltypeRef() {
		return modeltypeRef;
	}

	public void setModeltypeRef(Integer modeltypeRef) {
		this.modeltypeRef = modeltypeRef;
	}

	public PdtModel() {

	}
}