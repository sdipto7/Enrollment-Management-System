package net.therap.hibernet.dao;

import net.therap.hibernet.domain.Course;
import net.therap.hibernet.domain.Enrollment;
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
public class EnrollmentDao {

    EntityManager entityManager = EntityManagerConfiguration.getInstance().getEntityManager();

    public List<Enrollment> findAll() {
        Query query = entityManager.createQuery("from Enrollment");

        return query.getResultList();
    }

    public Enrollment find(long id) {
        return entityManager.find(Enrollment.class, id);
    }

    public void save(Enrollment enrollment, long userId, long courseId) {
        User user = entityManager.find(User.class, userId);

        Course course = entityManager.find(Course.class, courseId);

        enrollment.setUser(user);
        enrollment.setCourse(course);

        entityManager.getTransaction().begin();

        entityManager.persist(enrollment);

        entityManager.getTransaction().commit();
    }

    public void update(Enrollment enrollment, User user, Course course) {
        entityManager.getTransaction().begin();

        enrollment.setUser(user);
        enrollment.setCourse(course);

        entityManager.getTransaction().commit();
    }

    public void delete(long id) {
        Enrollment enrollment = entityManager.find(Enrollment.class, id);

        entityManager.getTransaction().begin();
        if (Objects.nonNull(enrollment)) {
            entityManager.remove(enrollment);
        }
        entityManager.getTransaction().commit();
    }
}