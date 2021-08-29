package net.therap.hibernet.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author rumi.dipto
 * @since 8/9/21
 */
@Entity
@Table(name = "course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_title")
    private String courseTitle;

    @OneToMany(mappedBy = "course",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true)
    private List<Enrollment> enrollmentList;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }

    public void setEnrollmentList(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }
}