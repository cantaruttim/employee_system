package br.com.cantarutti.model.user;

import br.com.cantarutti.model.department.EmployeeCoordination;
import br.com.cantarutti.model.employee.Employee;

public class UserEmployee extends Employee {
    // represent the User after has been posted
    // think of a better class name

    private EmployeeCoordination userNameSystem;
    private EmployeeCoordination userPasswordSystem;


    public UserEmployee() {}

    public UserEmployee(
            EmployeeCoordination userNameSystem,
            EmployeeCoordination userPasswordSystem
    ) {
        this.userNameSystem = userNameSystem;
        this.userPasswordSystem = userPasswordSystem;
    }


    public EmployeeCoordination getUserNameSystem() {
        return userNameSystem;
    }

    public void setUserNameSystem(EmployeeCoordination userNameSystem) {
        this.userNameSystem = userNameSystem;
    }

    public EmployeeCoordination getUserPasswordSystem() {
        return userPasswordSystem;
    }

    public void setUserPasswordSystem(EmployeeCoordination userPasswordSystem) {
        this.userPasswordSystem = userPasswordSystem;
    }
}
