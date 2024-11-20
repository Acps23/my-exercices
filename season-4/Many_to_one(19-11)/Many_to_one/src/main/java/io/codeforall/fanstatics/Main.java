package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();


        Product product = new Product();
        product.setName("Leite");


        Category category = new Category();
        category.setName("Laticinios");
        product.setCategory(category);

        em.getTransaction().begin();
        em.persist(product);
        em.persist(category);
        em.getTransaction().commit();


        // Close the database connection
        em.close();

        // Shutdown JPA
        emf.close();
    }
}
