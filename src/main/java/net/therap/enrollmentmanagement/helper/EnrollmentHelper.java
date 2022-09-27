package net.therap.enrollmentmanagement.helper;

import java.util.Scanner;

/**
 * @author rumi.dipto
 * @since 9/27/22
 */
public class EnrollmentHelper {

    public long getEnrollmentIdInput() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter enrollment id: ");
        long id = input.nextLong();

        return id;
    }
}
