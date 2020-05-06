package it.dstech.gestione;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
	  
	  public void attivazioneUtente(Utente u) {
		  Query query = em.createQuery("SELECT u FROM Utente u WHERE u.username = ?1", Utente.class).setParameter(1, u.getUsername());
		  Utente utente = (Utente) query.getSingleResult();
		  em.getTransaction().begin();
		  utente.setActive(true);
		  em.getTransaction().commit();      
	  }
	  
	  public boolean controlloUtente(Utente u) {
		    String username = u.getUsername();
		    List<Utente> listaUtenti  =  em.createQuery("SELECT u FROM Utente u WHERE u.username = ?1", Utente.class).setParameter(1,username).getResultList();    
		    for(Utente utente: listaUtenti) {
		      if (utente.getUsername().equalsIgnoreCase(u.getUsername())){
		        return true;
		      }
		    }
		    return false;
		  }
	  
	  public void attivazioneAdmin(Admin a) {
		  Query query = em.createQuery("SELECT u FROM Admin u WHERE u.mail = ?1", Admin.class).setParameter(1, a.getMail());
		  Admin admin = (Admin) query.getSingleResult();
		  em.getTransaction().begin();
		  admin.setActive(true);
		  em.getTransaction().commit();      
	  }
	  
	  
	  public Utente getUtente(String nome) {
		    Utente utente  =   em.createQuery("SELECT e FROM Utente e WHERE e.username = ?1", Utente.class).setParameter(1,nome).getSingleResult();       
			return utente;
	  }
	  

	 
	  
	  public boolean checkRegistraUtente(String mail) {
		  Utente utente = em.find(Utente.class, mail);
			if(utente != null) {
				if(utente.getUsername().equals(mail)) {
					return true;
				}
			}return false;

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
		
		
		public boolean checkRegistraAdmin(String mail) {
			Admin admin = em.find(Admin.class, mail);
			if(admin != null) {
				if(admin.getMail().equals(mail) ) {
					return true;
				}
			}return false;
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
		
		public List<Applicazione> stampaListaApplicazioni(Admin admin) {
			TypedQuery<Applicazione> query = em.createQuery("select a from Applicazione a where a.admin = ?1",
					Applicazione.class);
			query.setParameter(1, admin);
			return query.getResultList();
		}
		

		public List<Applicazione> stampaTutteLeApplicazioni() {
			TypedQuery<Applicazione> query = em.createQuery("select a from Applicazione a",
					Applicazione.class);
			
			return query.getResultList();
		}
		
		

		public void rimuoviApplicazione(String nomeApp, Admin admin) {
			Query query = em.createQuery("DELETE Applicazione WHERE nome = ?1 and admin=?2").setParameter(1, nomeApp).setParameter(2, admin);
			em.getTransaction().begin();
			int result = query.executeUpdate();
			if(result!=0) {
				em.getTransaction().commit();	     
			}
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
		public boolean checkEsistenzaApplicazione(String nome) {
			Applicazione find = em.find(Applicazione.class, nome);
			if(find != null) {
				return true;
			}return false;
		}

		public Applicazione getApplicazione(String nomeApp) {
			return em.find(Applicazione.class, nomeApp);
		}

}
