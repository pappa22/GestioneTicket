package it.dstech.modelli;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String nome;
	private String descrizione;
	private boolean stato;
	
	@CreationTimestamp
    private Timestamp data;
	
    @OneToOne
    @JoinColumn(name="utente")
    private Utente utente;
    
    @OneToOne
    @JoinColumn(name="applicazione")
    private Applicazione applicazione;

    
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Applicazione getApplicazione() {
		return applicazione;
	}

	public void setApplicazione(Applicazione applicazione) {
		this.applicazione = applicazione;
	}  	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
