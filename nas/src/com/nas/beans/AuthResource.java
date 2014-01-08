package com.nas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nas.beans.base.BaseBean;

/**
 * 
 * 资源记录
 * 
 * @author autogen
 * 
 */
@Entity
@Table(name = "auth_resource")
public class AuthResource extends BaseBean {

	/**
	 * 模块名称
	 */
	@Column(name = "module_name")
	private String moduleName;
	/**
	 * 模块路径
	 */
	@Column(name = "module_path")
	private String modulePath;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModulePath() {
		return modulePath;
	}

	public void setModulePath(String modulePath) {
		this.modulePath = modulePath;
	}

	public AuthResource() {

	}
}