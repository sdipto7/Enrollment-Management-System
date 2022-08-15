package net.therap.enrollmentmanagement.controller;

import java.util.Scanner;

/**
 * @author rumi.dipto
 * @since 8/24/21
 */
public class HomeController {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Press 0 to exit");
            System.out.println("Press 1 to view courses");
            System.out.println("Press 2 to view users");
            System.out.println("Press 3 to view course enrollment details");
            System.out.println("Press 4 to add a new course");
            System.out.println("Press 5 to add a new user");
            System.out.println("Press 6 to add a new enrollment");
            System.out.println("Press 7 to update a course information");
            System.out.println("Press 8 to update an user information");
            System.out.println("Press 9 to update an enrollment information");
            System.out.println("Press 10 to view a specific course information");
            System.out.println("Press 11 to view a specific user information");
            System.out.println("Press 12 to view a specific enrollment information");
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
        EnrollmentController enrollmentController = new EnrollmentController();

        CourseController courseController = new CourseController();

        UserController userController = new UserController();

        switch (operation) {
            case 1:
                courseController.viewAllCourses();
                break;

            case 2:
                userController.viewAllUsers();
                break;

            case 3:
                enrollmentController.viewAllEnrollments();
                break;

            case 4:
                courseController.addCourse();
                break;

            case 5:
                userController.addUser();
                break;

            case 6:
                enrollmentController.addEnrollment();
                break;

            case 7:
                courseController.updateCourse();
                break;

            case 8:
                userController.updateUser();
                break;

            case 9:
                enrollmentController.updateEnrollment();
                break;

            case 10:
                courseController.viewCourse();
                break;

            case 11:
                userController.viewUser();
                break;

            case 12:
                enrollmentController.viewEnrollment();
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