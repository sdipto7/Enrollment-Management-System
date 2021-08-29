package net.therap.hibernet.dao;

import net.therap.hibernet.domain.User;
import net.therap.hibernet.util.EntityManagerConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class UserDao {

    EntityManager entityManager = EntityManagerConfiguration.getInstance().getEntityManager();

    public List<User> findAll() {
        Query query = entityManager.createQuery("from User");

        return query.getResultList();
    }

    public User findUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public void update(User user, String newName) {
        entityManager.getTransaction().begin();

        user.setName(newName);

        entityManager.getTransaction().commit();
    }

    public void save(User user) {
        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();
    }

    public void delete(long id) {
        User user = entityManager.find(User.class, id);

        entityManager.getTransaction().begin();
        if (Objects.nonNull(user)) {
            entityManager.remove(user);
        }
        entityManager.getTransaction().commit();
    }
}