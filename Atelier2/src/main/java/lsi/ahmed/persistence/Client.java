package lsi.ahmed.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(length = 255, nullable = true)
	private String nom;
	
	@Column( nullable = false)
	private String adresse;
	
	@Column( nullable = false)
	private String mail;
	
	@Column( nullable = false)
	private Integer mdp;
	
	@Column( nullable = false)
	private String tel;
	
	@OneToOne(mappedBy = "idCli")
	private Panier idPa ;
	
	@OneToMany
	private List<Commande> cmds ;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String adresse, String mail, Integer mdp, String tel) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.mail = mail;
		this.mdp = mdp;
		this.tel = tel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getMdp() {
		return mdp;
	}

	public void setMdp(Integer mdp) {
		this.mdp = mdp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
