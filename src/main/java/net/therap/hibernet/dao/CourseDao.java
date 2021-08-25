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

    public List<Course> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("from Course");

        return query.getResultList();
    }

    public Course get(String courseCode){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Course.class, courseCode);
    }

    public void update(String courseCode, String newCourseTitle) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course course = entityManager.find(Course.class, courseCode);
        entityManager.getTransaction().begin();
        course.setCourseTitle(newCourseTitle);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void add(String courseCode, String courseTitle) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseTitle(courseTitle);

        entityManager.getTransaction().begin();

        entityManager.persist(course);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public void delete(String courseCode) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course course = entityManager.find(Course.class, courseCode);
        entityManager.getTransaction().begin();

        entityManager.remove(course);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
