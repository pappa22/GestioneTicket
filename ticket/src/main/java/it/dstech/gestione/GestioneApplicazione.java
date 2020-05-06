package it.dstech.gestione;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.dstech.modelli.Admin;
import it.dstech.modelli.Applicazione;


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
		String app = req.getParameter("applicazione");
		HttpSession session = (HttpSession) req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		Applicazione applicazione = gestione.getApplicazione(app);
		 
		if(azione == null) {
			req.getRequestDispatcher("/Admin/GestioneApplicazione.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Modifica")) {
			req.setAttribute("listaApplicazioni", gestione.stampaListaApplicazioni(admin));
			req.setAttribute("applicazione", applicazione);
			req.getRequestDispatcher("/Admin/ModificaApplicazione.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Rimuovi")) {
			gestione.rimuoviApplicazione(app, admin);
			req.setAttribute("messApp", "Applicazione rimossa");
			req.setAttribute("listaApplicazioni", gestione.stampaListaApplicazioni(admin));
			req.getRequestDispatcher("/Admin/GestioneApplicazione.jsp").forward(req, resp);
		} 
	}
}