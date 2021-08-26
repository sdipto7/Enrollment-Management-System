package net.therap.hibernet.dao;

import net.therap.hibernet.domain.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class CourseDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-1");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Course> getAll() {
        Query query = entityManager.createQuery("from Course");

        return query.getResultList();
    }

    public Course get(String courseCode) {
        return entityManager.find(Course.class, courseCode);
    }

    public void update(String courseCode, String newCourseTitle) {
        Course course = entityManager.find(Course.class, courseCode);

        entityManager.getTransaction().begin();

        course.setCourseTitle(newCourseTitle);

        entityManager.getTransaction().commit();
    }

    public void add(String courseCode, String courseTitle) {
        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseTitle(courseTitle);

        entityManager.getTransaction().begin();

        entityManager.persist(course);

        entityManager.getTransaction().commit();
    }

    public void delete(String courseCode) {
        Course course = entityManager.find(Course.class, courseCode);

        entityManager.getTransaction().begin();

        entityManager.remove(course);

        entityManager.getTransaction().commit();
    }
}