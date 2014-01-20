package com.nas.msc.pdtm.pdt_element.ctl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nas.beans.PdtElement;
import com.nas.msc.basemvc.controller.NASCtl;
import com.nas.msc.pdtm.pdt_element.service.IPdtElementService;

@Controller
public class PdtElementCtl extends NASCtl<PdtElement> {
	@Resource
	private IPdtElementService service;

	@Override
	@RequestMapping("element")
	public ModelAndView pageView(HttpSession se) {
		return new ModelAndView("pdtm/pdt/element");
	}

	@Override
	@RequestMapping("list_element")
	@ResponseBody
	public Object list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		return service.query4EUI(page, rows);
	}

	@Override
	@RequestMapping("save_element")
	@ResponseBody
	public Object save(PdtElement bean) {
		service.saveBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("update_element")
	@ResponseBody
	public Object update(PdtElement bean) {
		service.updateBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("del_element")
	@ResponseBody
	public Object delById(int id) {
		service.deleteByID(id);
		return 1;
	}

}