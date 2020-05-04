package it.dstech.gestione;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.regex.Pattern;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import it.dstech.modelli.Utente;
import it.dstech.utility.EmailUtility;


@WebServlet(urlPatterns = "/Registrazione")
@MultipartConfig
public class Registrazione extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("messaggio", "Pagina non accessibile");
    req.getRequestDispatcher("/Homepage.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
  }
  

  private String generaLinkValidazioneUtente(Utente utente) {
    String validationPath = "http://localhost:8080/webApp-Battleground/validazione?utente=";
    return "Per attivare la mail clicca su questo link: " + validationPath + utente.getUsername();
  }
}
