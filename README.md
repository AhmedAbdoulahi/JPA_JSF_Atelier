# JPA JSF Atelier

Ce projet est une application web qui utilise Java Server Faces (JSF) et JPA pour gérer des entités telles que `Categorie`, `Produit`, et `Panier`.

## Structure du projet

- `.settings/` : Contient les fichiers de configuration de l'IDE Eclipse.
- `src/main/java/lsi/ahmed/bean/` : Contient les classes Java pour les beans managés `CategorieManagedBean.java`, `PanierManagedBean.java`, et `ProduitManagedBean.java`.
- `src/main/java/META-INF/` : Contient les fichiers de configuration JPA, notamment `persistence.xml` pour la gestion de la persistance.
- `persistence/` : Contient la logique de persistance des données.
- `webapp/` : Contient les fichiers liés à l'interface utilisateur de l'application (fichiers JSP, XHTML, etc.).
- `target/` : Répertoire utilisé par Maven pour stocker les fichiers compilés et les artefacts générés.
- `.classpath` : Fichier de configuration spécifique à Eclipse définissant le chemin de classe du projet.
- `.project` : Fichier de configuration du projet Eclipse.
- `pom.xml` : Fichier de configuration Maven contenant les dépendances et configurations de build.

## Fonctionnalités

- Gestion des catégories, produits, et panier via une interface JSF.
- Les beans managés `CategorieManagedBean`, `PanierManagedBean` et `ProduitManagedBean` permettent l'interaction avec l'interface utilisateur et la persistance des entités.
- Utilisation de JPA (Java Persistence API) pour la gestion de la persistance des données.

## Prérequis

- Java JDK 8 ou version ultérieure.
- Apache Maven 3.6.0 ou version ultérieure.
- Serveur d'application (Tomcat intégré avec JSF supporté).
- Base de données (MySQL, PostgreSQL, etc.).

## Installation
Clonez le dépôt :

   ```bash
   git clone <url-du-repo>
