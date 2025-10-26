package br.com.cantarutti.employeeApp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    private String registrationNumber;
    private String name;
    private LocalDate dateContract;
    private EmployeeAddress address;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getRegistrationNumber(), employee.getRegistrationNumber()) && Objects.equals(getName(), employee.getName()) && Objects.equals(getDateContract(), employee.getDateContract()) && Objects.equals(getAddress(), employee.getAddress()) && Objects.equals(getFinanceInfo(), employee.getFinanceInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistrationNumber(), getName(), getDateContract(), getAddress(), getFinanceInfo());
    }
}

