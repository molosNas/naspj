package com.nas.msc.pdtm.typedivers_annextype.ctl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nas.beans.TypediversAnnextype;
import com.nas.msc.basemvc.controller.NASCtl;
import com.nas.msc.pdtm.typedivers_annextype.service.ITypediversAnnextypeService;

@Controller
public class TypediversAnnextypeCtl extends NASCtl<TypediversAnnextype> {
	@Resource
	private ITypediversAnnextypeService service;

	@Override
	@RequestMapping("td_annex")
	public ModelAndView pageView(HttpSession se) {
		return new ModelAndView("pdtm/typedivers/td_annex");
	}

	@Override
	@RequestMapping("list_td_annex")
	@ResponseBody
	public Object list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		return service.query4EUI(page, rows);
	}

	@Override
	@RequestMapping("save_td_annex")
	@ResponseBody
	public Object save(TypediversAnnextype bean) {
		service.saveBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("update_td_annex")
	@ResponseBody
	public Object update(TypediversAnnextype bean) {
		service.updateBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("del_td_annex")
	@ResponseBody
	public Object delById(int id) {
		service.deleteByID(id);
		return 1;
	}

}