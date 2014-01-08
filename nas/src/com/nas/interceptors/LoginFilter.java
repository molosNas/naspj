package com.nas.interceptors;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.nas.beans.AuthUserBase;
import com.nas.globaldef.SE;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String str = req.getRequestURI();
		System.out.println(str);
		if (str.contains("main") || str.endsWith("/") || str.contains("login") || str.endsWith(".js")
				|| str.endsWith(".css") || str.endsWith(".jpg")) {
			chain.doFilter(request, response);
		} else {
			Object obj = req.getSession().getAttribute(SE.AUTH_USER);
			if (obj != null && obj instanceof AuthUserBase) {
				chain.doFilter(request, response);
			} else {
				PrintWriter out = response.getWriter();
				StringBuilder builder = new StringBuilder();
				builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
				builder.append("alert(\"页面过期，请重新登录\");");
				builder.append("window.top.location.href=\"");
				builder.append("login\";</script>");
				out.print(builder.toString());
				out.close();
			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
