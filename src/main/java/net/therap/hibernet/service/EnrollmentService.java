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

    public Enrollment getEnrollment(int id) {
        return entityManager.find(Enrollment.class, id);
    }

    public void addEnrollment(int userId, String courseCode) {
        User user = entityManager.find(User.class, userId);

        Course course = entityManager.find(Course.class, courseCode);

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);

        enrollmentDao.add(enrollment);
    }

    public void updateEnrollment(int id, int userId, String courseCode) {
        Enrollment enrollment = entityManager.find(Enrollment.class, id);

        User user = entityManager.find(User.class, userId);

        Course course = entityManager.find(Course.class, courseCode);

        enrollmentDao.update(enrollment, user, course);
    }

    public void deleteEnrollment(int id) {
        Enrollment enrollment = entityManager.find(Enrollment.class, id);

        enrollmentDao.delete(enrollment);
    }
}