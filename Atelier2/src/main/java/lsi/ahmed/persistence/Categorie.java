package lsi.ahmed.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int idCat;

	@Column(nullable = true, length = 45)
	private String libelle;

	@OneToMany
	@JoinColumn(name = "id_cat")
	private List<Produit> listProd;

	public Categorie() {
		// TODO Auto-generated constructor stub
		super();
		
	}

	public Categorie(String libelle) {
		// TODO Auto-generated constructor stub
		super();
		this.libelle = libelle;
	}

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getNomCat() {
		return libelle;
	}

	public void setNomCat(String libelle) {
		this.libelle = libelle;
	}

	public List<Produit> getListProd() {
		return listProd;
	}

	public void setListProd(List<Produit> listProd) {
		this.listProd = listProd;
	}

	@Override
	public String toString() {
		return "Categorie [idCat=" + idCat + ", nomCat=" + libelle + "]";
	}

}
