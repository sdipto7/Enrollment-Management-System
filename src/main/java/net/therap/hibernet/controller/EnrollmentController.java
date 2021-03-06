package net.therap.hibernet.controller;

import net.therap.hibernet.View.EnrollmentView;
import net.therap.hibernet.domain.Enrollment;
import net.therap.hibernet.service.CourseService;
import net.therap.hibernet.service.EnrollmentService;
import net.therap.hibernet.service.UserService;
import net.therap.hibernet.validator.Validator;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * @author rumi.dipto
 * @since 8/29/21
 */
public class EnrollmentController {

    private EnrollmentService enrollmentService;
    private UserService userService;
    private CourseService courseService;

    public EnrollmentController() {
        enrollmentService = new EnrollmentService();
        userService = new UserService();
        courseService = new CourseService();
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
        enrollment.setUser(userService.find(userId));
        enrollment.setCourse(courseService.find(courseId));

        Set<ConstraintViolation<Enrollment>> errors = Validator.validate(enrollment);
        if (errors.size() > 0) {
            for (ConstraintViolation<Enrollment> error : errors) {
                System.out.println(error.getMessage());
            }
            return;
        }

        enrollmentService.saveOrUpdate(enrollment);
        System.out.println("The enrollment information is added successfully!");
    }

    public void updateEnrollment() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of enrollment: ");
        long enrollmentId = input.nextLong();

        Enrollment enrollment = enrollmentService.find(enrollmentId);
        if (Objects.isNull(enrollment)) {
            System.out.println("The enrollment id does not exist");
            return;
        }

        System.out.println("Enter the new user id: ");
        long userId = input.nextLong();

        System.out.println("Enter the new course id: ");
        long courseId = input.nextLong();

        enrollment.setUser(userService.find(userId));
        enrollment.setCourse(courseService.find(courseId));

        Set<ConstraintViolation<Enrollment>> errors = Validator.validate(enrollment);
        if (errors.size() > 0) {
            for (ConstraintViolation<Enrollment> error : errors) {
                System.out.println(error.getMessage());
            }
            return;
        }

        enrollmentService.saveOrUpdate(enrollment);
        System.out.println("The enrollment information is updated successfully!");
    }

    public void viewEnrollment() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the enrollment id: ");
        long enrollmentId = input.nextLong();

        Enrollment enrollment = enrollmentService.find(enrollmentId);

        EnrollmentView.printEnrollment(enrollment);
    }

    public void deleteEnrollment() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the enrollment id: ");
        long enrollmentId = input.nextLong();

        enrollmentService.delete(enrollmentId);
        System.out.println("The enrollment information is deleted successfully!");
    }
}
