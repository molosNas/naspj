package com.nas.msc.pdtm.pdt_proposition.ctl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.molos.tools.common.Checker;
import com.nas.beans.PdtProposition;
import com.nas.msc.basemvc.controller.NASCtl;
import com.nas.msc.pdtm.pdt_proposition.service.IPdtPropositionService;

@Controller
public class PdtPropositionCtl extends NASCtl<PdtProposition> {
	@Resource
	private IPdtPropositionService service;

	@Override
	@RequestMapping("proposition")
	public ModelAndView pageView(HttpSession se) {
		return new ModelAndView("pdtm/pdt/proposition");
	}

	@Override
	@RequestMapping("list_proposition")
	@ResponseBody
	public Object list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		return service.query4EUI(page, rows);
	}

	@Override
	@RequestMapping("save_proposition")
	@ResponseBody
	public Object save(PdtProposition bean) {
		service.saveBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("update_proposition")
	@ResponseBody
	public Object update(PdtProposition bean) {
		service.updateBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("del_proposition")
	@ResponseBody
	public Object delById(int id) {
		service.deleteByID(id);
		return 1;
	}

	@RequestMapping("is_repeat_proposition_name")
	@ResponseBody
	public Object isRepeatName(String name) {
		return Checker.nullList(service.queryByParaAndVal("name", name)) ? 1
				: 0;
	}

	@RequestMapping("is_repeat_proposition_encid")
	@ResponseBody
	public Object isRepeatEncNum(String name) {
		return Checker.nullList(service.queryByParaAndVal("codeId", name)) ? 1
				: 0;
	}
}