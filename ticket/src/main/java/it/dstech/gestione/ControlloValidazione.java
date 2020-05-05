package it.dstech.gestione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.dstech.modelli.Utente;



@WebServlet(urlPatterns = {"/validazione"})
public class ControlloValidazione extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String mailUtente = req.getParameter("mail");
    Controller gestione;
   Utente utente = new Utente();
   utente.setUsername(mailUtente);
    gestione = new Controller();
    gestione.attivazioneUtente(utente);
    req.setAttribute("mess", "L'utente " + mailUtente + " è stato validato");
    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
    
  }
}