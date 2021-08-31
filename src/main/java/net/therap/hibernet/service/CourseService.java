package net.therap.hibernet.service;

import net.therap.hibernet.dao.CourseDao;
import net.therap.hibernet.domain.Course;
import net.therap.hibernet.util.EntityManagerSingleton;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class CourseService {

    EntityManager entityManager;

    private CourseDao courseDao;

    public CourseService() {
        entityManager = EntityManagerSingleton.getInstance().getEntityManager();

        courseDao = new CourseDao();
    }

    public List<Course> findAll() {
        return courseDao.findAll();
    }

    public Course find(long id) {
        return courseDao.find(id);
    }

//    public void save(Course course) {
//        courseDao.save(course);
//    }

    public void saveOrUpdate(Course course) {
        courseDao.saveOrUpdate(course);
    }

//    public void update(long id, String newCourseCode, String newCourseTitle) {
//        Course course = entityManager.find(Course.class, id);
//
//        courseDao.update(course, newCourseCode, newCourseTitle);
//    }

    public void delete(long id) {
        courseDao.delete(id);
    }
}