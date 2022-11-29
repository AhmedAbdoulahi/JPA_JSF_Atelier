package lsi.ahmed.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import lsi.ahmed.persistence.Categorie;
import lsi.ahmed.persistence.DatabaseOperations;

@ApplicationScoped
@ManagedBean(name = "CategorieManagedBean")
@MultipartConfig
public class CategorieManagedBean {
	private int idCat;
	private String libelle;
	private Part img;
	private StreamedContent image;
	
	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public Part getImg() {
		return img;
	}

	public void setImg(Part img) {
		this.img = img;
	}

	public void setImage(StreamedContent image) {
		this.image = image;
	}

	//ajouter une categorie
	public String save(CategorieManagedBean bean) throws IOException {
		InputStream input = img.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[10240];
		for (int length = 0; (length = input.read(buffer)) > 0;)
			output.write(buffer, 0, length);
		return DatabaseOperations.creerCategorie(bean.libelle , output.toByteArray());
	}
	
	
	public StreamedContent getImage() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			this.image = new DefaultStreamedContent();
			return this.image;
		} else {
			String imageId = context.getExternalContext().getRequestParameterMap().get("idCat");
			byte[] myImage = null;
			for (Categorie cat : listCategories()) {
				if (cat.getIdCat() == Integer.valueOf(imageId)) {
					myImage = cat.getImgCat();
					break;
				}
			}
			this.image = new DefaultStreamedContent(new ByteArrayInputStream(myImage));
			return this.image;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Categorie> listCategories() {
		return DatabaseOperations.getAllCategories();
	}

	public String redirectUpdate(int idCat) {
		return "updateCategorie.xhtml?faces-redirect=true&idCat="+idCat;
	}
	
	public String redirectProduit(int idCat)
	{
		return "listProduitsByCat.xhtml?faces-redirect=true&idCat="+idCat;
	}
	
	public String redirectDelete(int idCat)
	{
		return DatabaseOperations.deleteCategorie(idCat);
	}
	
	public int setCategorie(int id)
	{
		this.idCat = DatabaseOperations.getCategorieById(id).getIdCat();
		this.libelle = DatabaseOperations.getCategorieById(id).getNomCat();
		return this.idCat;
	}

	public String updateCategorie(CategorieManagedBean bean) throws IOException
	{
		InputStream input = img.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[10240];
		for (int length = 0; (length = input.read(buffer)) > 0;)
			output.write(buffer, 0, length);
		
		Categorie cat = new Categorie(bean.idCat, bean.libelle, output.toByteArray());
		return DatabaseOperations.updateCategorie(cat);
	}
	
	
	
}
