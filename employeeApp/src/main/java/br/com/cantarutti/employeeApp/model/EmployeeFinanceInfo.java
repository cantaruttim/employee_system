package br.com.cantarutti.employeeApp.model;

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

    public Double promotion(Double taxIncrease) {
        return this.baseSalary = (baseSalary + (baseSalary * taxIncrease));
    }

}
