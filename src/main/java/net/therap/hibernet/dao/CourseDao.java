package net.therap.hibernet.dao;

import net.therap.hibernet.domain.Course;

import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

import static net.therap.hibernet.util.EntityManagerConfiguration.entityManager;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class CourseDao {

    public List<Course> findAll() {
        Query query = entityManager.createQuery("from Course");

        return query.getResultList();
    }

    public void update(Course course, String newCourseCode, String newCourseTitle) {
        entityManager.getTransaction().begin();

        course.setCourseCode(newCourseCode);
        course.setCourseTitle(newCourseTitle);

        entityManager.getTransaction().commit();
    }

    public void add(Course course) {
        entityManager.getTransaction().begin();

        entityManager.persist(course);

        entityManager.getTransaction().commit();
    }

    public void delete(long id) {
        Course course = entityManager.getReference(Course.class, id);

        entityManager.getTransaction().begin();
        if (Objects.nonNull(course)) {
            entityManager.remove(course);
        }
        entityManager.getTransaction().commit();
        entityManager.flush();
    }
}