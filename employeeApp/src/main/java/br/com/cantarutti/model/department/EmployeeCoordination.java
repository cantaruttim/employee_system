package br.com.cantarutti.model.department;

import br.com.cantarutti.model.employee.Employee;

public class EmployeeCoordination extends Employee {
    // represent the Coordination or a Manager of the respective Employee after has been posted
    // think of a better class name

    private String rolePositionName;
    private String employeeOnOficial;
    private String userNameSystem;
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

    // must be seen by the respective employee
    public String userNameSystem() {
      return userNameSystem;
    }

    public String userPasswordSystem() {
      return userPasswordSystem;
    }

}
