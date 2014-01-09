package com.nas.interceptors;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nas.beans.AuthUserBase;
import com.nas.globaldef.SE;

/**
 * 路径拦截，该处为登陆拦截
 * 
 * @author Administrator
 * 
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String ru = request.getRequestURI();
		System.out.println(ru);
		if (ru.contains("main") || ru.contains("login") || ru.contains("404")) {
			return super.preHandle(request, response, handler);
		}
		Object obj = request.getSession().getAttribute(SE.AUTH_USER);
		if (obj != null && obj instanceof AuthUserBase) {
			return super.preHandle(request, response, handler);
		}
		PrintWriter out = response.getWriter();
		StringBuilder builder = new StringBuilder();
		builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
		builder.append("alert(\"页面过期，请重新登录\");");
		builder.append("window.top.location.href=\"");
		builder.append("login\";</script>");
		out.print(builder.toString());
		out.close();
		return false;
	}
}
