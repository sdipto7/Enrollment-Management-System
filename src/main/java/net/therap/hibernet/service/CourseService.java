package net.therap.hibernet.service;

import net.therap.hibernet.dao.CourseDao;
import net.therap.hibernet.domain.Course;

import java.util.List;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class CourseService {

    private CourseDao courseDao;

    public CourseService() {
        courseDao = new CourseDao();
    }

    public List<Course> getCourses() {
        return courseDao.getAll();
    }

    public void addCourse(String courseCode, String courseTitle) {
        courseDao.add(courseCode, courseTitle);
    }

    public void updateCourse(String courseCode, String newCourseTitle) {
        courseDao.update(courseCode, newCourseTitle);
    }

    public void deleteCourse(String courseCode) {
        courseDao.delete(courseCode);
    }
}
