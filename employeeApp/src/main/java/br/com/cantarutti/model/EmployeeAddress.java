package br.com.cantarutti.model;

import java.util.Objects;

public class EmployeeAddress {

    private String registrationNumber;
    private String address;
    private String homeType;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeType() {
        return homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EmployeeAddress that)) return false;
        return Objects.equals(getRegistrationNumber(), that.getRegistrationNumber()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getHomeType(), that.getHomeType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistrationNumber(), getAddress(), getHomeType());
    }
}
