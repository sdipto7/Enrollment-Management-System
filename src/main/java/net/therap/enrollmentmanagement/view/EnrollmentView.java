package net.therap.enrollmentmanagement.view;

import net.therap.enrollmentmanagement.domain.Course;
import net.therap.enrollmentmanagement.domain.Enrollment;
import net.therap.enrollmentmanagement.domain.User;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author rumi.dipto
 * @since 8/26/21
 */
public class EnrollmentView {

    public static void printEnrollment(Enrollment enrollment) {
        System.out.println("Enrollment id: " + enrollment.getId());
        UserView.printUser(enrollment.getUser());
        CourseView.printCourse(enrollment.getCourse());
    }

    public static void printEnrollmentList(List<Enrollment> enrollmentList) {
        Collections.sort(enrollmentList);
        User userBuffer = null;

        for (Enrollment enrollment : enrollmentList) {
            Course course = enrollment.getCourse();
            if (Objects.isNull(userBuffer) || !(enrollment.getUser().equals(userBuffer))) {
                userBuffer = enrollment.getUser();
                System.out.println("User:\n" + userBuffer.getId() + " - " + userBuffer.getName());
                System.out.println("Courses:\n" + course.getId() + " - " + course.getCourseCode() + " - " +
                        course.getCourseTitle() + " (Enrollment ID: " + enrollment.getId() + ")");
            } else {
                System.out.println(course.getId() + " - " + course.getCourseCode() + " - " +
                        course.getCourseTitle() + " (Enrollment ID: " + enrollment.getId() + ")");
            }
        }
    }
}