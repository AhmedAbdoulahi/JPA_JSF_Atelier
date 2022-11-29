package lsi.ahmed.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lsi.ahmed.persistence.Client;
import lsi.ahmed.persistence.DatabaseOperations;
import lsi.ahmed.persistence.Panier;
import lsi.ahmed.persistence.Produit;

public class PanierManagedBean {
	private int idPa ;

	private int qte;

	private Date dateAjout;
	
	private Client idCli ;

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
	
	//liste de paniers
		@SuppressWarnings("unchecked")
		public List<Panier> listProduits() {
			return DatabaseOperations.getAllPaniers();
		}
	//delete panier
		public String delete(int idPa) {
			return DatabaseOperations.deletePanier(idPa);
		}
		
	//
		//enregistrer un panier
		public String save(PanierManagedBean bean) {
			return DatabaseOperations.creerPanier( bean.idPa, bean.qte, bean.dateAjout, bean.idCli ) ;
		}
		
}
