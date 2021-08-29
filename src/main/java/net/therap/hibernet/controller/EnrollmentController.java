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

    EnrollmentService enrollmentService = new EnrollmentService();

    public void viewAllEnrollments(){
        List<Enrollment> enrollmentList = enrollmentService.getEnrollmentList();
        EnrollmentView.printEnrollmentList(enrollmentList);
    }

    public void addEnrollment(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter user id");
        long userId = input.nextLong();
        input.nextLine();

        System.out.println("Enter course code");
        long courseId = input.nextLong();
        input.nextLine();

        enrollmentService.addEnrollment(userId, courseId);
        input.close();
    }

    public void updateEnrollment(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of enrollment: ");
        long enrollmentId = input.nextLong();

        System.out.println("Enter the new user id: ");
        long newUserId = input.nextLong();

        System.out.println("Enter the new course id: ");
        long newCourseId = input.nextLong();

        enrollmentService.updateEnrollment(enrollmentId, newUserId, newCourseId);
        input.close();
    }

    public void viewEnrollment(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the enrollment id: ");
        long enrollmentId = input.nextLong();

        Enrollment enrollment = enrollmentService.getEnrollment(enrollmentId);

        EnrollmentView.printEnrollment(enrollment);
        input.close();
    }

    public void deleteEnrollment(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the enrollment id: ");
        long enrollmentId = input.nextLong();

        enrollmentService.deleteEnrollment(enrollmentId);
        input.close();
    }
}
