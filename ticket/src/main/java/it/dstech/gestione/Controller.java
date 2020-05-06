package it.dstech.gestione;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.Part;

import it.dstech.modelli.Admin;
import it.dstech.modelli.Applicazione;
import it.dstech.modelli.Utente;

public class Controller {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("emf");
	  private static  EntityManager em = emf.createEntityManager();
	  
	  public void close() {
		    em.close();
		  }
	  
	  public boolean attivazioneUtente(Utente u) {
		  Query query = em.createQuery("SELECT u FROM Utente u WHERE u.username = ?1", Utente.class).setParameter(1, u.getUsername());
		  Utente utente = (Utente) query.getSingleResult();
		  return utente.isActive();
	  }
	  
	  public Utente getUtente(String nome) {
		    Utente utente  =   em.createQuery("SELECT e FROM Utente e WHERE e.username = ?1", Utente.class).setParameter(1,nome).getSingleResult();       
			return utente;
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
		
		public boolean checkAdmin(String email, String password) {
			Admin admin = em.find(Admin.class, email);
			if(admin != null) {
				if(admin.getMail().equals(email) && admin.getPassword().equals(password)) {
					return true;
				}
			}return false;
		}
		
		public boolean checkUtente(String email, String password) {
			Utente utente = em.find(Utente.class, email);
			if(utente != null) {
				if(utente.getUsername().equals(email) && utente.getPassword().equals(password)) {
					return true;
				}
			}return false;
		}

		public Admin getOggettoAdmin(String email) {
			return em.find(Admin.class, email);
		}
		
		public Utente getOggettoUtente(String email) {
			return em.find(Utente.class, email);
		}

		public List<Applicazione> getListaApplicazioni(Admin admin) {
			Admin find = em.find(Admin.class, admin.getMail());
			return find.getListaApplicazioni();
		}
		
		
		public void aggiungiApplicazione(String nome, String descrizione, Admin admin) {
			Applicazione applicazione = new Applicazione();
			applicazione.setNome(nome);
			applicazione.setDescrizione(descrizione);
			applicazione.setAdmin(admin);
			em.getTransaction().begin();
			em.persist(applicazione);
			em.getTransaction().commit();
		}

}
