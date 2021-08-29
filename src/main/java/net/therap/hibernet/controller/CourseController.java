package net.therap.hibernet.controller;

import net.therap.hibernet.View.EnrollmentView;
import net.therap.hibernet.domain.Course;
import net.therap.hibernet.service.CourseService;

import java.util.List;
import java.util.Scanner;

/**
 * @author rumi.dipto
 * @since 8/29/21
 */
public class CourseController {

    private CourseService courseService;

    public CourseController() {
        courseService = new CourseService();
    }

    public void viewAllCourses() {
        List<Course> courseList = courseService.findAll();
        EnrollmentView.printCourseList(courseList);
    }

    public void addCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new course code: ");
        String courseCode = input.nextLine();

        System.out.println("Enter new course title: ");
        String courseTitle = input.nextLine();

        courseService.save(courseCode, courseTitle);
        input.close();
    }

    public void updateCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of the course: ");
        long courseId = input.nextLong();
        input.nextLine();

        System.out.println("Enter the new course code: ");
        String newCourseCode = input.nextLine();

        System.out.println("Enter the new course title: ");
        String newCourseTitle = input.nextLine();

        courseService.update(courseId, newCourseCode, newCourseTitle);
        input.close();
    }

    public void viewCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the course code: ");
        long courseId = input.nextLong();

        Course course = courseService.findCourseById(courseId);

        EnrollmentView.printCourse(course);
        input.close();
    }

    public void deleteCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the course code: ");
        long courseId = input.nextLong();

        courseService.delete(courseId);
        input.close();
    }
}