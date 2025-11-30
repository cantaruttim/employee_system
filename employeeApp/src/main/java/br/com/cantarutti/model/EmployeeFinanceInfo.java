package br.com.cantarutti.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_employee_finance_info")
public class EmployeeFinanceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String registrationNumber;
    private String roleName;
    private Double baseSalary;

    public EmployeeFinanceInfo (String reg, String roleName, Double baseSalary) {
        this.registrationNumber = reg;
        this.roleName = roleName;
        this.baseSalary = baseSalary;
    }
    public EmployeeFinanceInfo () {}

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getSalaryByPromotion(Double taxIncrease) {
        return this.baseSalary = (baseSalary + (baseSalary * taxIncrease));
    }
}
