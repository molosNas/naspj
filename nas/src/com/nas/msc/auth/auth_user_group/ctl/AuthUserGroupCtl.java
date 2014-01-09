package com.nas.msc.auth.auth_user_group.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.molos.cds.ctl.BaseCtl;

@Controller
public class AuthUserGroupCtl extends BaseCtl {
	/**
	 * 跳转到用户管理界面
	 * 
	 * @return
	 */
	@RequestMapping("gmanager")
	public ModelAndView userManager(HttpSession se) {

		// 查询页面操作权限

		return new ModelAndView("auth/group/group");
	}

}