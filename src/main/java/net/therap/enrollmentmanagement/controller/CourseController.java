package net.therap.enrollmentmanagement.controller;

import net.therap.enrollmentmanagement.domain.Course;
import net.therap.enrollmentmanagement.helper.CourseHelper;
import net.therap.enrollmentmanagement.service.CourseService;
import net.therap.enrollmentmanagement.view.CourseView;
import net.therap.enrollmentmanagement.view.GlobalView;

import java.util.List;

import static java.util.Objects.isNull;

/**
 * @author rumi.dipto
 * @since 8/29/21
 */
public class CourseController {

    private final CourseHelper courseHelper;

    private final CourseService courseService;

    public CourseController() {
        courseHelper = new CourseHelper();
        courseService = new CourseService();
    }

    public void viewCourse() {
        long id = courseHelper.getCourseIdInput();

        Course course = courseService.find(id);
        if (isNull(course)) {
            GlobalView.printMessage("No Course exists with the given id!");
            return;
        }

        CourseView.printCourse(course);
    }

    public void viewAllCourses() {
        List<Course> courseList = courseService.findAll();
        if (courseList.size() == 0) {
            GlobalView.printMessage("Currently, there are no courses!");
            return;
        }

        CourseView.printCourseList(courseList);
    }

    public void createCourse() {
        String courseCode = courseHelper.getCourseCodeInput();
        String courseTitle = courseHelper.getCourseTitleInput();

        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseTitle(courseTitle);

        courseService.saveOrUpdate(course);
        System.out.println("The course is created successfully!");
    }

    public void updateCourse() {
        long id = courseHelper.getCourseIdInput();

        Course course = courseService.find(id);
        if (isNull(course)) {
            GlobalView.printMessage("No User exists with the given id!");
            return;
        }

        String courseCode = courseHelper.getCourseCodeInput();
        String courseTitle = courseHelper.getCourseTitleInput();

        course.setCourseCode(courseCode);
        course.setCourseTitle(courseTitle);

        courseService.saveOrUpdate(course);
        GlobalView.printMessage("The course is updated successfully!");
    }

    public void deleteCourse() {
        long courseId = courseHelper.getCourseIdInput();

        Course course = courseService.find(courseId);
        if (isNull(course)) {
            GlobalView.printMessage("No Course exists with the given id!");
            return;
        }

        courseService.delete(course);
        GlobalView.printMessage("The course is deleted successfully!");
    }
}