package net.therap.enrollmentmanagement.dao;

import net.therap.enrollmentmanagement.domain.User;
import net.therap.enrollmentmanagement.util.EntityManagerSingleton;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class UserDao {

    private EntityManager em;

    public UserDao() {
        em = EntityManagerSingleton.getInstance().getEntityManager();
    }

    public User find(long id) {
        Optional<User> user = Optional.ofNullable(em.find(User.class, id));

        return user.isPresent() ? user.get() : null;
    }

    public List<User> findAll() {
        return em.createQuery("FROM User", User.class)
                .getResultList();
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

    public void delete(User user) {
        em.getTransaction().begin();

        em.remove(user);

        em.getTransaction().commit();
    }
}