package com.nas.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.molos.util.TimeUtil;
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
	@Column(name = "code_id")
	private String codeId;
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
	private Date dateCreation;
	/**
	 * 修改日期 自动添加
	 */
	@Column(name = "date_modification")
	private Date dateModification;
	/**
	 * 删除日期 自动添加
	 */
	@Column(name = "date_delete")
	private Date dateDelete;

	@OneToOne(targetEntity = TypediversModeltype.class)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "modeltype_ref", updatable = true)
	private TypediversModeltype modeltype;
	@Transient
	private String ctime;
	@Transient
	private String utime;
	@Transient
	private String dtime;

	public String getCtime() {
		return TimeUtil.date2String(dateCreation, null);
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getUtime() {
		return TimeUtil.date2String(dateModification, null);
	}

	public void setUtime(String utime) {
		this.utime = utime;
	}

	public String getDtime() {
		return TimeUtil.date2String(dateDelete, null);
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}

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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public Date getDateDelete() {
		return dateDelete;
	}

	public void setDateDelete(Date dateDelete) {
		this.dateDelete = dateDelete;
	}

	public TypediversModeltype getModeltype() {
		return modeltype;
	}

	public void setModeltype(TypediversModeltype modeltype) {
		this.modeltype = modeltype;
	}

	public PdtModel() {

	}
}