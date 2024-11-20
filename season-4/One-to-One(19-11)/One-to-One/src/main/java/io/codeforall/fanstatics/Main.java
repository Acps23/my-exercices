package io.codeforall.fanstatics;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();


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
