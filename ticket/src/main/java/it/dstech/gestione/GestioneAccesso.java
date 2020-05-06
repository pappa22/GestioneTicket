package it.dstech.gestione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Admin;
import it.dstech.modelli.Utente;
import it.dstech.utility.PasswordUtility;

@WebServlet(urlPatterns = "/Accesso")
public class GestioneAccesso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller gestione = new Controller();
		HttpSession session = req.getSession();
		String scelta = req.getParameter("scelta");
		String mail = req.getParameter("mail");
		String pass = PasswordUtility.encrypt(req.getParameter("password"), "Mary has one ca1");
		if (scelta.equalsIgnoreCase("Registrazione")) {
			req.getRequestDispatcher("Registrazione.jsp").forward(req, resp);
		}
		if (scelta.equalsIgnoreCase("Login")) {
			if(gestione.checkAdmin(mail, pass)) {
				Admin admin = gestione.getOggettoAdmin(mail);
			    if(admin.isActive()) {
			    	session.setAttribute("admin", admin);
			    	req.getRequestDispatcher("/Admin/ProfiloAdmin.jsp").forward(req, resp);
			}else {			
					req.setAttribute("mess", "admin non attivato, cliccare il link nella mail ricevuta");
					gestione.close();
					req.getRequestDispatcher("Homepage.jsp").forward(req, resp);				
			} 
			}else if (gestione.checkUtente(mail, pass)) {
				Utente ut= gestione.getOggettoUtente(mail);
				if (!ut.isActive()) {
					req.setAttribute("mess", "utente non attivato, cliccare il link nella mail ricevuta");
					gestione.close();
					req.getRequestDispatcher("Homepage.jsp").forward(req, resp);
				} else {
					session.setAttribute("utente", ut);
					req.getRequestDispatcher("/cliente/opzioniCliente.jsp").forward(req, resp);
				}
			} else {
				req.setAttribute("mess", "L'e-mail o password errata. Riprova oppure REGISTRATI");
				req.getRequestDispatcher("Homepage.jsp").forward(req, resp);
			}
				
			}
		}
	
	}
