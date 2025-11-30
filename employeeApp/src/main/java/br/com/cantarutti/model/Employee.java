package br.com.cantarutti.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID id;

    private String registrationNumber;
    private String name;
    private LocalDate dateContract;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="address_id")
    private EmployeeAddress address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="finance_info_id")
    private EmployeeFinanceInfo financeInfo;

    // Construtores
    public Employee() {}

    public Employee(String registrationNumber, String name, LocalDate dateContract, EmployeeAddress address, EmployeeFinanceInfo financeInfo) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.dateContract = dateContract;
        this.address = address;
        this.financeInfo = financeInfo;

    }

    public Employee(String registrationNumber, String name, LocalDate dateContract) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.dateContract = dateContract;
    }

    // Getters e Setters
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

    public EmployeeFinanceInfo getFinanceInfo() {
        return financeInfo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", name='" + name + '\'' +
                ", dateContract=" + dateContract +
                '}';
    }

}

