package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();


        User user = new User();
        user.setUsername("Cristina");
        user.setPassword("123");

        SecurityGroup securitygroup = new SecurityGroup();
        securitygroup.setName("Admin");

        user.setSgroups(new ArrayList<>());
        user.getSgroups().add(securitygroup);

        if (securitygroup.getUsers() == null) {
            securitygroup.setUsers(new ArrayList<>());
        }
        securitygroup.getUsers().add(user);

        em.getTransaction().begin();
        em.persist(user);
        em.persist(securitygroup);
        em.getTransaction().commit();

        //Fetch user
        User fetchedUser = em.find(User.class, user.getId());
        System.out.println("User: " + fetchedUser.getUsername());
        for (SecurityGroup group : fetchedUser.getSgroups()) {
            System.out.println("Associated Security Group: " + group.getName());
        }
        em.close();

        //Update user
        EntityManager em1 = emf.createEntityManager();
        em1.getTransaction().begin();
        fetchedUser.setPassword("ola");
        User updatedUser = em1.merge(fetchedUser);

        em1.getTransaction().commit();

        // Close the database connection
        em1.close();

        // Shutdown JPA
        emf.close();
    }

}
