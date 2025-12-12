package br.com.cantarutti.model.employee;

public class EmployeeFinanceInfo {

    private String roleName;
    private Double baseSalary;

    public EmployeeFinanceInfo() {}

    public EmployeeFinanceInfo(String roleName, Double baseSalary) {
        this.roleName = roleName;
        this.baseSalary = baseSalary;
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
}
