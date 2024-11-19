package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();

        //Single Table Inheritance
        Boat boat = new Boat();
        boat.setEngines(10);

        Car car = new Car();
        car.setGears(5);

        car.setMaxSpeed(100);
        boat.setMaxSpeed(50);



        em.getTransaction().begin();
        em.persist(car);
        em.persist(boat);
        em.getTransaction().commit();


        // Close the database connection
        em.close();

        // Shutdown JPA
        emf.close();
    }

}
