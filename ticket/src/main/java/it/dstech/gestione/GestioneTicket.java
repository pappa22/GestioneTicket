package it.dstech.gestione;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.modelli.Ticket;



@WebServlet(urlPatterns = "/Utente/GestioneTicket")
public class GestioneTicket extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "Pagina non accessibile");
		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller gestione = new Controller();
		String scelta = req.getParameter("azione");
		long id = Long.parseLong(req.getParameter("idTicket"));
		Ticket ticket = gestione.getTicket(id);
		if(scelta.equalsIgnoreCase("Modifica Ticket")){
			req.setAttribute("ticket", ticket);
			req.getRequestDispatcher("/Utente/ModificaTicket.jsp").forward(req, resp);
			
			
		}else if(scelta.equalsIgnoreCase("Elimina Ticket")){
			gestione.rimuoviTicket(id);
			req.setAttribute("ticket", ticket);
			req.getRequestDispatcher("/Utente/GestioneTicket.jsp").forward(req, resp);
			
		}
	}
}
