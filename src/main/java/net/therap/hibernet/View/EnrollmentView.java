package net.therap.hibernet.View;

import net.therap.hibernet.domain.Course;
import net.therap.hibernet.domain.Enrollment;
import net.therap.hibernet.domain.User;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author rumi.dipto
 * @since 8/26/21
 */
public class EnrollmentView {

    public static void printCourseInformation(List<Course> courseList){
        System.out.println("Courses: ");
        for (Course course : courseList) {
            System.out.println(course.getCourseCode() + " - " + course.getCourseTitle());
        }
    }

    public static void printUserInformation(List<User> userList) {
        System.out.println("Users: ");
        for (User trainee : userList) {
            System.out.println(trainee.getId() + " - " + trainee.getName());
        }
    }

    public static void printEnrollmentInformation(List<Enrollment> enrollmentList) {
        Collections.sort(enrollmentList);
        User userBuffer = null;

        for (Enrollment enrollment : enrollmentList) {
            Course course = enrollment.getCourse();
            if (Objects.isNull(userBuffer) || !(enrollment.getUser().equals(userBuffer))) {
                userBuffer = enrollment.getUser();
                System.out.println("Trainee:\n" + userBuffer.getId() + " - " + userBuffer.getName());
                System.out.println("Courses:\n" + course.getCourseCode() + " - " + course.getCourseTitle() +
                        " (Enrollment ID: " + enrollment.getId() + ")");
            } else if (enrollment.getUser().equals(userBuffer)) {
                System.out.println(course.getCourseCode() + " - " + course.getCourseTitle() +
                        " (Enrollment ID: " + enrollment.getId() + ")");
            }
        }
    }
}
