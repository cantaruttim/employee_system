package br.com.cantarutti.model.department;

import br.com.cantarutti.model.employee.Employee;

public class EmployeeCoordination {
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

    public String getUserNameSystem() {
        return userNameSystem;
    }

    public void setUserNameSystem(String userNameSystem) {
        this.userNameSystem = userNameSystem;
    }

    public String getUserPasswordSystem() {
        return userPasswordSystem;
    }

    public void setUserPasswordSystem(String userPasswordSystem) {
        this.userPasswordSystem = userPasswordSystem;
    }
}
