package it.dstech.gestione;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import it.dstech.modelli.Admin;

@WebServlet(urlPatterns = "/SceltaAdmin")
public class SceltaAdmin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "Pagina non accessibile");
		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller gestione = new Controller();
		String scelta = req.getParameter("azione");
		HttpSession session = (HttpSession) req.getSession();
		if (scelta.equalsIgnoreCase("Aggiungi Applicazione")) {
			Admin admin = (Admin) session.getAttribute("admin");
			req.setAttribute("listaApplicazioni", gestione.getListaApplicazioni(admin));
			req.getRequestDispatcher("AggiungiApplicazione.jsp").forward(req, resp);
		} else if (scelta.equalsIgnoreCase("Gestione Applicazione")) {
			req.getRequestDispatcher("GestioneApplicazione.jsp").forward(req, resp);
		} else if (scelta.equalsIgnoreCase("Gestione Ticket")) {
			req.getRequestDispatcher("GestioneTicket.jsp").forward(req, resp);
		}
	}

}
