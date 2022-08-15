package net.therap.enrollmentmanagement.dao;

import net.therap.enrollmentmanagement.domain.Course;
import net.therap.enrollmentmanagement.util.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class CourseDao {

    private EntityManager em;

    public CourseDao() {
        em = EntityManagerSingleton.getInstance().getEntityManager();
    }

    public List<Course> findAll() {
        Query query = em.createQuery("FROM Course");

        return query.getResultList();
    }

    public Course find(long id) {
        return em.find(Course.class, id);
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

    public void delete(long id) {
        Course course = em.getReference(Course.class, id);

        em.getTransaction().begin();

        if (Objects.nonNull(course)) {
            em.remove(course);
        }

        em.getTransaction().commit();
    }
}