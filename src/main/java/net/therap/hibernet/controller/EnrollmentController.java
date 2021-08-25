package net.therap.hibernet.controller;

import net.therap.hibernet.domain.Course;
import net.therap.hibernet.domain.Trainee;

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

        Trainee trainee = entityManager.find(Trainee.class, 102);
        System.out.println(trainee);

        Course course = entityManager.find(Course.class, "CS204");
        System.out.println(course);
    }
}
