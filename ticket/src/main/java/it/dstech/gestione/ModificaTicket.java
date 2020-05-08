package it.dstech.gestione;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Utente;


@WebServlet(urlPatterns = "/Utente/ModificaTicket")
public class ModificaTicket extends HttpServlet {

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
		long id = Long.parseLong(req.getParameter("idTicket"));
		String nome =req.getParameter("nome");
		String descrizione =req.getParameter("descrizione");

		
		gestione.modificaTicket(nome,descrizione,id,utente);
		req.setAttribute("ticket", gestione.getTicket(utente,id));
		req.getRequestDispatcher("/Utente/GestioneTicket.jsp").forward(req, resp);
	}
}
