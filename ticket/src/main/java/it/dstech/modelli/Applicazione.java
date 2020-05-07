package it.dstech.modelli;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Applicazione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String nome;
	private String descrizione;
	
    @OneToOne
    @JoinColumn(name="admin")
    private Admin admin;
    
    @OneToMany(mappedBy="applicazione")
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Ticket> getListaTicket() {
		return listaTicket;
	}

	public void setListaTicket(List<Ticket> listaTicket) {
		this.listaTicket = listaTicket;
	}

	@Override
	public String toString() {
		return "Applicazione [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", admin=" + admin
				+ ", listaTicket=" + listaTicket + "]";
	}
    
    
}
