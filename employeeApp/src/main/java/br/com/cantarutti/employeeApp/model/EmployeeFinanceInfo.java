package br.com.cantarutti.employeeApp.model;

public class EmployeeFinanceInfo {

    private String registrationNumber;
    private String roleName;
    private Double baseSalary;


    public Double promotion(Double taxIncrease) {
        return this.baseSalary = (baseSalary + (baseSalary * taxIncrease));
    }

}
