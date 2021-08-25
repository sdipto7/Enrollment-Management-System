package net.therap.hibernet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rumi.dipto
 * @since 8/9/21
 */
@Entity
@Table(name = "enrollment")
public class Enrollment implements Comparable<Enrollment>, Serializable {


    private Trainee trainee;

    private Course course;

    public Enrollment(){
    }

    public Enrollment(Trainee traineeValue, Course courseValue) {
        trainee = traineeValue;
        course = courseValue;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int compareTo(Enrollment enrollment) {
        return this.getTrainee().getTraineeId() - enrollment.getTrainee().getTraineeId();
    }
}