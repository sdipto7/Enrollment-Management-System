package net.therap.enrollmentmanagement.controller;

import net.therap.enrollmentmanagement.domain.Course;
import net.therap.enrollmentmanagement.domain.Enrollment;
import net.therap.enrollmentmanagement.domain.User;
import net.therap.enrollmentmanagement.helper.CourseHelper;
import net.therap.enrollmentmanagement.helper.EnrollmentHelper;
import net.therap.enrollmentmanagement.helper.UserHelper;
import net.therap.enrollmentmanagement.service.CourseService;
import net.therap.enrollmentmanagement.service.EnrollmentService;
import net.therap.enrollmentmanagement.service.UserService;
import net.therap.enrollmentmanagement.view.EnrollmentView;
import net.therap.enrollmentmanagement.view.GlobalView;

import java.util.List;

import static java.util.Objects.isNull;

/**
 * @author rumi.dipto
 * @since 8/29/21
 */
public class EnrollmentController {

    private final EnrollmentHelper enrollmentHelper;

    private final EnrollmentService enrollmentService;

    private final UserHelper userHelper;

    private final UserService userService;

    private final CourseHelper courseHelper;

    private final CourseService courseService;

    public EnrollmentController() {
        enrollmentHelper = new EnrollmentHelper();
        enrollmentService = new EnrollmentService();
        userHelper = new UserHelper();
        userService = new UserService();
        courseHelper = new CourseHelper();
        courseService = new CourseService();
    }

    public void viewEnrollment() {
        long id = enrollmentHelper.getEnrollmentIdInput();

        Enrollment enrollment = enrollmentService.find(id);
        if (isNull(enrollment)) {
            GlobalView.printMessage("No Enrollment exists with the given id!");
            return;
        }

        EnrollmentView.printEnrollment(enrollment);
    }

    public void viewAllEnrollments() {
        List<Enrollment> enrollmentList = enrollmentService.findAll();
        if (enrollmentList.size() == 0) {
            GlobalView.printMessage("Currently, there are no enrollments!");
            return;
        }

        EnrollmentView.printEnrollmentList(enrollmentList);
    }

    public void createEnrollment() {
        long userId = userHelper.getUserIdInput();

        User user = userService.find(userId);
        if (isNull(user)) {
            GlobalView.printMessage("No User exists with the given user id!");
            return;
        }

        long courseId = courseHelper.getCourseIdInput();

        Course course = courseService.find(courseId);
        if (isNull(course)) {
            GlobalView.printMessage("No Course exists with the given course id!");
            return;
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);

        enrollmentService.saveOrUpdate(enrollment);
        GlobalView.printMessage("The enrollment is created successfully!");
    }

    public void updateEnrollment() {
        long id = enrollmentHelper.getEnrollmentIdInput();

        Enrollment enrollment = enrollmentService.find(id);
        if (isNull(enrollment)) {
            GlobalView.printMessage("No Enrollment exists with the given enrollment id!");
            return;
        }

        long userId = userHelper.getUserIdInput();

        User user = userService.find(userId);
        if (isNull(user)) {
            GlobalView.printMessage("No User exists with the given user id!");
            return;
        }

        long courseId = courseHelper.getCourseIdInput();

        Course course = courseService.find(courseId);
        if (isNull(course)) {
            GlobalView.printMessage("No Course exists with the given course id!");
            return;
        }

        enrollment.setUser(user);
        enrollment.setCourse(course);

        enrollmentService.saveOrUpdate(enrollment);
        GlobalView.printMessage("The enrollment is updated successfully!");
    }

    public void deleteEnrollment() {
        long id = enrollmentHelper.getEnrollmentIdInput();

        Enrollment enrollment = enrollmentService.find(id);
        if (isNull(enrollment)) {
            GlobalView.printMessage("No Enrollment exists with the given id!");
            return;
        }

        enrollmentService.delete(enrollment);
        GlobalView.printMessage("The enrollment is deleted successfully!");
    }
}
