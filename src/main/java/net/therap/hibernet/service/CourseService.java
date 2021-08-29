package net.therap.hibernet.service;

import net.therap.hibernet.dao.CourseDao;
import net.therap.hibernet.domain.Course;
import net.therap.hibernet.util.EntityManagerConfiguration;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class CourseService {

    EntityManager entityManager = EntityManagerConfiguration.getInstance().getEntityManager();

    private CourseDao courseDao;

    public CourseService() {
        courseDao = new CourseDao();
    }

    public List<Course> getCourseList() {
        return courseDao.findAll();
    }

    public Course getCourse(long id) {
        return entityManager.find(Course.class, id);
    }

    public void addCourse(String courseCode, String courseTitle) {
        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseTitle(courseTitle);

        courseDao.add(course);
    }

    public void updateCourse(long id, String newCourseCode, String newCourseTitle) {
        Course course = entityManager.find(Course.class, id);

        courseDao.update(course, newCourseCode, newCourseTitle);
    }

    public void deleteCourse(long id) {
        courseDao.delete(id);
    }
}