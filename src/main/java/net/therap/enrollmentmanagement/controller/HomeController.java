package net.therap.enrollmentmanagement.controller;

import java.util.Scanner;

/**
 * @author rumi.dipto
 * @since 8/24/21
 */
public class HomeController {

    private static final UserController userController = new UserController();

    private static final CourseController courseController = new CourseController();

    private static final EnrollmentController enrollmentController = new EnrollmentController();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Press 0 to exit");
            System.out.println("Press 1 to view a specific course information");
            System.out.println("Press 2 to view a specific user information");
            System.out.println("Press 3 to view a specific enrollment information");
            System.out.println("Press 4 to view all courses");
            System.out.println("Press 5 to view all users");
            System.out.println("Press 6 to view all enrollments");
            System.out.println("Press 7 to create a new course");
            System.out.println("Press 8 to create a new user");
            System.out.println("Press 9 to create a new enrollment");
            System.out.println("Press 10 to update a course information");
            System.out.println("Press 11 to update an user information");
            System.out.println("Press 12 to update an enrollment information");
            System.out.println("Press 13 to delete a course information");
            System.out.println("Press 14 to delete an user information");
            System.out.println("Press 15 to delete an enrollment information");

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

        switch (operation) {
            case 1:
                courseController.viewCourse();
                break;

            case 2:
                userController.viewUser();
                break;

            case 3:
                enrollmentController.viewEnrollment();
                break;

            case 4:
                courseController.viewAllCourses();
                break;

            case 5:
                userController.viewAllUsers();
                break;

            case 6:
                enrollmentController.viewAllEnrollments();
                break;

            case 7:
                courseController.createCourse();
                break;

            case 8:
                userController.createUser();
                break;

            case 9:
                enrollmentController.createEnrollment();
                break;

            case 10:
                courseController.updateCourse();
                break;

            case 11:
                userController.updateUser();
                break;

            case 12:
                enrollmentController.updateEnrollment();
                break;

            case 13:
                courseController.deleteCourse();
                break;

            case 14:
                userController.deleteUser();
                break;

            case 15:
                enrollmentController.deleteEnrollment();
                break;

            default:
                System.out.println("Wrong input! Please enter a valid input");
                break;
        }
    }
}