package com.nas.msc.pdtm.pdt_attribute.ctl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.molos.tools.common.Checker;
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
	@RequestMapping("attrs")
	public ModelAndView pageView(HttpSession se) {
		return new ModelAndView("pdtm/pdt/attrs");
	}

	@Override
	@RequestMapping("list_attrs")
	@ResponseBody
	public Object list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		return service.query4EUI(page, rows);
	}

	@Override
	@RequestMapping("save_attrs")
	@ResponseBody
	public Object save(PdtAttribute bean) {
		service.saveBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("update_attrs")
	@ResponseBody
	public Object update(PdtAttribute bean) {
		service.updateBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("del_attrs")
	@ResponseBody
	public Object delById(int id) {
		service.deleteByID(id);
		return 1;
	}

	@RequestMapping("is_repeat_attrs_name")
	@ResponseBody
	public Object isRepeatName(String name) {
		return Checker.nullList(service.queryByParaAndVal("name", name)) ? 1
				: 0;
	}

	@RequestMapping("is_repeat_attrs_encid")
	@ResponseBody
	public Object isRepeatEncNum(String name) {
		return Checker.nullList(service.queryByParaAndVal("codeId", name)) ? 1
				: 0;
	}
}