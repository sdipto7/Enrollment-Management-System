package net.therap.hibernet.dao;

import net.therap.hibernet.domain.Enrollment;
import net.therap.hibernet.util.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class EnrollmentDao {

    EntityManager entityManager;

    public EnrollmentDao() {
        entityManager = EntityManagerSingleton.getInstance().getEntityManager();
    }

    public List<Enrollment> findAll() {
        Query query = entityManager.createQuery("from Enrollment");

        return query.getResultList();
    }

    public Enrollment find(long id) {
        return entityManager.find(Enrollment.class, id);
    }

    public void saveOrUpdate(Enrollment enrollment) {
        entityManager.getTransaction().begin();

        if (enrollment.isNew()) {
            entityManager.persist(enrollment);
        } else {
            entityManager.merge(enrollment);
        }
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public void delete(long id) {
        Enrollment enrollment = entityManager.getReference(Enrollment.class, id);

        entityManager.getTransaction().begin();
        if (Objects.nonNull(enrollment)) {
            entityManager.remove(enrollment);
        }
        entityManager.flush();
        entityManager.getTransaction().commit();
    }
}