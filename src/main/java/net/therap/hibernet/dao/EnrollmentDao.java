package net.therap.hibernet.dao;

import net.therap.hibernet.domain.Course;
import net.therap.hibernet.domain.Enrollment;
import net.therap.hibernet.domain.User;

import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

import static net.therap.hibernet.util.EntityManagerConfiguration.entityManager;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class EnrollmentDao {

    public List<Enrollment> getAll(Query query) {
        return query.getResultList();
    }

    public void add(Enrollment enrollment) {
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
        entityManager.flush();
    }
}