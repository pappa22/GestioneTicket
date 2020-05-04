package it.dstech.gestione;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.modelli.Utente;

@WebServlet(urlPatterns = "/Accesso")
public class GestioneAccesso extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  Controller gestione=new Controller();
	  HttpSession session =req.getSession();
	  Utente utente = gestione.getUtente(req.getParameter("username"));
	  String scelta = req.getParameter("scelta");
	  
  
  }
}