package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();

        //Mapped Superclass Inheritance
        Customer customer = new Customer();
        customer.setName("Cristina");

        Account account = new Account();
        account.setBalance(1000.0);


        em.getTransaction().begin();
        em.persist(customer);
        em.persist(account);
        em.getTransaction().commit();


        // Close the database connection
        em.close();

        // Shutdown JPA
        emf.close();

    }
}
