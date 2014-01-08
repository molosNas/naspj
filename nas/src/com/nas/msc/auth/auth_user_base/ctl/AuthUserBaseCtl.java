package com.nas.msc.auth.auth_user_base.ctl;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.molos.cds.ctl.BaseCtl;
import com.nas.beans.AuthUserBase;
import com.nas.globaldef.SE;
import com.nas.msc.auth.auth_user_base.service.IAuthUserBaseService;

@Controller
public class AuthUserBaseCtl extends BaseCtl {

	@Resource
	private IAuthUserBaseService service;

	@RequestMapping("login")
	public ModelAndView login() {
		return new ModelAndView("login", map);
	}

	@RequestMapping("main")
	public ModelAndView main(AuthUserBase ab, HttpSession se,
			HttpServletResponse rsp) {
		AuthUserBase aa = service.queryUserBase(ab);
		if (aa != null) {
			se.setAttribute(SE.AUTH_USER, aa);
			return new ModelAndView("main");
		} else {
			map.put("msg", "登陆失败");
			try {
				rsp.sendRedirect("login");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public @ResponseBody
	Object assemResources(HttpSession se) {
		AuthUserBase ab = (AuthUserBase) se.getAttribute(SE.AUTH_USER);
		return service.assemResources(ab);
	}

}