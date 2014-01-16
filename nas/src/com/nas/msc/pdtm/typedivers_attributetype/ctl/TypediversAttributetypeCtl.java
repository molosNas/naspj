package com.nas.msc.pdtm.typedivers_attributetype.ctl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.molos.tools.common.Checker;
import com.nas.beans.TypediversAttributetype;
import com.nas.msc.basemvc.controller.NASCtl;
import com.nas.msc.pdtm.typedivers_attributetype.service.ITypediversAttributetypeService;

@Controller
public class TypediversAttributetypeCtl extends NASCtl<TypediversAttributetype> {
	@Resource
	private ITypediversAttributetypeService service;

	@Override
	@RequestMapping("td_attrs")
	public ModelAndView pageView(HttpSession se) {
		return new ModelAndView("pdtm/td_attr");
	}

	@Override
	@RequestMapping("list_td_attrs")
	public @ResponseBody
	Object list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		return service.query4EUI(page, rows);
	}

	@Override
	@RequestMapping("save_td_attrs")
	public @ResponseBody
	Object save(TypediversAttributetype bean) {
		return service.saveBean(bean);
	}

	@Override
	@RequestMapping("update_td_attrs")
	public @ResponseBody
	Object update(TypediversAttributetype bean) {
		service.updateBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("del_td_attrs")
	public @ResponseBody
	Object delById(int id) {
		service.deleteByID(id);
		return 1;
	}

	@RequestMapping("is_repeat_td_attrs_name")
	public @ResponseBody
	Object isRepeat(String name) {
		return Checker.notNullList(service.queryByParaAndVal("name", name)) ? 1
				: 0;
	}
}