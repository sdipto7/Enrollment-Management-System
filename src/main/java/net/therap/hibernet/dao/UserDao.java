package net.therap.hibernet.dao;

import net.therap.hibernet.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class UserDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-1");

    public List<User> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("from User");

        return query.getResultList();
    }

    public User get(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(User.class, id);
    }

    public void update(int id, String newName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().begin();
        user.setName(newName);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void add(int id, String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = new User();
        user.setId(id);
        user.setName(name);

        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
