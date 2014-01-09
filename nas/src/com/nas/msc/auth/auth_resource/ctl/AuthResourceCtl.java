package com.nas.msc.auth.auth_resource.ctl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.molos.cds.ctl.BaseCtl;
import com.nas.msc.auth.auth_resource.service.IAuthResourceService;

@Controller
public class AuthResourceCtl extends BaseCtl {

	@Resource
	private IAuthResourceService service;

	/**
	 * 跳转到资源管理界面
	 * 
	 * @return
	 */
	@RequestMapping("rmanager")
	public ModelAndView resourceManager(HttpSession se) {

		// 查询页面操作权限

		return new ModelAndView("auth/resource/resource");
	}
}