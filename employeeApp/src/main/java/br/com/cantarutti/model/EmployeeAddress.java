package br.com.cantarutti.model;

import br.com.cantarutti.repository.EmployeeAddressRepository;
import jakarta.persistence.*;


import java.util.UUID;

@Entity
@Table(name = "tb_employee_address")
public class EmployeeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id ;

    private String address;
    private String zipcode;
    private String city;

    public EmployeeAddress(){};

    public EmployeeAddress(UUID id, String address, String zipcode, String city) {
        this.id = id;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
