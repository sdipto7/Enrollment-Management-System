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

    public List<Enrollment> findAll() {
        return enrollmentDao.findAll();
    }

    public Enrollment find(long id) {
        return enrollmentDao.find(id);
    }

    public void saveOrUpdate(Enrollment enrollment) {
        enrollmentDao.saveOrUpdate(enrollment);
    }

    public void delete(long id) {
        enrollmentDao.delete(id);
    }
}