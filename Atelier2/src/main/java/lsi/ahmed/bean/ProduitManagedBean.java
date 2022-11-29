package lsi.ahmed.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import lsi.ahmed.persistence.Categorie;
import lsi.ahmed.persistence.DatabaseOperations;
import lsi.ahmed.persistence.Produit;

@SessionScoped
@ManagedBean(name = "ProduitBean")
public class ProduitManagedBean {
	private int idProd = 0;
	private String libelle;
	private int qte;
	private Float pu;
	private String desc;
	private Categorie cat;
	private int idcat;
	
	
	public int getIdcat() {
		return idcat;
	}
	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}
	
	
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Float getPu() {
		return pu;
	}
	public void setPu(Float pu) {
		this.pu = pu;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	
	private List<Categorie> listeCategories = new ArrayList<Categorie>();
	
	//enregistrer un produit
	public String save(ProduitManagedBean bean) {
		return DatabaseOperations.AjouterProduit(bean.libelle, bean.qte, bean.pu, bean.desc, bean.getIdcat()) ;
	}
	
	//liste de produit par categorie
	@SuppressWarnings("unchecked")
	public List<Produit> listeProduits(int id) {

		this.cat = DatabaseOperations.getCategorieById(id);
		return DatabaseOperations.getAllProduits(id);

	}
	
	//liste de categorie
	public List listCategories() {
		return DatabaseOperations.getAllCategories();
	}
	
	//liste de produit
	@SuppressWarnings("unchecked")
	public List<Produit> listProduits() {
		return DatabaseOperations.getAllProduits();
	}
	
	//liste de produit par categorie
	@SuppressWarnings("unchecked")
	public List<Produit> listProduits(int id) {

		this.cat = DatabaseOperations.getCategorieById(id);
		return DatabaseOperations.getAllProduits(id);

	}
	
	public String delete(int idProd) {
		return DatabaseOperations.deleteProduit(idProd);
	}
	
	public String redirectDelete(int idProd) {
		Produit p = DatabaseOperations.getProduitById(idProd);
		return DatabaseOperations.deleteProduit(p.getIdProd());
	}

	public String redirectAddProd() {
		return "addProduit.xhtml?faces-redirect=true";
	}
	
	//mise a jour d'un produit
	public String updateProduit(ProduitManagedBean bean) throws IOException {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		Produit prod = new Produit(Integer.parseInt(params.get("idProd")), bean.libelle, bean.qte, bean.pu, bean.desc, bean.cat.getIdCat());
		return DatabaseOperations.updateProduit(prod);
	}
	
	//redirection mis a jour un produit
	public String redirectUpdate(int idProd) 
	{

		Produit p = DatabaseOperations.getProduitById(idProd);

		this.libelle = p.getNomProd();
		this.qte = p.getQuantiteProd();
		this.pu = p.getPuProd();
		this.desc = p.getDescProd();
		this.cat = p.getCat();

		return "updateProduit.xhtml?faces-redirect=true&idProd=" + idProd;
	}
	public int setProduit(int idProd) {
		this.idProd = DatabaseOperations.getProduitById(idProd).getIdProd();
		this.libelle = DatabaseOperations.getProduitById(idProd).getNomProd();
		return this.idProd;
	}
	
}
