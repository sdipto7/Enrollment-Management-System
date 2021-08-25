package net.therap.hibernet.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rumi.dipto
 * @since 8/9/21
 */
@Entity
@Table(name = "enrollment")
public class Enrollment implements Comparable<Enrollment>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "courseCode")
    private Course course;

    public Enrollment() {
    }

    public Enrollment(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", user=" + user +
                ", course=" + course +
                '}';
    }

    @Override
    public int compareTo(Enrollment enrollment) {
        return this.getUser().getId() - enrollment.getUser().getId();
    }
}