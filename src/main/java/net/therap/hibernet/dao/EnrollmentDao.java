package net.therap.hibernet.dao;

import net.therap.hibernet.domain.Course;
import net.therap.hibernet.domain.Enrollment;
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
public class EnrollmentDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-1");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Enrollment> getAll() {
        Query query = entityManager.createQuery("from Enrollment");

        return query.getResultList();
    }

    public void add(int userId, String courseCode) {
        User user = new UserDao().get(userId);

        Course course = new CourseDao().get(courseCode);

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);

        entityManager.getTransaction().begin();

        entityManager.persist(enrollment);

        entityManager.getTransaction().commit();
    }

    public void update(int id, int userId, String courseCode) {
        User user = new UserDao().get(userId);

        Course course = new CourseDao().get(courseCode);

        Enrollment enrollment = entityManager.find(Enrollment.class, id);

        entityManager.getTransaction().begin();

        enrollment.setUser(user);
        enrollment.setCourse(course);

        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        Enrollment enrollment = entityManager.find(Enrollment.class, id);

        entityManager.getTransaction().begin();

        entityManager.remove(enrollment);

        entityManager.getTransaction().commit();
    }
}
