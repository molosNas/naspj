package com.nas.msc.pdtm.pdt_model.ctl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nas.beans.PdtModel;
import com.nas.msc.basemvc.controller.NASCtl;
import com.nas.msc.pdtm.pdt_model.service.IPdtModelService;

@Controller
public class PdtModelCtl extends NASCtl<PdtModel> {

	@Resource
	private IPdtModelService service;

	@Override
	@RequestMapping("model")
	public ModelAndView pageView(HttpSession se) {
		return new ModelAndView("pdtm/pdt/model");
	}

	@Override
	@RequestMapping("list_model")
	@ResponseBody
	public Object list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		return service.query4EUI(page, rows);
	}

	@Override
	@RequestMapping("save_model")
	@ResponseBody
	public Object save(PdtModel bean) {
		service.saveBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("update_model")
	@ResponseBody
	public Object update(PdtModel bean) {
		service.updateBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("del_model")
	@ResponseBody
	public Object delById(int id) {
		service.deleteByID(id);
		return 1;
	}

}