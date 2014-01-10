package com.nas.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.nas.beans.base.BaseBean;

/**
 * 
 * 
 * @author YangH
 * 
 */
@Entity
@Table(name = "auth_rel_role_resource")
public class AuthRelRoleResource extends BaseBean {

	/**
	 * 资源列表
	 */
	@OneToMany(targetEntity = AuthResource.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "resource_id", updatable = false)
	private Set<AuthResource> authResources;

	/**
	 * 权限列表
	 */
	@OneToMany(targetEntity = AuthRole.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "role_id", updatable = false)
	private Set<AuthRole> authRoles;
	/**
	 * 查询权限，当查询权限为0，则无该模块访问权限
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

	public Set<AuthResource> getAuthResources() {
		return authResources;
	}

	public void setAuthResources(Set<AuthResource> authResources) {
		this.authResources = authResources;
	}

	public Set<AuthRole> getAuthRoles() {
		return authRoles;
	}

	public void setAuthRoles(Set<AuthRole> authRoles) {
		this.authRoles = authRoles;
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