package net.therap.hibernet.service;

import net.therap.hibernet.dao.CourseDao;
import net.therap.hibernet.domain.Course;

import javax.persistence.Query;
import java.util.List;

import static net.therap.hibernet.util.EntityManagerConfiguration.entityManager;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class CourseService {

    private CourseDao courseDao;

    public CourseService() {
        courseDao = new CourseDao();
    }

    public List<Course> getCourseList() {
        Query query = entityManager.createQuery("from Course");

        return courseDao.getAll(query);
    }

    public Course getCourse(String courseCode) {
        return entityManager.find(Course.class, courseCode);
    }

    public void addCourse(String courseCode, String courseTitle) {
        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseTitle(courseTitle);

        courseDao.add(course);
    }

    public void updateCourse(String courseCode, String newCourseTitle) {
        Course course = entityManager.find(Course.class, courseCode);

        courseDao.update(course, newCourseTitle);
    }

    public void deleteCourse(String courseCode) {
        Course course = entityManager.find(Course.class, courseCode);

        courseDao.delete(course);
    }
}