package net.therap.hibernet.dao;

import net.therap.hibernet.domain.User;

import javax.persistence.Query;
import java.util.List;

import static net.therap.hibernet.util.EntityManagerConfiguration.entityManager;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class UserDao {

    public List<User> getAll(Query query) {
        return query.getResultList();
    }

    public void update(User user, String newName) {
        entityManager.getTransaction().begin();

        user.setName(newName);

        entityManager.getTransaction().commit();
    }

    public void add(User user) {
        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();
    }

    public void delete(User user) {
        entityManager.getTransaction().begin();

        entityManager.remove(user);

        entityManager.getTransaction().commit();
    }
}