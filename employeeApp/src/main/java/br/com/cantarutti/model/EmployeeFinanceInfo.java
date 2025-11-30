package br.com.cantarutti.model;

import java.util.Objects;

public class EmployeeFinanceInfo {

    private String registrationNumber;
    private String roleName;
    private Double baseSalary;

    public EmployeeFinanceInfo (String reg, String roleName, Double baseSalary) {
        this.registrationNumber = reg;
        this.roleName = roleName;
        this.baseSalary = baseSalary;
    }
    public EmployeeFinanceInfo () {}

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EmployeeFinanceInfo that)) return false;
        return Objects.equals(getRegistrationNumber(), that.getRegistrationNumber()) && Objects.equals(getRoleName(), that.getRoleName()) && Objects.equals(getBaseSalary(), that.getBaseSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistrationNumber(), getRoleName(), getBaseSalary());
    }
}
