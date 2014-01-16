package com.nas.msc.pdtm.metaprocedure.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nas.beans.Metaprocedure;
import com.nas.msc.basemvc.controller.NASCtl;

@Controller
public class MetaprocedureCtl extends NASCtl<Metaprocedure> {

	@Override
	@RequestMapping("list_metaprocedure")
	public Object list(int page, int rows) {
		return null;
	}

	@Override
	@RequestMapping("save_metaprocedure")
	public Object save(Metaprocedure bean) {
		return null;
	}

	@Override
	@RequestMapping("update_metaprocedure")
	public Object update(Metaprocedure bean) {
		return null;
	}

	@Override
	@RequestMapping("del_metaprocedure")
	public Object delById(int id) {
		return null;
	}

	@Override
	public org.springframework.web.servlet.ModelAndView pageView(HttpSession se) {
		// TODO Auto-generated method stub
		return null;
	}

}