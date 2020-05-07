package it.dstech.gestione;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Applicazione;
import it.dstech.modelli.Ticket;
import it.dstech.modelli.Utente;



@WebServlet(urlPatterns = "/Utente/CreaTicket")
public class CreaTicket extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "Pagina non accessibile");
		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Utente utente =(Utente) session.getAttribute("utente");
		Controller gestione = new Controller();
	long idApp = Long.parseLong(req.getParameter("idApp").replace("/", ""));
	Applicazione applicazione = gestione.getApplicazione(idApp);
	String nome =req.getParameter("nome");
	String descrizione =req.getParameter("descrizione");
	Ticket ticket = new Ticket();
	ticket.setNome(nome);
	ticket.setDescrizione(descrizione);
	ticket.setUtente(utente);
    ticket.setStato(true);
    ticket.setApplicazione(applicazione);
    gestione.creaTicket(ticket);
	System.out.println("stampa app"+ applicazione.getListaTicket());
    req.setAttribute("mess", "Ticket creato con successo");
    req.setAttribute("listaApplicazioni", gestione.stampaTutteLeApplicazioni());
    req.getRequestDispatcher("/Utente/ListaApplicazioni.jsp").forward(req, resp);
	}

}
