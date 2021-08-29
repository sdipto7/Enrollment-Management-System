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

    public CourseController(){
        courseService = new CourseService();
    }

    public void viewAllCourses(){
        List<Course> courseList = courseService.getCourseList();
        EnrollmentView.printCourseList(courseList);
    }

    public void addCourse(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter new course code: ");
        String courseCode = input.nextLine();

        System.out.println("Enter new course title: ");
        String courseTitle = input.nextLine();

        courseService.addCourse(courseCode, courseTitle);
    }

    public void updateCourse(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the id of the course: ");
        long courseId = input.nextLong();

        System.out.println("Enter the new course code: ");
        String newCourseCode = input.nextLine();
        input.nextLine();

        System.out.println("Enter the new course title: ");
        String newCourseTitle = input.nextLine();

        courseService.updateCourse(courseId, newCourseCode, newCourseTitle);
    }

    public void viewCourse(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the course code: ");
        Long courseId = input.nextLong();

        Course course = courseService.getCourse(courseId);

        EnrollmentView.printCourse(course);
    }

    public void deleteCourse(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the course code: ");
        long courseId = input.nextLong();

        courseService.deleteCourse(courseId);
    }
}