package br.com.cantarutti.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_employee_finance_info")
public class EmployeeFinanceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id ;

    private String roleName;
    private Double baseSalary;

    public EmployeeFinanceInfo() {};

    public EmployeeFinanceInfo (UUID id, String roleName, Double baseSalary) {
        this.id = id;
        this.roleName = roleName;
        this.baseSalary = baseSalary;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
