package com.nas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nas.beans.base.BaseBean;

/**
 * 
 * 分组信息
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "auth_user_group")
public class AuthUserGroup extends BaseBean {

	/**
	 * 
	 */
	@Column(name = "group_name")
	private String groupName;
	/**
	 * 
	 */
	@Column(name = "comment")
	private String comment;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public AuthUserGroup() {

	}
}