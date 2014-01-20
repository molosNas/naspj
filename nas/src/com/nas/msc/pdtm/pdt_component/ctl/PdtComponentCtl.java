package com.nas.msc.pdtm.pdt_component.ctl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nas.beans.PdtComponent;
import com.nas.msc.basemvc.controller.NASCtl;
import com.nas.msc.pdtm.pdt_component.service.IPdtComponentService;

@Controller
public class PdtComponentCtl extends NASCtl<PdtComponent> {
	@Resource
	private IPdtComponentService service;

	@Override
	@RequestMapping("component")
	public ModelAndView pageView(HttpSession se) {
		return new ModelAndView("pdtm/pdt/component");
	}

	@Override
	@RequestMapping("list_component")
	@ResponseBody
	public Object list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		return service.query4EUI(page, rows);
	}

	@Override
	@RequestMapping("save_component")
	@ResponseBody
	public Object save(PdtComponent bean) {
		service.saveBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("update_component")
	@ResponseBody
	public Object update(PdtComponent bean) {
		service.updateBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("del_component")
	@ResponseBody
	public Object delById(int id) {
		service.deleteByID(id);
		return 1;
	}

}