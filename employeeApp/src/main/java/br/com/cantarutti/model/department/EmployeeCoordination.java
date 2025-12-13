package br.com.cantarutti.model.department;

import br.com.cantarutti.model.employee.Employee;

import java.time.LocalDate;

public class EmployeeCoordination extends Employee {
    // represent the Coordination or a Manager of the respective Employee after has been posted
    // think of a better class name

    private String rolePositionName;
    private String employeeOnOficial;
    private String userNameSystem; // to simplify, could be the registrationNumber
    private String userPasswordSystem;

    public EmployeeCoordination() {}

    public EmployeeCoordination(
            String rolePositionName,
            String employeeOnOficial,
            String userNameSystem,
            String userPasswordSystem
    ) {
        this.rolePositionName = rolePositionName;
        this.employeeOnOficial = employeeOnOficial;
        this.userNameSystem = userNameSystem;
        this.userPasswordSystem = userPasswordSystem;
        getLevelPositionName();
    }

    public String getLevelPositionName() {
        return "N10";
    }

    public String getRolePositionName() {
        return rolePositionName;
    }

    public void setRolePositionName(String rolePositionName) {
        this.rolePositionName = rolePositionName;
    }

    public String getEmployeeOnOficial() {
        return employeeOnOficial;
    }

    public void setEmployeeOnOficial(String employeeOnOficial) {
        this.employeeOnOficial = employeeOnOficial;
    }

    // must be seen by the respective employee
    public String userNameSystem() {
      return userNameSystem;
    }

    public String userPasswordSystem() {
      return userPasswordSystem;
    }

}
