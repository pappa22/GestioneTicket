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
import it.dstech.modelli.Utente;

@WebFilter(filterName = "filtroUtente", urlPatterns = "/Utente/*")
public class FiltroUtente implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Sono nel filtro utente");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession sessione = ((HttpServletRequest) request).getSession();
		Utente utente = (Utente) sessione.getAttribute("utente");
		if(utente != null) {
			System.out.println("sessione esistente");
			chain.doFilter(request, response);
		}else {
			System.out.println("sessione inesistente");
			resp.sendRedirect(req.getContextPath() + "/");
		}
	}

	@Override
	public void destroy() {
	}

}
