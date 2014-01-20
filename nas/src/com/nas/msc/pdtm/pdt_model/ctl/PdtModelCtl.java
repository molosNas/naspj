package com.nas.msc.pdtm.pdt_model.ctl;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.molos.tools.common.Checker;
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
		Date d = new Date();
		bean.setDateCreation(d);
		bean.setDateDelete(d);
		bean.setDateModification(d);
		service.saveBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("update_model")
	@ResponseBody
	public Object update(PdtModel bean) {
		PdtModel temp = service.queryById(bean.getId());
		temp.setModeltype(bean.getModeltype());
		temp.setDescription(bean.getDescription());
		temp.setDateModification(new Date());
		service.updateBean(temp);
		return 1;
	}

	@Override
	@RequestMapping("del_model")
	@ResponseBody
	public Object delById(int id) {
		service.deleteByID(id);
		return 1;
	}

	@RequestMapping("is_repeat_model_name")
	@ResponseBody
	public Object isRepeatName(String name) {
		return Checker.nullList(service.queryByParaAndVal("name", name)) ? 1
				: 0;
	}

	@RequestMapping("is_repeat_model_encid")
	@ResponseBody
	public Object isRepeatEncNum(String name) {
		return Checker.nullList(service.queryByParaAndVal("codeId", name)) ? 1
				: 0;
	}
}