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

    public List<Course> findAll() {
        return courseDao.findAll();
    }

    public Course find(long id) {
        return courseDao.find(id);
    }

    public void saveOrUpdate(Course course) {
        courseDao.saveOrUpdate(course);
    }

    public void delete(long id) {
        courseDao.delete(id);
    }
}