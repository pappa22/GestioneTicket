package it.dstech.gestione;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Ticket;
import it.dstech.modelli.Utente;



@WebServlet(urlPatterns = "/Utente/SceltaUtente")
public class SceltaUtente extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "Pagina non accessibile");
		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller gestione = new Controller();
		String scelta = req.getParameter("azione");
		long idApp = 0;
		
		if (req.getParameter("idApp") != null && !req.getParameter("idApp").equals("")) {
			 idApp = Long.parseLong(req.getParameter("idApp"));
		}
		
	
		HttpSession session = (HttpSession) req.getSession();
		
		if (scelta.equalsIgnoreCase("Lista Applicazioni")) {
			
			req.setAttribute("listaApplicazioni", gestione.stampaTutteLeApplicazioni());
			req.getRequestDispatcher("/Utente/ListaApplicazioni.jsp").forward(req, resp);
		} 
		
//		else if (scelta.equalsIgnoreCase("Torna Indietro")) {
//			//req.getRequestDispatcher("/Utente/opzioniUtente.jsp").forward(req, resp);
//			resp.sendRedirect(req.getContextPath() + "/Utente/opzioniUtente.jsp");
//		} 
		
		else if (scelta.equalsIgnoreCase("Gestione Ticket")) {
			System.out.println("//////////////"+idApp);
			Utente utente =	(Utente) session.getAttribute("utente");
			req.setAttribute("ticket", gestione.getListaTicket(utente, idApp));
			req.setAttribute("idApp", idApp);
			req.getRequestDispatcher("/Utente/GestioneTicket.jsp").forward(req, resp);
		} 
		
		else if (scelta.equalsIgnoreCase("Crea Ticket")) {
		System.out.println("//////////////"+idApp);
			req.setAttribute("idApp", idApp);
			req.getRequestDispatcher("/Utente/CreaTicket.jsp").forward(req, resp);
		} 
		
		else if (scelta.equalsIgnoreCase("Log out")) {
			session.invalidate();
			resp.sendRedirect(req.getContextPath() + "/");
		}
	}


}
