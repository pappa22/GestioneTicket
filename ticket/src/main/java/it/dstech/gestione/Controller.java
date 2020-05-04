package it.dstech.gestione;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
}
