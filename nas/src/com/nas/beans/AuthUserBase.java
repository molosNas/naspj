package com.nas.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.nas.beans.base.BaseBean;

/**
 * 基本登陆用户
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "auth_user_base")
public class AuthUserBase extends BaseBean {

	/**
	 * 登陆账号
	 */
	@Column(name = "uname")
	private String uname;
	/**
	 * 登陆密码
	 */
	@Column(name = "pazzwd")
	private String pazzwd;
	/**
	 * 账号创建时间
	 */
	@Column(name = "create_time")
	private java.sql.Timestamp createTime;

	@ManyToOne(targetEntity = AuthUserGroup.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "group_id", updatable = false)
	private AuthUserGroup authUserGroup;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPazzwd() {
		return pazzwd;
	}

	public void setPazzwd(String pazzwd) {
		this.pazzwd = pazzwd;
	}

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	public AuthUserGroup getAuthUserGroup() {
		return authUserGroup;
	}

	public void setAuthUserGroup(AuthUserGroup authUserGroup) {
		this.authUserGroup = authUserGroup;
	}

	public AuthUserBase() {

	}

}