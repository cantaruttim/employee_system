package br.com.cantarutti.data;


import jakarta.persistence.Entity;

@Entity(name="tb_finance")
public class EmployeeFinanceInfoDTO {

    private String registrationNumber;
    private String roleName;
    private Double baseSalary;

    public EmployeeFinanceInfoDTO(){}
    public EmployeeFinanceInfoDTO(String registrationNumber, String roleName, Double baseSalary) {
        this.registrationNumber = registrationNumber;
        this.roleName = roleName;
        this.baseSalary = baseSalary;
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
}
