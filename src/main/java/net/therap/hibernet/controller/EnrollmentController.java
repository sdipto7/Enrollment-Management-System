package net.therap.hibernet.controller;

import net.therap.hibernet.domain.Course;
import net.therap.hibernet.domain.Enrollment;
import net.therap.hibernet.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author rumi.dipto
 * @since 8/24/21
 */
public class EnrollmentController {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Enrollment enrollment = entityManager.find(Enrollment.class, 2);
        System.out.println(enrollment.getCourse());
    }
}
