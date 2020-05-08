package it.dstech.gestione;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import it.dstech.modelli.Admin;
import it.dstech.modelli.Applicazione;

@WebServlet(urlPatterns = { "/Admin/ModificaApplicazione", "/ModificaApplicazione" })
@MultipartConfig
public class ModificaApplicazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "Pagina non accessibile");
		req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Controller gestione = new Controller();
		long idApp = Long.parseLong(req.getParameter("idApp"));
		String nome = req.getParameter("nome");
		String descrizione = req.getParameter("descrizione");
		gestione.modificaApplicazione(nome, descrizione, idApp);
		req.setAttribute("listaApplicazioni", gestione.stampaListaApplicazioni((Admin)session.getAttribute("admin")));
		req.getRequestDispatcher("/Admin/GestioneApplicazione").forward(req, resp);
	}
}
