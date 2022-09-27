package net.therap.enrollmentmanagement.dao;

import net.therap.enrollmentmanagement.domain.Enrollment;
import net.therap.enrollmentmanagement.util.EntityManagerSingleton;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class EnrollmentDao {

    private EntityManager em;

    public EnrollmentDao() {
        em = EntityManagerSingleton.getInstance().getEntityManager();
    }

    public Enrollment find(long id) {
        Optional<Enrollment> enrollment = Optional.ofNullable(em.find(Enrollment.class, id));

        return enrollment.isPresent() ? enrollment.get() : null;
    }

    public List<Enrollment> findAll() {
        return em.createQuery("FROM Enrollment", Enrollment.class)
                .getResultList();
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

    public void delete(Enrollment enrollment) {
        em.getTransaction().begin();

        em.remove(enrollment);

        em.getTransaction().commit();
    }
}