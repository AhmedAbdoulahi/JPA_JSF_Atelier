package lsi.ahmed.persistence;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int idPa ;

	@Column(nullable = true, length = 45)
	private int qte;

	@Column(nullable = false)
	private Date dateAjout;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Client idCli ;
	
	

	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Panier(int idPa, int qte, Date dateAjout, Client idCli) {
		super();
		this.idPa = idPa;
		this.qte = qte;
		this.dateAjout = dateAjout;
		this.idCli = idCli;
	}

	public int getIdPa() {
		return idPa;
	}

	public void setIdPa(int idPa) {
		this.idPa = idPa;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Client getIdCli() {
		return idCli;
	}

	public void setIdCli(Client idCli) {
		this.idCli = idCli;
	}
	
	
	
}
