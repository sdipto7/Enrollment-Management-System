package net.therap.enrollmentmanagement.dao;

import net.therap.enrollmentmanagement.domain.Course;
import net.therap.enrollmentmanagement.util.EntityManagerSingleton;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class CourseDao {

    private EntityManager em;

    public CourseDao() {
        em = EntityManagerSingleton.getInstance().getEntityManager();
    }

    public Course find(long id) {
        Optional<Course> course = Optional.ofNullable(em.find(Course.class, id));

        return course.isPresent() ? course.get() : null;
    }

    public List<Course> findAll() {
        return em.createQuery("FROM Course", Course.class)
                .getResultList();
    }

    public void saveOrUpdate(Course course) {
        em.getTransaction().begin();

        if (course.isNew()) {
            em.persist(course);
        } else {
            em.merge(course);
        }

        em.getTransaction().commit();
    }

    public void delete(Course course) {
        em.getTransaction().begin();

        em.remove(course);

        em.getTransaction().commit();
    }
}