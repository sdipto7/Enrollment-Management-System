package net.therap.hibernet.service;

import net.therap.hibernet.dao.EnrollmentDao;
import net.therap.hibernet.domain.Enrollment;

import java.util.List;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class EnrollmentService {

    private EnrollmentDao enrollmentDao;

    public EnrollmentService() {
        enrollmentDao = new EnrollmentDao();
    }

    public List<Enrollment> getEnrollments() {
        return enrollmentDao.getAll();
    }

    public void addEnrollment(int userId, String courseCode) {
        enrollmentDao.add(userId, courseCode);
    }

    public void updateEnrollment(int id, int userId, String courseCode) {
        enrollmentDao.update(id, userId, courseCode);
    }

    public void deleteEnrollment(int id) {
        enrollmentDao.delete(id);
    }

}
