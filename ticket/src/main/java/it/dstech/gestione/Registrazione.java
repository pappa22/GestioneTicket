package it.dstech.gestione;

import java.io.IOException;
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
    req.setAttribute("mess", "Pagina non accessibile");
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
		HttpSession session = req.getSession();
		if(s.checkRegistraUtente(mail) || s.checkRegistraAdmin(mail) ) {
req.setAttribute("mess", "Credenziali già presenti; provi con un altra mail, se è gia registrato per entrare nel sito cliccare su Accedi");
			
			
			req.getRequestDispatcher("Homepage.jsp").forward(req, resp);
			}
		else if (tipo.equalsIgnoreCase("utente")) {
		   
		   
			s.salvaUtente(nome, cognome, mail, password, image);
			try {
				EmailUtility.sendEmail(mail, "Conferma Mail", generaLinkValidazioneUtente(mail));
			} catch (MessagingException | IOException e) {

				e.printStackTrace();
			}

			req.setAttribute("mess","La registrazione sarà confermata solo dopo aver cliccato sul link che le abbiamo inviato sulla sua mail");
	        Utente utente = new Utente();
	        utente.setUsername(mail);
			session.setAttribute("utente", utente);

			req.getRequestDispatcher("Homepage.jsp").forward(req, resp);
		}
		   else if (tipo.equalsIgnoreCase("admin")) {
			   
				s.salvaAdmin(nome, cognome, mail, password, image);
				try {
					EmailUtility.sendEmail(mail, "Conferma Mail", generaLinkValidazioneAdmin(mail));
				} catch (MessagingException | IOException e) {

					e.printStackTrace();
				}

				req.setAttribute("mess",
						"La registrazione sarà confermata solo dopo aver cliccato sul link che le abbiamo inviato sulla sua mail");
				Admin admin = new Admin();
				admin.setMail(mail);
				session.setAttribute("admin", admin);

				req.getRequestDispatcher("Homepage.jsp").forward(req, resp);
				}
}
			   
			
			

	   

	
 
	
  private String generaLinkValidazioneAdmin(String mail) {
	    String validationPath = "http://localhost:8080/ticket/validazioneAdmin?admin=";
	    return "Per attivare la mail clicca su questo link: " + validationPath + mail;
	  }

  private String generaLinkValidazioneUtente(String mail) {
    String validationPath = "http://localhost:8080/ticket/validazioneUtente?utente=";
    return "Per attivare la mail clicca su questo link: " + validationPath + mail;
  }
}
