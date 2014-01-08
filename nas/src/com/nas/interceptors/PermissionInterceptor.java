package com.nas.interceptors;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nas.beans.AuthUserBase;

/**
 * 路径拦截，该处为登陆拦截
 * 
 * @author Administrator
 * 
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

	private List<String> uncheckUrls;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestUrl = request.getRequestURI();
		System.out.println(requestUrl);
		if (uncheckUrls.contains(requestUrl) || requestUrl.contains(".js")
				|| requestUrl.contains(".css") || requestUrl.contains(".jpg")) {
			return true;
		} else if (requestUrl.contains("login.jsp")) {
			response.sendRedirect("login.jsp");
			return false;
		} else {
			Object obj = request.getSession().getAttribute("AUTH_USER");
			if (obj != null && obj instanceof AuthUserBase) {
				return true;
			} else {
				PrintWriter out = response.getWriter();
				StringBuilder builder = new StringBuilder();
				builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
				builder.append("alert(\"页面过期，请重新登录\");");
				builder.append("window.top.location.href=\"");
				builder.append("login.jsp\";</script>");
				out.print(builder.toString());
				out.close();
				return false;
			}
		}
	}

	public List<String> getUncheckUrls() {
		return uncheckUrls;
	}

	public void setUncheckUrls(List<String> uncheckUrls) {
		this.uncheckUrls = uncheckUrls;
	}

}
