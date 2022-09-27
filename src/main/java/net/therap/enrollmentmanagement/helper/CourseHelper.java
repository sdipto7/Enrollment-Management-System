package net.therap.enrollmentmanagement.helper;

import java.util.Scanner;

/**
 * @author rumi.dipto
 * @since 9/27/22
 */
public class CourseHelper {

    public long getCourseIdInput() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter course id: ");
        long id = input.nextLong();
        input.nextLine();

        return id;
    }

    public String getCourseCodeInput() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter course code: ");
        String courseCode = input.nextLine();

        return courseCode;
    }

    public String getCourseTitleInput() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter course title: ");
        String courseTitle = input.nextLine();

        return courseTitle;
    }
}
