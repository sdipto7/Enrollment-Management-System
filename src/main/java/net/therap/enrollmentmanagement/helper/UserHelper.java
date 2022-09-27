package net.therap.enrollmentmanagement.helper;

import java.util.Scanner;

/**
 * @author rumi.dipto
 * @since 9/27/22
 */
public class UserHelper {

    public long getUserIdInput() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter user id: ");
        long id = input.nextLong();
        input.nextLine();

        return id;
    }

    public String getUserNameInput() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter user name: ");
        String name = input.nextLine();

        return name;
    }
}
