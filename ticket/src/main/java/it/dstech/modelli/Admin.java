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
	  
	    @Id
	    private String username;
	    private String password;
	    private boolean active;
	    @Lob
	    @Column(columnDefinition ="LONGBLOB NOT NULL")
	    private String image;
	      
	    @OneToMany
	    List<Applicazione> listaApplicazioni = new ArrayList<Applicazione>();

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

		public List<Applicazione> getListaApplicazioni() {
			return listaApplicazioni;
		}

		public void setListaApplicazioni(List<Applicazione> listaApplicazioni) {
			this.listaApplicazioni = listaApplicazioni;
		} 
	}
	    
