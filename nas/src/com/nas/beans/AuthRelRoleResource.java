package com.nas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nas.beans.base.BaseBean;

/**
 * 
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "auth_rel_role_resource")
public class AuthRelRoleResource extends BaseBean {

	/**
	 * 
	 */
	@Column(name = "resource_id")
	private Integer resourceId;
	/**
	 * 
	 */
	@Column(name = "role_id")
	private Integer roleId;
	/**
	 * 
	 */
	@Column(name = "query")
	private Integer query;
	/**
	 * 
	 */
	@Column(name = "create")
	private Integer create;
	/**
	 * 
	 */
	@Column(name = "delete")
	private Integer delete;
	/**
	 * 
	 */
	@Column(name = "update")
	private Integer update;

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getQuery() {
		return query;
	}

	public void setQuery(Integer query) {
		this.query = query;
	}
	public Integer getCreate() {
		return create;
	}

	public void setCreate(Integer create) {
		this.create = create;
	}
	public Integer getDelete() {
		return delete;
	}

	public void setDelete(Integer delete) {
		this.delete = delete;
	}
	public Integer getUpdate() {
		return update;
	}

	public void setUpdate(Integer update) {
		this.update = update;
	}
	 
	public AuthRelRoleResource() {
	
	}
}