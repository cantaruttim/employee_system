package br.com.cantarutti.model.employee;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String registrationNumber;
    private String name;
    private LocalDate dateContract;

    private String departmentLocated;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="address_id")
    private EmployeeAddress address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="finance_info_id")
    private EmployeeFinanceInfo financeInfo;

    // GeoLocation -- must be a better service implementation
    @Column(nullable = true)
    private Double lat;

    @Column(nullable = true)
    private Double lon;

    // Construtores
    public Employee() {}

    public Employee(
            UUID id,
            String registrationNumber,
            String name,
            LocalDate dateContract,
            EmployeeAddress address,
            EmployeeFinanceInfo financeInfo,
            Double lat,
            Double lon
    ) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.dateContract = dateContract;
        this.address = address;
        this.financeInfo = financeInfo;
        this.lat = lat;
        this.lon = lon;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateContract() {
        return dateContract;
    }

    public void setDateContract(LocalDate dateContract) {
        this.dateContract = dateContract;
    }

    public EmployeeAddress getAddress() {
        return address;
    }

    public void setAddress(EmployeeAddress address) {
        this.address = address;
    }

    public EmployeeFinanceInfo getFinanceInfo() {
        return financeInfo;
    }

    public void setFinanceInfo(EmployeeFinanceInfo financeInfo) {
        this.financeInfo = financeInfo;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}

