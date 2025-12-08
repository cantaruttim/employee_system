package br.com.cantarutti.model.panel;

import br.com.cantarutti.model.user.TimeDiff;
import br.com.cantarutti.model.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserPanel {
    // class responsable to get user information

    private UUID id;
    private User registrationNumber;
    private LocalDate firstPoint;
    private LocalDate secondPoint;
    private LocalDate thirdPoint;
    private LocalDate fourthPoint;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(User registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDate getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(LocalDate firstPoint) {
        this.firstPoint = firstPoint;
    }

    public LocalDate getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(LocalDate secondPoint) {
        this.secondPoint = secondPoint;
    }

    public LocalDate getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(LocalDate thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    public LocalDate getFourthPoint() {
        return fourthPoint;
    }

    public void setFourthPoint(LocalDate fourthPoint) {
        this.fourthPoint = fourthPoint;
    }

    public TimeDiff quantityWorked(
            LocalDateTime firstPoint,
            LocalDateTime fourthPoint
    ) {
        TimeDiff timeDiff = new TimeDiff();
        return timeDiff.calculateDiffTime(firstPoint, fourthPoint);
    }

}
