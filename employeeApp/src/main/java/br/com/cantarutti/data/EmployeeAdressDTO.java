package br.com.cantarutti.data;

public class EmployeeAdressDTO {

    private String registrationNumber;
    private String address;
    private String homeType;

    public EmployeeAdressDTO(){}

    public EmployeeAdressDTO(String registrationNumber, String address, String homeType) {
        this.registrationNumber = registrationNumber;
        this.address = address;
        this.homeType = homeType;
    }

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
}
