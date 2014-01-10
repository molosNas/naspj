package com.nas.beans;

import java.util.Set;

import javax.persistence.CascadeType;
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
 * 权限系统-----群组与角色关系对象
 * 
 * @author YangH
 * 
 */
@Entity
@Table(name = "auth_rel_group_role")
public class AuthRelGroupRole extends BaseBean {

	/**
	 * 分组信息
	 */
	@OneToMany(targetEntity = AuthUserGroup.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "auth_user_group_id", updatable = false)
	private Set<AuthUserGroup> authUserGroups;

	/**
	 * 角色信息
	 */
	@OneToMany(targetEntity = AuthRole.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "auth_role_id", updatable = false)
	private Set<AuthRole> authRoles;

	public AuthRelGroupRole() {

	}

	public Set<AuthUserGroup> getAuthUserGroups() {
		return authUserGroups;
	}

	public void setAuthUserGroups(Set<AuthUserGroup> authUserGroups) {
		this.authUserGroups = authUserGroups;
	}

	public Set<AuthRole> getAuthRoles() {
		return authRoles;
	}

	public void setAuthRoles(Set<AuthRole> authRoles) {
		this.authRoles = authRoles;
	}

}