package it.dstech.gestione;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Admin;

@WebServlet(urlPatterns = {"/Admin/AggiuntaApplicazione" , "/AggiuntaApplicazione"})
public class AggiuntaApplicazione extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller gestione = new Controller();
		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		String nome = req.getParameter("nome");
		String descrizione = req.getParameter("descrizione");
		if(!gestione.checkEsistenzaApplicazione(nome)) {
		gestione.aggiungiApplicazione(nome, descrizione, admin);
		req.setAttribute("mess", "Applicazione esistente");
		}
		req.setAttribute("listaApplicazioni", gestione.stampaListaApplicazioni(admin));
		req.getRequestDispatcher("/Admin/AggiuntaApplicazione.jsp").forward(req, resp);
	}

}
