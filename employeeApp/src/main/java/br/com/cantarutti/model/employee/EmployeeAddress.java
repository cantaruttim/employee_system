package br.com.cantarutti.model.employee;

public class EmployeeAddress {

    private String address;
    private String zipCode;
    private String city;

    public EmployeeAddress() {}

    public EmployeeAddress(String address, String zipCode, String city) {
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

