package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();

        //Single Table Inheritance
        Owner owner = new Owner();
        owner.setName("Cristina");

        Car car = new Car();
        car.setModel("Clio");
        car.setMake("Renault");
        car.setOwner(owner);


        em.getTransaction().begin();
        em.persist(car);
        em.persist(owner);
        em.getTransaction().commit();


        // Close the database connection
        em.close();

        // Shutdown JPA
        emf.close();
    }
}
