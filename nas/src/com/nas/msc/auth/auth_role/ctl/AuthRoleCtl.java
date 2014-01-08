package com.nas.msc.auth.auth_role.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.molos.cds.ctl.BaseCtl;

@Controller
public class AuthRoleCtl extends BaseCtl {

	@RequestMapping("test")
	public void testTime(String str) {
		System.out.println(str);
	}

}