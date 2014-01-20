package com.nas.msc.pdtm.typedivers_propositiontype.ctl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.molos.tools.common.Checker;
import com.nas.beans.TypediversPropositiontype;
import com.nas.msc.basemvc.controller.NASCtl;
import com.nas.msc.pdtm.typedivers_propositiontype.service.ITypediversPropositiontypeService;

@Controller
public class TypediversPropositiontypeCtl extends
		NASCtl<TypediversPropositiontype> {
	@Resource
	private ITypediversPropositiontypeService service;

	@Override
	@RequestMapping("td_proposition")
	public ModelAndView pageView(HttpSession se) {
		return new ModelAndView("pdtm/typedivers/td_proposition");
	}

	@Override
	@RequestMapping("list_td_proposition")
	@ResponseBody
	public Object list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		return service.query4EUI(page, rows);
	}

	@Override
	@RequestMapping("save_td_proposition")
	@ResponseBody
	public Object save(TypediversPropositiontype bean) {
		service.saveBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("update_td_proposition")
	@ResponseBody
	public Object update(TypediversPropositiontype bean) {
		service.updateBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("del_td_proposition")
	@ResponseBody
	public Object delById(int id) {

		service.deleteByID(id);
		return 1;
	}

	@RequestMapping("is_repeat_td_propositiontype_name")
	@ResponseBody
	public Object isRepeat(String name) {
		return Checker.nullList(service.queryByParaAndVal("name", name)) ? 1
				: 0;
	}
}