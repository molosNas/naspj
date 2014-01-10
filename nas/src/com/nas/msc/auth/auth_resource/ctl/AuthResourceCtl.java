package com.nas.msc.auth.auth_resource.ctl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nas.beans.AuthResource;
import com.nas.msc.auth.auth_resource.service.IAuthResourceService;
import com.nas.msc.basemvc.controller.NASCtl;

@Controller
public class AuthResourceCtl extends NASCtl {

	@Resource
	private IAuthResourceService service;

	/**
	 * 跳转到资源管理界面
	 * 
	 * @return
	 */
	@RequestMapping("rmanager")
	public ModelAndView resourceManager(HttpSession se) {
		// 查询页面操作权限
		return new ModelAndView("auth/resource/resource");
	}

	@RequestMapping("list_resource")
	public @ResponseBody
	Object list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		return service.query4EUI(page, rows);
	}

	@RequestMapping("save_resource")
	public @ResponseBody
	Object save(AuthResource ab) {
		service.saveBean(ab);
		return 1;
	}

	@RequestMapping("update_resource")
	public @ResponseBody
	Object update(AuthResource ab) {
		service.updateBean(ab);
		return 1;
	}

	@RequestMapping("del_resource")
	public @ResponseBody
	Object del(int id) {
		service.deleteByID(id);
		return 1;
	}

}