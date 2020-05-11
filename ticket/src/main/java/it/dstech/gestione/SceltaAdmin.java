package it.dstech.gestione;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import it.dstech.modelli.Admin;

@WebServlet(urlPatterns = "/Admin/SceltaAdmin")
public class SceltaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		Admin admin = (Admin) session.getAttribute("admin");
		
		if(scelta == null) {
			req.getRequestDispatcher("/Admin/ProfiloAdmin.jsp").forward(req, resp);
		} else if (scelta.equalsIgnoreCase("Aggiungi Applicazione")) {
			req.setAttribute("listaApplicazioni", gestione.stampaListaApplicazioni(admin));
			req.getRequestDispatcher("/Admin/AggiuntaApplicazione.jsp").forward(req, resp);
		} else if (scelta.equalsIgnoreCase("Gestione Applicazione")) {
			req.setAttribute("listaApplicazioni", gestione.stampaListaApplicazioni(admin));
			req.getRequestDispatcher("/Admin/GestioneApplicazione.jsp").forward(req, resp);
		} else if (scelta.equalsIgnoreCase("Gestione Ticket")) {
			req.setAttribute("listaTicketAttivo", gestione.stampaStatoTicketAttivo(admin));
			req.setAttribute("listaTicketChiuso", gestione.stampaStatoTicketChiuso(admin));
			req.getRequestDispatcher("/Admin/CambiaStatoTicket.jsp").forward(req, resp);
		}	else if (scelta.equalsIgnoreCase("Log out")) {
			session.invalidate();
			resp.sendRedirect(req.getContextPath() + "/");
		}
	}
}
