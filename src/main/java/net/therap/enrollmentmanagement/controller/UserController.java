package net.therap.enrollmentmanagement.controller;

import net.therap.enrollmentmanagement.domain.User;
import net.therap.enrollmentmanagement.helper.UserHelper;
import net.therap.enrollmentmanagement.service.UserService;
import net.therap.enrollmentmanagement.view.GlobalView;
import net.therap.enrollmentmanagement.view.UserView;

import java.util.List;

import static java.util.Objects.isNull;

/**
 * @author rumi.dipto
 * @since 8/29/21
 */
public class UserController {

    private final UserHelper userHelper;

    private final UserService userService;

    public UserController() {
        userHelper = new UserHelper();
        userService = new UserService();
    }

    public void viewUser() {
        long id = userHelper.getUserIdInput();

        User user = userService.find(id);
        if (isNull(user)) {
            GlobalView.printMessage("No User exists with the given id!");
            return;
        }

        UserView.printUser(user);
    }

    public void viewAllUsers() {
        List<User> userList = userService.findAll();
        if (userList.size() == 0) {
            GlobalView.printMessage("Currently, there are no users!");
            return;
        }

        UserView.printUserList(userList);
    }

    public void createUser() {
        String name = userHelper.getUserNameInput();

        User user = new User();
        user.setName(name);

        userService.saveOrUpdate(user);
        GlobalView.printMessage("The user is created successfully!");
    }

    public void updateUser() {
        long id = userHelper.getUserIdInput();

        User user = userService.find(id);
        if (isNull(user)) {
            GlobalView.printMessage("No User exists with the given id!");
            return;
        }

        String name = userHelper.getUserNameInput();
        user.setName(name);

        userService.saveOrUpdate(user);
        GlobalView.printMessage("The user is updated successfully!");
    }

    public void deleteUser() {
        long id = userHelper.getUserIdInput();

        User user = userService.find(id);
        if (isNull(user)) {
            GlobalView.printMessage("No User exists with the given id!");
            return;
        }

        userService.delete(user);
        GlobalView.printMessage("The user is deleted successfully!");
    }
}
