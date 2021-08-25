package net.therap.hibernet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rumi.dipto
 * @since 8/9/21
 */
@Entity
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @Column(name = "courseCode")
    private String courseCode;

    @Column(name = "courseTitle")
    private String courseTitle;

    public Course(){}

    public Course(String courseCodeValue, String courseTitleValue) {
        courseCode = courseCodeValue;
        courseTitle = courseTitleValue;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                '}';
    }
}