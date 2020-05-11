package it.dstech.modelli;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Utente {
  
    @Id
    private String username;
    private String password;
    @Column(columnDefinition ="BOOLEAN NOT NULL")
    private boolean active;
    private String nome;
    private String cognome;
    
    @Lob
    @Column(columnDefinition ="LONGBLOB NOT NULL")
    private String image;
      
    @OneToMany(mappedBy = "utente")
    List<Ticket> listaTicket = new ArrayList<Ticket>();
    
    
    public Utente() {
    }
    
    public Utente(String username, String password) {
      this.username = username;
      this.password = password;
    }

    public Utente(String username, String password, boolean active, int rating, String image) {
      super();
      this.username = username;
      this.password = password;
      this.active = active;
      this.image = image;
    }

    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Ticket> getListaTicket() {
		return listaTicket;
	}

	public void setListaTicket(List<Ticket> listaTicket) {
		this.listaTicket = listaTicket;
	}

	

}