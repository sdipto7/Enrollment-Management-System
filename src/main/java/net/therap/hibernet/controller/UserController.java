package net.therap.hibernet.controller;

import net.therap.hibernet.View.EnrollmentView;
import net.therap.hibernet.domain.User;
import net.therap.hibernet.service.UserService;
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
        long id = input.nextLong();
        input.nextLine();

        System.out.println("Enter new user's name: ");
        String name = input.nextLine();

        User user = new User();
        user.setId(id);
        user.setName(name);

        Set<ConstraintViolation<User>> errors = EnrollmentValidator.validate(user);
        for (ConstraintViolation<User> error : errors) {
            System.out.println(error.getMessage());
        }

        userService.saveOrUpdate(user);
        System.out.println("The user information is added successfully!");
    }

    public void updateUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the user id: ");
        long userId = input.nextLong();
        input.nextLine();

        System.out.println("Enter new name: ");
        String name = input.nextLine();

        User user = userService.find(userId);
        if (Objects.isNull(user)) {
            user = new User();
            user.setIsNew(true);
            user.setId(userId);
        }
        user.setName(name);

        Set<ConstraintViolation<User>> errors = EnrollmentValidator.validate(user);
        for (ConstraintViolation<User> error : errors) {
            System.out.println(error.getMessage());
        }

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
