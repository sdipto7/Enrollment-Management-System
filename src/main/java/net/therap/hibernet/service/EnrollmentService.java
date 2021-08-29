package net.therap.hibernet.service;

import net.therap.hibernet.dao.EnrollmentDao;
import net.therap.hibernet.domain.Course;
import net.therap.hibernet.domain.Enrollment;
import net.therap.hibernet.domain.User;
import net.therap.hibernet.util.EntityManagerConfiguration;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author rumi.dipto
 * @since 8/25/21
 */
public class EnrollmentService {

    EntityManager entityManager = EntityManagerConfiguration.getInstance().getEntityManager();

    private EnrollmentDao enrollmentDao;

    public EnrollmentService() {
        enrollmentDao = new EnrollmentDao();
    }

    public List<Enrollment> findAll() {
        return enrollmentDao.findAll();
    }

    public Enrollment findById(long id) {
        return enrollmentDao.findById(id);
    }

    public void save(Enrollment enrollment, long userId, long courseId) {
        enrollmentDao.save(enrollment, userId, courseId);
    }

    public void update(long id, long userId, long courseCode) {
        Enrollment enrollment = entityManager.find(Enrollment.class, id);

        User user = entityManager.find(User.class, userId);

        Course course = entityManager.find(Course.class, courseCode);

        enrollmentDao.update(enrollment, user, course);
    }

    public void delete(long id) {
        enrollmentDao.delete(id);
    }
}