package net.therap.enrollmentmanagement.controller;

import net.therap.enrollmentmanagement.view.EnrollmentView;
import net.therap.enrollmentmanagement.domain.User;
import net.therap.enrollmentmanagement.service.UserService;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author rumi.dipto
 * @since 8/29/21
 */
public class UserController {

    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public void viewAllUsers() {
        List<User> userList = userService.findAll();
        EnrollmentView.printUserList(userList);
    }

    public void addUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new user's name: ");
        String name = input.nextLine();

        User user = new User();
        user.setName(name);

        userService.saveOrUpdate(user);
        System.out.println("The user information is added successfully!");
    }

    public void updateUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the user id: ");
        long userId = input.nextLong();
        input.nextLine();

        User user = userService.find(userId);
        if (Objects.isNull(user)) {
            System.out.println("The user does not exist");
            return;
        }

        System.out.println("Enter new name: ");
        String name = input.nextLine();

        user.setName(name);

        userService.saveOrUpdate(user);
        System.out.println("The user information is updated successfully!");
    }

    public void viewUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the user's id: ");
        long userId = input.nextLong();

        User user = userService.find(userId);

        EnrollmentView.printUser(user);
    }

    public void deleteUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the user's id: ");
        long userId = input.nextLong();

        userService.delete(userId);
        System.out.println("The user information is deleted successfully!");
    }
}
