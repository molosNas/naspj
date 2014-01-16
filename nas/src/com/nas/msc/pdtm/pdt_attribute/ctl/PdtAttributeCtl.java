package com.nas.msc.pdtm.pdt_attribute.ctl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nas.beans.PdtAttribute;
import com.nas.msc.basemvc.controller.NASCtl;
import com.nas.msc.pdtm.pdt_attribute.service.IPdtAttributeService;

/**
 * 属性控制
 * 
 * @author YangH
 * 
 */
@Controller
public class PdtAttributeCtl extends NASCtl<PdtAttribute> {

	@Resource
	private IPdtAttributeService service;

	@Override
	@RequestMapping("list_attrs")
	public Object list(int page, int rows) {
		return service.query4EUI(page, rows);
	}

	@Override
	@RequestMapping("save_attrs")
	public Object save(PdtAttribute bean) {
		return null;
	}

	@Override
	@RequestMapping("update_attrs")
	public Object update(PdtAttribute bean) {
		return null;
	}

	@Override
	@RequestMapping("del_attrs")
	public Object delById(int id) {
		return null;
	}

	@Override
	@RequestMapping("attrs")
	public ModelAndView pageView(HttpSession se) {
		return null;
	}

}