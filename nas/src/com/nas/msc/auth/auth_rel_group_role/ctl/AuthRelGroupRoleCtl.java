package com.nas.msc.auth.auth_rel_group_role.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.nas.beans.AuthRelGroupRole;
import com.nas.msc.basemvc.controller.NASCtl;

/**
 * 群组与角色关系控制对象
 * 
 * @author YangH
 * 
 */
@Controller
public class AuthRelGroupRoleCtl extends NASCtl<AuthRelGroupRole> {

	@Override
	public ModelAndView pageView(HttpSession se) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list(int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object save(AuthRelGroupRole bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update(AuthRelGroupRole bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object delById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}