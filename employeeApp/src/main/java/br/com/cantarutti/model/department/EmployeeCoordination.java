package br.com.cantarutti.model.department;

import br.com.cantarutti.model.employee.Employee;

public class EmployeeCoordination extends Employee {
    // represent the Coordination or a Manager of the respective Employee after has been posted
    // think of a better class name

    private String rolePositionName;
    private String userNameSystem;
    private String userPasswordSystem;

    public String getLevelPosition() {
        return "N10";
    }

    public String getRolePositionName() {
        return rolePositionName;
    }

    // A coordinator should be promoted
    public void setRolePositionName(String rolePositionName) {
        this.rolePositionName = rolePositionName;
    }

    public String userNameSystem() {
      return userNameSystem;
    }

    public String userPasswordSystem() {
      return userPasswordSystem;
    }

}
