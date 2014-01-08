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
 * @author autogen
 * 
 */
@Entity
@Table(name = "auth_rel_group_role")
public class AuthRelGroupRole extends BaseBean {

	/**
	 * 
	 */
	@OneToMany(targetEntity = AuthUserGroup.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "auth_user_group_id", updatable = false)
	private Set<AuthUserGroup> augList;
	/**
	 * 
	 */
	@OneToMany(targetEntity = AuthRole.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "auth_role_id", updatable = false)
	private Set<AuthRole> arList;

	public AuthRelGroupRole() {

	}

	public Set<AuthUserGroup> getAugList() {
		return augList;
	}

	public void setAugList(Set<AuthUserGroup> augList) {
		this.augList = augList;
	}

	public Set<AuthRole> getArList() {
		return arList;
	}

	public void setArList(Set<AuthRole> arList) {
		this.arList = arList;
	}

}