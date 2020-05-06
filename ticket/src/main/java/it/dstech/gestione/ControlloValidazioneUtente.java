package it.dstech.gestione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.dstech.modelli.Utente;



@WebServlet(urlPatterns = {"/validazioneUtente"})
public class ControlloValidazioneUtente extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   HttpSession session = req.getSession();
	  Utente utente = (Utente) ( session).getAttribute("utente");
    Controller gestione;
   
    gestione = new Controller();
    gestione.attivazioneUtente(utente);
    req.setAttribute("mess", "L'utente " + utente.getUsername() + " è stato validato");
    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
    
  }
}