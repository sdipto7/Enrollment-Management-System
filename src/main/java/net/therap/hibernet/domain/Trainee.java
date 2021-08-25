package net.therap.hibernet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author rumi.dipto
 * @since 8/9/21
 */
@Entity
@Table(name = "trainee")
public class Trainee implements Serializable {

    @Id
    @Column(name = "traineeId")
    private int traineeId;

    @Column(name = "traineeName")
    private String traineeName;

    public Trainee(){

    }

    public Trainee(int traineeIdValue, String traineeNameValue) {
        traineeId = traineeIdValue;
        traineeName = traineeNameValue;
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "traineeId=" + traineeId +
                ", traineeName='" + traineeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Trainee trainee = (Trainee) object;

        return this.getTraineeId() == trainee.getTraineeId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getTraineeName());
    }
}