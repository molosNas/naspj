package com.nas.msc.auth.auth_user_base.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.molos.cds.ctl.BaseCtl;
import com.nas.beans.AuthUserBase;
import com.nas.globaldef.SE;
import com.nas.msc.auth.auth_user_base.service.IAuthUserBaseService;

@Controller
public class AuthUserBaseCtl extends BaseCtl {

	@Resource
	private IAuthUserBaseService service;

	/**
	 * 跳转到用户管理界面
	 * 
	 * @return
	 */
	@RequestMapping("umanager")
	public ModelAndView userManager(HttpSession se) {

		// 查询页面操作权限

		return new ModelAndView("auth/users/users");
	}

	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	/**
	 * 登录跳转到主操作界面
	 * 
	 * @param ab
	 * @param se
	 * @param rsp
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(AuthUserBase ab, HttpSession se,
			HttpServletResponse rsp) {
		AuthUserBase aa = service.queryUserBase(ab);
		if (aa != null) {
			se.setAttribute(SE.AUTH_USER, aa);
			return new ModelAndView("main");
		} else {
			map.put("msg", "登陆失败");
			return new ModelAndView("login", map);
		}
	}

	/**
	 * 根据登录用户获取系统资源菜单详情
	 * 
	 * @param se
	 * @return
	 */
	@RequestMapping("menus")
	public @ResponseBody
	Object assemResources(HttpSession se) {
		map.clear();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("menuid", 12);
		m1.put("icon", "icon-sys");
		m1.put("menuname", "新闻管理111");
		m1.put("url", "http://www.baidu.com");
		list1.add(m1);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("menuid", "1");
		m.put("icon", "icon-sys");
		m.put("menuname", "新闻");
		m.put("menus", list1);
		list.add(m);
		map.put("menus", list);

		return map;
	}

	/**
	 * 全局404页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("404")
	public ModelAndView to404() {
		return new ModelAndView("errors/e404");
	}

	@RequestMapping("list_user")
	public @ResponseBody
	Object list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows) {
		return service.queryDatas4Map(null, null, page, rows);
	}

	@RequestMapping("save_user")
	public @ResponseBody
	Object save(AuthUserBase ab) {
		service.saveBean(ab);
		return null;
	}

	@RequestMapping("update_user")
	public @ResponseBody
	Object update(AuthUserBase ab) {
		return null;
	}

	@RequestMapping("del_user")
	public @ResponseBody
	Object del(int id) {
		return null;
	}

}