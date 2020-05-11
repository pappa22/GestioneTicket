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



@WebServlet(urlPatterns = "/Utente/GestioneTicket")
public class GestioneTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "Pagina non accessibile");
		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Utente utente =	(Utente) session.getAttribute("utente");
		Controller gestione = new Controller();
		String scelta = req.getParameter("azione");
		long id = Long.parseLong(req.getParameter("idTicket"));
		Ticket ticket = gestione.getTicket(utente,id);
		if(scelta.equalsIgnoreCase("Modifica Ticket")){
			req.setAttribute("ticket", ticket);
			req.getRequestDispatcher("/Utente/ModificaTicket.jsp").forward(req, resp);
		}else if(scelta.equalsIgnoreCase("Elimina Ticket")){
			gestione.rimuoviTicket(id, ticket.getApplicazione().getId(),utente);
			req.setAttribute("listaApplicazioni", gestione.stampaTutteLeApplicazioni());
			req.getRequestDispatcher("/Utente/ListaApplicazioni.jsp").forward(req, resp);
		}
	}
}
