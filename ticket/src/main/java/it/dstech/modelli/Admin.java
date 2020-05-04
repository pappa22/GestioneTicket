package it.dstech.modelli;


	import java.util.ArrayList;
	import java.util.List;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Lob;
	import javax.persistence.OneToMany;

	@Entity
	public class Admin {
	  
	    private String nome;
	    private String cognome;
	    private String password;
	    
	    @Id
	    private String mail;
	    private boolean active;
	    
	    @Lob
	    @Column(columnDefinition ="LONGBLOB NOT NULL")
	    private String image;
	      
	    @OneToMany
	    List<Applicazione> listaApplicazioni = new ArrayList<Applicazione>();

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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
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

		public List<Applicazione> getListaApplicazioni() {
			return listaApplicazioni;
		}

		public void setListaApplicazioni(List<Applicazione> listaApplicazioni) {
			this.listaApplicazioni = listaApplicazioni;
		}
	    
	    
	    
	}
	    
