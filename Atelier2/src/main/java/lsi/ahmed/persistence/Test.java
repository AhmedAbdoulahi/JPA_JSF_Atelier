package lsi.ahmed.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Test {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				/*
				Client client = new Client("Ahmed","tanger","ahmed@gmail.com",1234,"Test");
				
				System.out.println("COMIITING");
				em.persist(client);
				em.getTransaction().commit();
				*/
				Categorie  c = new Categorie("Technologie");
				em.persist(c);
				em.getTransaction().commit();
				
				/*Produit prod = new Produit("pc", 2 ,(float) 6200 ,"corI5",1);
				em.persist(prod);
				em.getTransaction().commit();*/

	}
	
}
