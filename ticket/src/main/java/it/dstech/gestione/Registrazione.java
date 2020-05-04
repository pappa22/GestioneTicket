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

import it.dstech.modelli.Admin;
import it.dstech.modelli.Utente;
import it.dstech.utility.EmailUtility;
import it.dstech.utility.PasswordUtility;



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
	  String nome = req.getParameter("nome");
	  String cognome = req.getParameter("cognome");
	  	String mail = req.getParameter("mail");
		String password = PasswordUtility.encrypt(req.getParameter("password"), "Mary has one ca1");
		Part image = req.getPart("image");
		String tipo = req.getParameter("tipo");
		Controller s = new Controller();
		
		
		
	   if (tipo.equalsIgnoreCase("utente")) {
		   Utente u = s.checkRegistraUtente(mail);
		   if(u == null) {
			s.salvaUtente(nome, cognome, mail, password, image);
		   }
			else {
				req.setAttribute("mess",
									"Credenziali già presenti; provi con un altra mail, se è gia registrato per entrare nel sito cliccare su Accedi");
							
							s.close();
							req.getRequestDispatcher("login.jsp").forward(req, resp);
							
						}
			try {
				EmailUtility.sendEmail(mail, "Conferma Mail", generaLinkValidazioneUtente(u));
			} catch (MessagingException | IOException e) {

				e.printStackTrace();
			}

			req.setAttribute("mess",
					"La registrazione sarà confermata solo dopo aver cliccato sul link che le abbiamo inviato sulla sua mail");
			s.close();

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	   
	   else if (tipo.equalsIgnoreCase("admin")) {
		   Admin a = s.checkRegistraAdmin(mail);
		   if(a == null) {
			s.salvaAdmin(nome, cognome, mail, password, image);
		   }
	

		else {
req.setAttribute("mess",
					"Credenziali già presenti; provi con un altra mail, se è gia registrato per entrare nel sito cliccare su Accedi");
			
			s.close();
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
		}
		   
	   }

	}

	
  

  private String generaLinkValidazioneUtente(Utente utente) {
    String validationPath = "http://localhost:8080/ticket/validazione?utente=";
    return "Per attivare la mail clicca su questo link: " + validationPath + utente.getUsername();
  }
}
