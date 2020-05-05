package it.dstech.modelli;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Applicazione {

	@Id
    private String nome;
	private String descrizione;
	
    @OneToOne
    @JoinColumn(name="admin")
    private Admin admin;
    
    @OneToMany
    @JoinColumn(name="ticket")
    List<Ticket> listaTicket = new ArrayList<Ticket>();
    

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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Ticket> getListaTicket() {
		return listaTicket;
	}

	public void setListaTicket(List<Ticket> listaTicket) {
		this.listaTicket = listaTicket;
	}
    
    
}
