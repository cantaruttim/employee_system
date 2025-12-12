package br.com.cantarutti.model.employee;

public class EmployeeAddress {

    private String address;
    private String zipcode;
    private String city;

    public EmployeeAddress() {}

    public EmployeeAddress(String address, String zipcode, String city) {
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

