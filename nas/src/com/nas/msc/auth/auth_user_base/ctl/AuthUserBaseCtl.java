package com.nas.msc.auth.auth_user_base.ctl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.molos.cds.ctl.BaseCtl;
import com.nas.beans.AuthUserBase;
import com.nas.msc.auth.auth_user_base.service.IAuthUserBaseService;

@Controller
public class AuthUserBaseCtl extends BaseCtl {

	@Resource
	private IAuthUserBaseService service;

	@RequestMapping("t")
	public void testTime() {
		List<AuthUserBase> list = service.querySomeT();
		for (AuthUserBase authUserBase : list) {
			System.out.println(authUserBase.getAuthUserGroup().getComment());
		}
	}
}