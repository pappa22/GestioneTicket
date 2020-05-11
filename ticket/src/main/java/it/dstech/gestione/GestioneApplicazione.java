package it.dstech.gestione;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.dstech.modelli.Admin;
import it.dstech.modelli.Applicazione;
import it.dstech.utility.EmailUtility;


@WebServlet(urlPatterns = "/Admin/GestioneApplicazione")
public class GestioneApplicazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "Pagina non accessibile");
		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller gestione = new Controller();
		String azione = req.getParameter("azione");
		long id = -1;
		if (req.getParameter("id") != null && !req.getParameter("id").equals("")) {
			id = Long.parseLong(req.getParameter("id"));
		}		
		HttpSession session = (HttpSession) req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		Applicazione applicazione = gestione.getApplicazione(id); 
		if(azione == null) {
			req.getRequestDispatcher("/Admin/GestioneApplicazione.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Modifica")) {
			req.setAttribute("listaApplicazioni", gestione.stampaListaApplicazioni(admin));
			req.setAttribute("applicazione", applicazione);
			req.getRequestDispatcher("/Admin/ModificaApplicazione.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Rimuovi")) {
			gestione.rimuoviApplicazione(id, admin);
			req.setAttribute("messApp", "Applicazione rimossa");
			req.setAttribute("listaApplicazioni", gestione.stampaListaApplicazioni(admin));
			req.getRequestDispatcher("/Admin/GestioneApplicazione.jsp").forward(req, resp);
		} else if(azione.equalsIgnoreCase("Chiudi Ticket")) {
			long nome = Long.parseLong(req.getParameter("nome"));
			String email = req.getParameter("email");
			long idTicket = Long.parseLong(req.getParameter("id"));
			gestione.chiudiTicket(idTicket);
			String oggetto = "Chiusura ticket";
			String messaggio = "Grazie per la sua recensione, abbiamo risolto il problema :)";
			try {
				EmailUtility.sendEmail(email, oggetto, messaggio);
			} catch (MessagingException | IOException e) {
				e.printStackTrace();
			}
			req.setAttribute("listaTicketAttivo", gestione.stampaStatoTicketAttivo(admin, nome));
			req.setAttribute("listaTicketChiuso", gestione.stampaStatoTicketChiuso(admin, nome));
			req.setAttribute("listaApplicazioni", gestione.stampaListaApplicazioni(admin));
			req.setAttribute("nome", nome);
			req.getRequestDispatcher("/Admin/CambiaStatoTicket.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Cerca")) {
			long nome = Long.parseLong(req.getParameter("nome"));
			req.setAttribute("listaTicketAttivo", gestione.stampaStatoTicketAttivo(admin, nome));
			req.setAttribute("listaTicketChiuso", gestione.stampaStatoTicketChiuso(admin, nome));
			req.setAttribute("listaApplicazioni", gestione.stampaListaApplicazioni(admin));
			req.setAttribute("nome", nome);
			req.getRequestDispatcher("/Admin/CambiaStatoTicket.jsp").forward(req, resp);
		}
	}
}