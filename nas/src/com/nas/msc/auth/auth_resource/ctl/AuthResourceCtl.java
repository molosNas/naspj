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
public class AuthResourceCtl extends NASCtl<AuthResource> {

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

	@RequestMapping("del_resource")
	public @ResponseBody
	Object del(int id) {
		service.deleteByID(id);
		return 1;
	}

	@Override
	@RequestMapping("save_resource")
	public Object save(AuthResource bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping("update_resource")
	public Object update(AuthResource bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object delById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView pageView(HttpSession se) {
		// TODO Auto-generated method stub
		return null;
	}

}