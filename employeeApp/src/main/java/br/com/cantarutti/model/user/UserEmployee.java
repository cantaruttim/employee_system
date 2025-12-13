package br.com.cantarutti.model.user;

import br.com.cantarutti.enums.EmployeeStatus;
import br.com.cantarutti.model.department.EmployeeCoordination;
import br.com.cantarutti.model.employee.Employee;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tb_user")
public class UserEmployee extends Employee {
    // represent the User after has been posted
    // will be used to login on page
    // think of a better class name

    private EmployeeCoordination userNameSystem;

    // BCrypt
    private EmployeeCoordination userPasswordSystem;
    private EmployeeStatus status;

    public UserEmployee() {}

    public UserEmployee(
            EmployeeCoordination userNameSystem,
            EmployeeCoordination userPasswordSystem,
            EmployeeStatus status
    ) {
        this.userNameSystem = userNameSystem;
        this.userPasswordSystem = userPasswordSystem;
        this.status = status;
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

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }
}
