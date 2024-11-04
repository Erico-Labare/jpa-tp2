package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLOutput;

public class BiblioTest {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");
        EntityManager em = emf.createEntityManager();

        Livre livre = em.find(Livre.class, 1);
        if (livre != null) {
            System.out.println("\nLivre trouvé !");
            System.out.println(" ID : " +livre.getId()+" ;Titre : "+livre.getTitre()+" ;Auteur : "+livre.getAuteur()+".");
        }
        else {
            System.out.println("Error");
        }

        em.close();
        emf.close();
    }
}
