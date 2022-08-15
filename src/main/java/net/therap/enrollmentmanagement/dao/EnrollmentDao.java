package net.therap.enrollmentmanagement.dao;

import net.therap.enrollmentmanagement.domain.Enrollment;
import net.therap.enrollmentmanagement.util.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class EnrollmentDao {

    private EntityManager em;

    public EnrollmentDao() {
        em = EntityManagerSingleton.getInstance().getEntityManager();
    }

    public List<Enrollment> findAll() {
        Query query = em.createQuery("FROM Enrollment");

        return query.getResultList();
    }

    public Enrollment find(long id) {
        return em.find(Enrollment.class, id);
    }

    public void saveOrUpdate(Enrollment enrollment) {
        em.getTransaction().begin();

        if (enrollment.isNew()) {
            em.persist(enrollment);
        } else {
            em.merge(enrollment);
        }

        em.getTransaction().commit();
    }

    public void delete(long id) {
        Enrollment enrollment = em.getReference(Enrollment.class, id);

        em.getTransaction().begin();

        if (Objects.nonNull(enrollment)) {
            em.remove(enrollment);
        }

        em.getTransaction().commit();
    }
}