package net.therap.enrollmentmanagement.view;

import net.therap.enrollmentmanagement.domain.User;

import java.util.List;

/**
 * @author rumi.dipto
 * @since 9/27/22
 */
public class UserView {

    public static void printUser(User user) {
        System.out.println("User's id: " + user.getId());
        System.out.println("User's name: " + user.getName());
    }

    public static void printUserList(List<User> userList) {
        System.out.println("ID\t\tName");
        for (User user : userList) {
            System.out.println(user.getId() + " - " + user.getName());
        }
    }
}
