package net.therap.hibernet.controller;

import net.therap.hibernet.View.EnrollmentView;
import net.therap.hibernet.domain.Course;
import net.therap.hibernet.service.CourseService;
import net.therap.hibernet.validator.EnrollmentValidator;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

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

        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseTitle(courseTitle);

        Set<ConstraintViolation<Course>> errors = EnrollmentValidator.validate(course);
        for (ConstraintViolation<Course> error : errors) {
            System.out.println(error.getMessage());
        }

        courseService.saveOrUpdate(course);
        System.out.println("The course information is added successfully!");
    }

    public void updateCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of the course: ");
        long courseId = input.nextLong();
        input.nextLine();

        System.out.println("Enter the new course code: ");
        String courseCode = input.nextLine();

        System.out.println("Enter the new course title: ");
        String courseTitle = input.nextLine();

        Course course = courseService.find(courseId);
        if (Objects.isNull(course)) {
            course = new Course();
        }
        course.setCourseCode(courseCode);
        course.setCourseTitle(courseTitle);

        Set<ConstraintViolation<Course>> errors = EnrollmentValidator.validate(course);
        for (ConstraintViolation<Course> error : errors) {
            System.out.println(error.getMessage());
        }

        courseService.saveOrUpdate(course);
        System.out.println("The course information is updated successfully!");
    }

    public void viewCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the course id: ");
        long courseId = input.nextLong();

        Course course = courseService.find(courseId);

        EnrollmentView.printCourse(course);
    }

    public void deleteCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the course id: ");
        long courseId = input.nextLong();

        courseService.delete(courseId);
        System.out.println("The course information is delete successfully!");
    }
}