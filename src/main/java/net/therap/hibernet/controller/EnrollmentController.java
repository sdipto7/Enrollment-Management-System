package net.therap.hibernet.controller;

import net.therap.hibernet.View.EnrollmentView;
import net.therap.hibernet.domain.Enrollment;
import net.therap.hibernet.service.EnrollmentService;

import java.util.List;
import java.util.Scanner;

/**
 * @author rumi.dipto
 * @since 8/29/21
 */
public class EnrollmentController {

    EnrollmentService enrollmentService;

    public EnrollmentController() {
        enrollmentService = new EnrollmentService();
    }

    public void viewAllEnrollments() {
        List<Enrollment> enrollmentList = enrollmentService.findAll();
        EnrollmentView.printEnrollmentList(enrollmentList);
    }

    public void addEnrollment() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter user id");
        long userId = input.nextLong();
        input.nextLine();

        System.out.println("Enter course id");
        long courseId = input.nextLong();
        input.nextLine();

        Enrollment enrollment = new Enrollment();


        enrollmentService.save(enrollment, userId, courseId);
        input.close();
    }

    public void updateEnrollment() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of enrollment: ");
        long enrollmentId = input.nextLong();

        System.out.println("Enter the new user id: ");
        long newUserId = input.nextLong();

        System.out.println("Enter the new course id: ");
        long newCourseId = input.nextLong();

        enrollmentService.update(enrollmentId, newUserId, newCourseId);
        input.close();
    }

    public void viewEnrollment() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the enrollment id: ");
        long enrollmentId = input.nextLong();

        Enrollment enrollment = enrollmentService.find(enrollmentId);

        EnrollmentView.printEnrollment(enrollment);
        input.close();
    }

    public void deleteEnrollment() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the enrollment id: ");
        long enrollmentId = input.nextLong();

        enrollmentService.delete(enrollmentId);
        input.close();
    }
}
