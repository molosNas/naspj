package com.nas.msc.basemvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.molos.cds.ctl.BaseCtl;

/**
 * NAS控制对象
 * 
 * @author YangH
 * 
 */
public abstract class NASCtl<T> extends BaseCtl {

	/**
	 * 跳转页面方法
	 * 
	 * @param se
	 *            session对象，用于获取登录用户，进行页面所见操作内容的过滤
	 * @return
	 */
	public abstract ModelAndView pageView(HttpSession se);

	public abstract Object list(int page, int rows);

	public abstract Object save(T bean);

	public abstract Object update(T bean);

	public abstract Object delById(int id);

}
