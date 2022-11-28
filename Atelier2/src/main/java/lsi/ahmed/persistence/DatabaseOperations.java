package lsi.ahmed.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class DatabaseOperations {
	
	private static final String PERSISTENCE_UNIT_NAME = "unit";	
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();
	
	/*
	// methode d'ajout d'un client
			public static String AjouterClient(String nom, String adresse, String mail, Integer mdp, String tel) {
				if(!transactionObj.isActive()) {
					transactionObj.begin();
				}

				Client client = new Client(nom, adresse, mail, mdp, tel);
				
				entityMgrObj.persist(client);
				transactionObj.commit();
				return "listClient.xhtml?faces-redirect=true";	
			}
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public static List getAllClient() {
				Query queryObj = entityMgrObj.createQuery("SELECT c FROM Client c");
				List<Client> list = queryObj.getResultList();
				if (list != null && list.size() > 0) {			
					return list;
				} else {
					return null;
				}
			}
			*/
			
			//ajouter produit
			public static String AjouterProduit(String lib, int qte, Float pu, String desc, int idCat) {
				if (!transactionObj.isActive()) {
					transactionObj.begin();
				}
				
				Produit p = new Produit(lib, qte, pu, desc, idCat);
				System.out.println(p.toString());
				entityMgrObj.persist(p);
				transactionObj.commit();
				return "listProduits.xhtml?faces-redirect=true";
			}

			//ajouter categorie
			public static String creerCategorie(String lib ) {
				if (!transactionObj.isActive()) {
					transactionObj.begin();
				}

				Categorie c = new Categorie(lib);

				entityMgrObj.persist(c);
				transactionObj.commit();

				return "listCategories.xhtml?faces-redirect=true";
			}

			//list des categorie
			public static List getAllCategories() {
				Query queryObj = entityMgrObj.createQuery("SELECT e FROM Categorie e");
				List<Categorie> list = queryObj.getResultList();
				if (list != null && list.size() > 0) {
					System.out.println(list) ;
					return list;
				} else {
					return null;
				}
			}

			//liste des produits d'une categorie
			@SuppressWarnings("unchecked")
			public static List getAllProduits(int idCat) {
				Query queryObj = entityMgrObj.createQuery("SELECT e FROM Produit e WHERE id_cat = ?");
				queryObj.setParameter(1, idCat);
				List<Produit> list = queryObj.getResultList();
				if (list != null && list.size() > 0) {
					return list;
				} else {
					return null;
				}
			}

			//mettre a jour une categorie
			public static String updateCategorie(Categorie cat) {
				if (!transactionObj.isActive()) {
					transactionObj.begin();
				}

				Query queryObj = entityMgrObj.createQuery("UPDATE Categorie c SET c.libelle=:nom WHERE c.idCat = " + cat.getIdCat());

				queryObj.setParameter("nom", cat.getNomCat());
				queryObj.executeUpdate();

				transactionObj.commit();
				return "listCategories.xhtml?faces-redirect=true";
			}

			//mettre a jour un produit
			public static String updateProduit(Produit prod) {
				if (!transactionObj.isActive()) {
					transactionObj.begin();
				}

				Query queryObj = entityMgrObj.createQuery(
						"UPDATE Produit p SET p.libelle=:lib, p.quantiteProd=:qte, p.descProd=:desc, p.puProd=:pu, p.cat=:cat p WHERE p.idProd = "+ prod.getIdProd());

				queryObj.setParameter("lib", prod.getNomProd());
				queryObj.setParameter("qte", prod.getQuantiteProd());
				queryObj.setParameter("desc", prod.getDescProd());
				queryObj.setParameter("pu", prod.getPuProd());
				queryObj.setParameter("cat", prod.getCat());

				queryObj.executeUpdate();

				transactionObj.commit();
				return "listProduits.xhtml?faces-redirect=true";
			}

			//delete cat
			public static String deleteCategorie(int idCat) {
				if (!transactionObj.isActive()) {
					transactionObj.begin();
				}
				//cherche la categorie par son id grace a la methode find(class,identifiant)
				Categorie cat = entityMgrObj.find(Categorie.class, idCat);

				entityMgrObj.remove(cat);

				transactionObj.commit();

				return "listCategories.xhtml?faces-redirect=true";
			}

			//delete produit
			public static String deleteProduit(int idProd) {
				if (!transactionObj.isActive()) {
					transactionObj.begin();
				}
				//cherche le produit par son id grace a la methode find(class,identifiant)
				Produit prod = entityMgrObj.find(Produit.class, idProd);

				entityMgrObj.remove(prod);

				transactionObj.commit();

				return "listProduits.xhtml?faces-redirect=true";
			}

			//verification d'existance ou pas d'une cat
			public static boolean idCatExist(int idCat) {
				boolean exist = false;
				//requete pour recupere la categorie sachant son id
				Query queryObj = entityMgrObj.createQuery("SELECT c FROM Categorie c WHERE c.idCat = " + idCat);
				//ici la methode getSingleResult qui recupere un seul resultat 
				//sinon lance NoResultException- s'il n'y a pas de résultat
				EntityManager idC = (EntityManager) queryObj.getSingleResult();
				if (idC != null) {
					exist = true;
				}
				return exist;
			}

			//recuperer une categorie sachant son id
			public static Categorie getCategorieById(int id) {
				if (!transactionObj.isActive()) {
					transactionObj.begin();
				}

				Categorie cat = entityMgrObj.find(Categorie.class, id);

				return cat;
			}

			////recuperer un produit sachant son id
			public static Produit getProduitById(int id) {
				if (!transactionObj.isActive()) {
					transactionObj.begin();
				}

				Produit prod = entityMgrObj.find(Produit.class, id);

				return prod;
			}

			//lister les produits
			@SuppressWarnings("unchecked")
			public static List getAllProduits() {
				Query queryObj = entityMgrObj.createQuery("SELECT p FROM Produit p");
				List<Produit> list = queryObj.getResultList();
				if (list != null && list.size() > 0) {
					return list;
				} 
				else {
					return null;
				}
			}

			//lister les produits sachant leur catagorie
			@SuppressWarnings("unchecked")
			public static List getProduitsByCat(Integer idCat) {
				Categorie cat = entityMgrObj.find(Categorie.class, idCat);
				//requete de HQL pour retourner tous les produits sachant leur categorie
				Query queryObj = entityMgrObj.createQuery("SELECT p FROM Produit p WHERE p.cat.idCat = " + idCat);
				List<Produit> list = queryObj.getResultList();
				if (list != null && list.size() > 0) {
					return list;
				} 
				else {
					
					return null;
				}
			}
	
}
