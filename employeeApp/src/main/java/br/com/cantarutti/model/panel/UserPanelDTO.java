package br.com.cantarutti.model.panel;

import br.com.cantarutti.model.user.TimeDiff;
import br.com.cantarutti.model.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserPanelDTO {
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

    public LocalDate getFirstPoint() {
        return firstPoint;
    }

    public LocalDate getSecondPoint() {
        return secondPoint;
    }

    public LocalDate getThirdPoint() {
        return thirdPoint;
    }

    public LocalDate getFourthPoint() {
        return fourthPoint;
    }

}
