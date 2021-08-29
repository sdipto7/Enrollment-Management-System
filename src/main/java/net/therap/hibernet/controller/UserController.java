package net.therap.hibernet.controller;

import net.therap.hibernet.View.EnrollmentView;
import net.therap.hibernet.domain.User;
import net.therap.hibernet.service.UserService;

import java.util.List;
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
        System.out.println("Enter new user's id: ");
        long userId = input.nextLong();
        input.nextLine();

        System.out.println("Enter new user's name: ");
        String name = input.nextLine();

        userService.save(userId, name);
        input.close();
    }

    public void updateUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the user id: ");
        long userId = input.nextLong();
        input.nextLine();

        System.out.println("Enter new name: ");
        String newName = input.nextLine();

        userService.update(userId, newName);
        input.close();
    }

    public void viewUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the user's id: ");
        long userId = input.nextLong();

        User user = userService.findUserById(userId);

        EnrollmentView.printUser(user);
        input.close();
    }

    public void deleteUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the user's id: ");
        long userId = input.nextLong();

        userService.delete(userId);
        input.close();
    }
}
