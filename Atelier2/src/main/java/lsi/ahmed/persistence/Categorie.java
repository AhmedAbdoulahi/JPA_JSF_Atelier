package lsi.ahmed.persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	
	@Column(nullable = true, length = 52428800)
	@Lob
	private byte[] imgCat;
	
	@OneToMany
	@JoinColumn(name = "id_cat")
	private List<Produit> listProd;

	public Categorie() {
		// TODO Auto-generated constructor stub
		super();
		
	}

	public Categorie(String libelle, byte[] img) {
		// TODO Auto-generated constructor stub
		super();
		this.libelle = libelle;
		this.imgCat = img ;
	}

	public Categorie(int id, String libelle2, byte[] img) {
		// TODO Auto-generated constructor stub
		super();
		this.idCat = id ;
		this.libelle = libelle2;
		this.imgCat = img ;
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
	

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public byte[] getImgCat() {
		return imgCat;
	}

	public void setImgCat(byte[] imgCat) {
		this.imgCat = imgCat;
	}

	@Override
	public String toString() {
		return "Categorie [idCat=" + idCat + ", nomCat=" + libelle + "]";
	}

}
