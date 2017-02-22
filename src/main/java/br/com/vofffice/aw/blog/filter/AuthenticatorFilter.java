package br.com.vofffice.aw.blog.filter;

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
import javax.servlet.http.HttpSession;

import br.com.vofffice.aw.blog.domain.User;

/**
 * Servlet Filter implementation class AuthenticatorFilter
 */
@WebFilter(urlPatterns = {"/*"})
public class AuthenticatorFilter implements Filter {
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		
		User usuario = (User) session.getAttribute("usuario");
	
		String origem = httpRequest.getServletPath();
		
		System.out.println("===>>> " + origem);
		
		String contextPath = httpRequest.getContextPath();
		System.out.println("===>>> contextPath = " + contextPath);
		
		if (usuario == null && !origem.contains("login") && !origem.contains("authenticate")) {
			httpResponse.sendRedirect(contextPath + "/login.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}


}
