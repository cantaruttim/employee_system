package br.com.cantarutti.data;

public class EmployeeAdressDTO {

    private String registrationNumber;
    private String address;
    private String zipcode;

    public EmployeeAdressDTO(){}

    public EmployeeAdressDTO(String registrationNumber, String address, String zipcode) {
        this.registrationNumber = registrationNumber;
        this.address = address;
        this.zipcode = zipcode;
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

    public String getZipCode() {
        return zipcode;
    }

    public void setZipCode(String zipcode) {
        this.zipcode = zipcode;
    }
}
