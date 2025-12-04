package br.com.cantarutti.data.employeeDTO;

public class EmployeeAddressDTO {

    private String address;
    private String zipcode;
    private String city;

    public EmployeeAddressDTO(){}

    public EmployeeAddressDTO(String address, String zipcode, String city) {
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

    public String getZipCode() {
        return zipcode;
    }

    public void setZipCode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
