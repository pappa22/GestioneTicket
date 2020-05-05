package it.dstech.gestione;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.Part;
import it.dstech.modelli.Admin;
import it.dstech.modelli.Utente;

public class Controller {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("emf");
	  private static  EntityManager em = emf.createEntityManager();
	  
	  public void close() {
		    em.close();
		  }
	  
	  public void attivazioneUtente(Utente u) {
		  Query query = em.createQuery("SELECT u FROM Utente u WHERE u.username = ?1", Utente.class).setParameter(1, u.getUsername());
		  Utente utente = (Utente) query.getSingleResult();
		  em.getTransaction().begin();
		  utente.setActive(true);
		  em.getTransaction().commit();      
	  }
	  
	  public Utente getUtente(String nome) {
		    Utente utente  =   em.createQuery("SELECT e FROM Utente e WHERE e.username = ?1", Utente.class).setParameter(1,nome).getSingleResult();       
			return utente;
	  }
	  
	  public Utente checkUtente(String mail, String password) {
			Utente u;

			Query query = em.createQuery("SELECT u FROM Utente u WHERE u.username = :mail AND u.password= :password ",
					Utente.class);
			query.setParameter("mail", mail);
			query.setParameter("password", password);

			try {
				u = (Utente) query.getSingleResult();
				return u;

			} catch (NoResultException e) {
				return null;
			}

		}
	  
	  public Utente checkRegistraUtente(String mail) {
		  Utente u;

			Query query = em.createQuery("SELECT u FROM Utente u WHERE u.username = :username",
					Utente.class);
			query.setParameter("username", mail);
			

			try {
				u = (Utente) query.getSingleResult();
				return u;

			} catch (NoResultException e) {
				return null;
			}

		}
	  
		public void salvaUtente(String nome, String cognome, String mail, String password, Part image) throws IOException  {
			
			InputStream f = image.getInputStream();
			byte[] imageBytes = new byte[(int) image.getSize()];
			f.read(imageBytes, 0, imageBytes.length);
			f.close();
			String imageStr = Base64.getEncoder().encodeToString(imageBytes);
			Utente utente = new Utente();

			utente.setNome(nome);
			utente.setCognome(cognome);
			utente.setUsername(mail);
			utente.setPassword(password);
			utente.setImage(imageStr);
		
			
			em.getTransaction().begin();
			em.persist(utente);
			em.getTransaction().commit();

		}

		public void salvaAdmin(String nome, String cognome, String mail, String password, Part image) throws IOException{
		
			InputStream f = image.getInputStream();
			byte[] imageBytes = new byte[(int) image.getSize()];
			f.read(imageBytes, 0, imageBytes.length);
			f.close();
			String imageStr = Base64.getEncoder().encodeToString(imageBytes);
			Admin admin = new Admin();
			
			admin.setNome(nome);
			admin.setCognome(cognome);
			admin.setMail(mail);
			admin.setPassword(password);
			admin.setImage(imageStr);
		
			
			em.getTransaction().begin();
			em.persist(admin);
			em.getTransaction().commit();

		}
		
		
		public Admin checkRegistraAdmin(String mail) {
			 Admin a;

				Query query = em.createQuery("SELECT a FROM Admin a WHERE a.mail = :mail",
						Admin.class);
				query.setParameter("mail", mail);
				

				try {
					a = (Admin) query.getSingleResult();
					return a;

				} catch (NoResultException e) {
					return null;
				}

			}

}
