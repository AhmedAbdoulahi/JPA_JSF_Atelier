package lsi.ahmed.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.MultipartConfig;

import lsi.ahmed.persistence.Categorie;
import lsi.ahmed.persistence.DatabaseOperations;

@ApplicationScoped
@ManagedBean(name = "CategorieManagedBean")
@MultipartConfig
public class CategorieManagedBean {
	private int idCat;
	private String libelle;
	
	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	//ajouter une categorie
	public String save(CategorieManagedBean bean) throws IOException {
		return DatabaseOperations.creerCategorie(bean.libelle);
	}
	
	
	public List<Categorie> listCategories() {
		@SuppressWarnings("unchecked")
		List<Categorie> l = DatabaseOperations.getAllCategories() ; 
		System.out.println(l);
		return l ;
	}
	//redirection 
	public String redirectUpdate(int idCat) {
		return "updateCategorie.xhtml?faces-redirect=true&idCat="+idCat ;
	}
	
	//redirection page des list de produit par categorie
	public String redirectProduit(int idCat)
	{
		return "listProduitsByCat.xhtml?faces-redirect=true&idCat="+idCat;
	}
	//redirection
	public String redirectDelete(int idCat)
	{
		return DatabaseOperations.deleteCategorie(idCat);
	}
	
	//categorie sachant son id
	public int setCategorie(int id)
	{
		this.idCat = DatabaseOperations.getCategorieById(id).getIdCat();
		this.libelle = DatabaseOperations.getCategorieById(id).getNomCat();
		return this.idCat;
	}
	
	
	
}
