package net.therap.enrollmentmanagement.view;

import net.therap.enrollmentmanagement.domain.Course;

import java.util.List;

/**
 * @author rumi.dipto
 * @since 9/27/22
 */
public class CourseView {

    public static void printCourse(Course course) {
        System.out.println("Course id: " + course.getId());
        System.out.println("Course code: " + course.getCourseCode());
        System.out.println("Course title: " + course.getCourseTitle());
    }

    public static void printCourseList(List<Course> courseList) {
        System.out.println("ID \t Code \t\t Title");
        for (Course course : courseList) {
            System.out.println(course.getId() + " \t " + course.getCourseCode() + " \t "
                    + course.getCourseTitle());
        }
    }
}
