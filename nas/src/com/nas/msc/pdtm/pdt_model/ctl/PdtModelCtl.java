package com.nas.msc.pdtm.pdt_model.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.nas.beans.PdtModel;
import com.nas.msc.basemvc.controller.NASCtl;

@Controller
public class PdtModelCtl extends NASCtl<PdtModel> {

	@Override
	public ModelAndView pageView(HttpSession se) {
		return null;
	}

	@Override
	public Object list(int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object save(PdtModel bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update(PdtModel bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object delById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}