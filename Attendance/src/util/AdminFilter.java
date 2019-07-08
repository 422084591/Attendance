package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import service.AttendanceServiceImpl;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AdminFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		AttendanceServiceImpl service = new AttendanceServiceImpl();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		// 获得用户请求的uri
		String uri = httpServletRequest.getRequestURI();
		Admin u = (Admin) httpServletRequest.getSession().getAttribute("User");//获得session中的user对象，用来后面判断是否为空
		String set = (httpServletRequest.getContextPath() + "/Login.jsp");//不过滤Login.jsp页面，不然会出现无法登录的情况
		if (set.toString().equals(uri)) {
			chain.doFilter(request, response);
		} else {
			if (u == null) {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/Login.jsp");
			} else {
				if (service.isExit(u.getUsername())) { // 如果当前登录用户存在的话，就放行
					chain.doFilter(request, response); // 放行
				} else { // 否则返回首页
					httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/Login.jsp");
				}
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
