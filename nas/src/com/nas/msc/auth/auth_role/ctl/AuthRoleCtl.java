package com.nas.msc.auth.auth_role.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.molos.cds.ctl.BaseCtl;

@Controller
public class AuthRoleCtl extends BaseCtl {

	/**
	 * 跳转到用户管理界面
	 * 
	 * @return
	 */
	@RequestMapping("rolemanager")
	public ModelAndView userManager(HttpSession se) {
		// 查询页面操作权限
		return new ModelAndView("auth/role/role");
	}

}