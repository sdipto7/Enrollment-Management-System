package net.therap.hibernet.controller;

import net.therap.hibernet.dao.EnrollmentDao;
import net.therap.hibernet.domain.Enrollment;

import java.util.List;

/**
 * @author rumi.dipto
 * @since 8/24/21
 */
public class EnrollmentController {

    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-1");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        CourseDao courseDao = new CourseDao();
////        courseDao.add("CS206", "Introduction to Spring Framework");
////        courseDao.update("CS206", "Introduction to Spring Framework");
////        courseDao.delete("CS206");
//        List<Course> courses = courseDao.getAll();
//        for (Course course : courses){
//            System.out.println(course);
//        }

        EnrollmentDao enrollmentDao = new EnrollmentDao();
//        enrollmentDao.add(104, "CS205");
//        enrollmentDao.delete(13);
        enrollmentDao.update(14, 101, "CS204");
        List<Enrollment> enrollmentList = enrollmentDao.getAll();
        for (Enrollment enrollment : enrollmentList) {
            System.out.println(enrollment);
        }

    }
}
