package net.therap.hibernet.service;

import net.therap.hibernet.dao.EnrollmentDao;
import net.therap.hibernet.domain.Course;
import net.therap.hibernet.domain.Enrollment;
import net.therap.hibernet.domain.User;

import javax.persistence.Query;
import java.util.List;

import static net.therap.hibernet.util.EntityManagerConfiguration.entityManager;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class EnrollmentService {

    private EnrollmentDao enrollmentDao;

    public EnrollmentService() {
        enrollmentDao = new EnrollmentDao();
    }

    public List<Enrollment> getEnrollmentList() {
        Query query = entityManager.createQuery("from Enrollment");

        return enrollmentDao.getAll(query);
    }

    public Enrollment getEnrollment(long id) {
        return entityManager.find(Enrollment.class, id);
    }

    public void addEnrollment(long userId, long course_id) {
        User user = entityManager.find(User.class, userId);

        Course course = entityManager.find(Course.class, course_id);

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);

        enrollmentDao.add(enrollment);
    }

    public void updateEnrollment(long id, long userId, long courseCode) {
        Enrollment enrollment = entityManager.find(Enrollment.class, id);

        User user = entityManager.find(User.class, userId);

        Course course = entityManager.find(Course.class, courseCode);

        enrollmentDao.update(enrollment, user, course);
    }

    public void deleteEnrollment(long id) {
        enrollmentDao.delete(id);
    }
}