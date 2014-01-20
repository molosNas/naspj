package com.nas.msc.pdtm.typedivers_modeltype.ctl;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.molos.tools.common.Checker;
import com.molos.util.PropertiesUtil;
import com.nas.beans.TypediversModeltype;
import com.nas.globaldef.SE;
import com.nas.msc.basemvc.controller.NASCtl;
import com.nas.msc.pdtm.typedivers_modeltype.service.ITypediversModeltypeService;

@Controller
public class TypediversModeltypeCtl extends NASCtl<TypediversModeltype> {
	@Resource
	private ITypediversModeltypeService service;

	@Override
	@RequestMapping("td_modeltype")
	public ModelAndView pageView(HttpSession se) {
		return new ModelAndView("pdtm/typedivers/td_modeltype");
	}

	@Override
	@RequestMapping("list_td_modeltype")
	public @ResponseBody
	Object list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		return service.query4EUI(page, rows);
	}

	@Override
	@RequestMapping("save_td_modeltype")
	public @ResponseBody
	Object save(TypediversModeltype bean) {
		service.saveBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("update_td_modeltype")
	public @ResponseBody
	Object update(TypediversModeltype bean) {
		service.updateBean(bean);
		return 1;
	}

	@SuppressWarnings("serial")
	@Override
	@RequestMapping("del_td_modeltype")
	public @ResponseBody
	Object delById(int id) {
		if (service.isReference(id)) {
			return new HashMap<String, Object>() {
				{
					put("errorMsg", new PropertiesUtil().readValue(
							lang(SE.LANGUAGE),
							"pdtm.td.model.del.reference.tip"));
				}
			};
		}

		service.deleteByID(id);
		return 1;
	}

	@RequestMapping("is_repeat_td_modeltype_name")
	@ResponseBody
	public Object isRepeat(String name) {
		return Checker.nullList(service.queryByParaAndVal("name", name)) ? 1
				: 0;
	}

}