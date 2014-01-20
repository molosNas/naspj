package com.nas.msc.pdtm.typedivers_attributetype.ctl;

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
import com.nas.beans.TypediversAttributetype;
import com.nas.globaldef.SE;
import com.nas.msc.basemvc.controller.NASCtl;
import com.nas.msc.pdtm.typedivers_attributetype.service.ITypediversAttributetypeService;

@Controller
public class TypediversAttributetypeCtl extends NASCtl<TypediversAttributetype> {
	@Resource
	private ITypediversAttributetypeService service;

	@Override
	@RequestMapping("td_attrs")
	public ModelAndView pageView(HttpSession se) {
		return new ModelAndView("pdtm/typedivers/td_attr");
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
		service.saveBean(bean);
		return 1;
	}

	@Override
	@RequestMapping("update_td_attrs")
	public @ResponseBody
	Object update(TypediversAttributetype bean) {
		service.updateBean(bean);
		return 1;
	}

	@SuppressWarnings("serial")
	@Override
	@RequestMapping("del_td_attrs")
	public @ResponseBody
	Object delById(int id) {
		if (service.isReference(id)) {
			return new HashMap<String, Object>() {
				{
					put("errorMsg",
							new PropertiesUtil().readValue(lang(SE.LANGUAGE),
									"pdtm.td.attr.del.reference.tip"));
				}
			};
		}
		service.deleteByID(id);
		return 1;
	}

	@RequestMapping("is_repeat_td_attrs_name")
	public @ResponseBody
	Object isRepeat(String name) {
		return Checker.nullList(service.queryByParaAndVal("name", name)) ? 1
				: 0;
	}

	@RequestMapping("map_td_attrs")
	public @ResponseBody
	Object listAllNameAndId() {
		map.clear();
		map.put("datas", service.queryAll4Map());
		return service.queryAll4Map();
		// return map;
	}
}