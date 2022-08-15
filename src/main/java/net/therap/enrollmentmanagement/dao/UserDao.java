package net.therap.enrollmentmanagement.dao;

import net.therap.enrollmentmanagement.domain.User;
import net.therap.enrollmentmanagement.util.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class UserDao {

    private EntityManager em;

    public UserDao() {
        em = EntityManagerSingleton.getInstance().getEntityManager();
    }

    public List<User> findAll() {
        Query query = em.createQuery("FROM User");

        return query.getResultList();
    }

    public User find(long id) {
        return em.find(User.class, id);
    }

    public void saveOrUpdate(User user) {
        em.getTransaction().begin();

        if (user.isNew()) {
            em.persist(user);
        } else {
            em.merge(user);
        }

        em.getTransaction().commit();
    }

    public void delete(long id) {
        User user = em.getReference(User.class, id);

        em.getTransaction().begin();

        if (Objects.nonNull(user)) {
            em.remove(user);
        }

        em.getTransaction().commit();
    }
}