package it.dstech.filter;


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

import it.dstech.modelli.Admin;

@WebFilter(filterName = "filtroAdmin", urlPatterns = "/admin/*")
public class FiltroAdmin implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Sono nel filtro admin");
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession sessione = ((HttpServletRequest) request).getSession();
		Admin admin = (Admin) sessione.getAttribute("username");
		if(admin != null) {
			System.out.println("sessione esistente");
			chain.doFilter(request, response);
		}else {
			System.out.println("sessione insesistente");
			resp.sendRedirect("/battleground-tracker/homepage.jsp");
		}
	}

	@Override
	public void destroy() {
	}

}
