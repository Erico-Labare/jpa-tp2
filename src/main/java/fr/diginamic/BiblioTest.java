package fr.diginamic;

import fr.diginamic.entities.Emprunt;
import fr.diginamic.entities.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BiblioTest {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-jpa");
        EntityManager em = emf.createEntityManager();

//        Livre livre = em.find(Livre.class, 1);
//        if (livre != null) {
//            System.out.println("\nLivre trouvé !");
//            System.out.println(" ID : " +livre.getId()+" ;Titre : "+livre.getTitre()+" ;Auteur : "+livre.getAuteur()+".");
//        }
//        else {
//            System.out.println("Error, ID = null");
//        }

        Emprunt emprunt = em.find(Emprunt.class, 1);

        if (emprunt != null) {
            System.out.println("\nEmprunt trouvé ! Info emprunt : \n"+emprunt);
            System.out.println("\n Livre(s) emprunté(s) : \n");
            for(Livre livre: emprunt.getLivres()){
                System.out.println(livre);
            }
        }
        else {
            System.out.println("Error, ID = null");
        }

        em.close();
        emf.close();
    }
}
