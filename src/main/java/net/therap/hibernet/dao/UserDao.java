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

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<User> getAll() {
        Query query = entityManager.createQuery("from User");

        return query.getResultList();
    }

    public User get(int id) {
        return entityManager.find(User.class, id);
    }

    public void update(int id, String newName) {
        User user = entityManager.find(User.class, id);

        entityManager.getTransaction().begin();

        user.setName(newName);

        entityManager.getTransaction().commit();
    }

    public void add(int id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);

        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);

        entityManager.getTransaction().begin();

        entityManager.remove(user);

        entityManager.getTransaction().commit();
    }
}
