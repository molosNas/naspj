package com.nas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nas.beans.base.BaseBean;

/**
 * 
 * 角色记录
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "auth_role")
public class AuthRole extends BaseBean {

	/**
	 * 角色名称
	 */
	@Column(name = "role_name")
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public AuthRole() {

	}
}