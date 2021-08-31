package net.therap.hibernet.dao;

import net.therap.hibernet.domain.Course;
import net.therap.hibernet.util.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class CourseDao {

    EntityManager entityManager;

    public CourseDao() {
        entityManager = EntityManagerSingleton.getInstance().getEntityManager();
    }

    public List<Course> findAll() {
        Query query = entityManager.createQuery("from Course");

        return query.getResultList();
    }

    public Course find(long id) {
        return entityManager.find(Course.class, id);
    }

    public void update(Course course, String newCourseCode, String newCourseTitle) {
        entityManager.getTransaction().begin();

        course.setCourseCode(newCourseCode);
        course.setCourseTitle(newCourseTitle);

        entityManager.getTransaction().commit();
    }

    public void save(Course course) {
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
    }
}