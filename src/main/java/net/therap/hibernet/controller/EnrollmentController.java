package net.therap.hibernet.controller;

import net.therap.hibernet.View.EnrollmentView;
import net.therap.hibernet.domain.Course;
import net.therap.hibernet.domain.Enrollment;
import net.therap.hibernet.domain.User;
import net.therap.hibernet.service.CourseService;
import net.therap.hibernet.service.EnrollmentService;
import net.therap.hibernet.service.UserService;

import java.util.List;
import java.util.Scanner;

/**
 * @author rumi.dipto
 * @since 8/24/21
 */
public class EnrollmentController {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Press 0 to exit");
            System.out.println("Press 1 to view courses");
            System.out.println("Press 2 to view trainees");
            System.out.println("Press 3 to view course enrollment details");
            System.out.println("Press 4 to add a new course");
            System.out.println("Press 5 to add a new user");
            System.out.println("Press 6 to add a new enrollment");
            System.out.println("Press 7 to update a course information");
            System.out.println("Press 8 to update an user information");
            System.out.println("Press 9 to update an enrollment information");
            System.out.println("Press 10 to delete a course information");
            System.out.println("Press 11 to delete an user information");
            System.out.println("Press 12 to delete an enrollment information");

            int operation = input.nextInt();
            if (operation == 0) {
                break;
            }
            executeOperation(operation);
            System.out.println("\n===========\n");
        }
        input.close();
    }

    public static void executeOperation(int operation) {
        EnrollmentService enrollmentService = new EnrollmentService();

        CourseService courseService = new CourseService();

        UserService userService = new UserService();

        String courseCode;

        int id;

        Scanner input = new Scanner(System.in);

        switch (operation) {
            case 1:
                List<Course> courseList = courseService.getCourses();
                EnrollmentView.printCourseInformation(courseList);
                break;

            case 2:
                List<User> userList = userService.getUsers();
                EnrollmentView.printUserInformation(userList);
                break;

            case 3:
                List<Enrollment> enrollmentList = enrollmentService.getEnrollments();
                EnrollmentView.printEnrollmentInformation(enrollmentList);
                break;

            case 4:
                System.out.println("Enter new course code: ");
                courseCode = input.next();
                System.out.println("Enter new course title: ");
                String courseTitle = input.nextLine();
                courseService.addCourse(courseCode, courseTitle);

            case 5:
                System.out.println("Enter new user's id: ");
                id = input.nextInt();
                System.out.println("Enter new user's name: ");
                String name = input.nextLine();
                userService.addUser(id, name);

            case 6:
                System.out.println("Enter user id");
                int userId = input.nextInt();
                System.out.println("Enter course code");
                courseCode = input.next();
                enrollmentService.addEnrollment(userId, courseCode);
                break;

            case 7:
                System.out.println("Enter the course code: ");
                courseCode = input.next();
                System.out.println("Enter the new title: ");
                String newCourseTitle = input.nextLine();
                courseService.updateCourse(courseCode, newCourseTitle);

            case 8:
                System.out.println("Enter the user id: ");
                id = input.nextInt();
                System.out.println("Enter new name: ");
                String newName = input.nextLine();
                userService.updateUser(id, newName);

            case 9:
                System.out.println("Enter the id of enrollment: ");
                int enrollmentId = input.nextInt();
                System.out.println("Enter the new user id: ");
                int newUserId = input.nextInt();
                System.out.println("Enter the new course code: ");
                String newCourseCode = input.nextLine();
                enrollmentService.updateEnrollment(enrollmentId, newUserId, newCourseCode);

            case 10:
                System.out.println("Enter the course code: ");
                courseCode = input.next();
                courseService.deleteCourse(courseCode);

            case 11:
                System.out.println("Enter the user's id: ");
                id = input.nextInt();
                userService.deleteUser(id);

            case 12:
                System.out.println("Enter the enrollment id: ");
                id = input.nextInt();
                enrollmentService.deleteEnrollment(id);

            default:
                System.out.println("Wrong input! Please enter a valid input");
                break;
        }
    }
}
