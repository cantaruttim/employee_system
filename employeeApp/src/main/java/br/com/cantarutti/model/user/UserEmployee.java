package br.com.cantarutti.model.user;

import br.com.cantarutti.enums.EmployeeStatus;
import br.com.cantarutti.model.employee.Employee;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tb_user")
public class UserEmployee {
    // represent the User after has been posted
    // will be used to log in on page

    @Id
    private String id;

    @Indexed(unique=true)
    private String userNameSystem;
    private String userPasswordSystem;

    private EmployeeStatus userStatus;

    private boolean firstLogin;
    private String employeeId;

    public UserEmployee() {}

    public UserEmployee(
            String userNameSystem,
            String userPasswordSystem,
            EmployeeStatus userStatus,
            boolean firstLogin
    ){
        this.userNameSystem = userNameSystem;
        this.userPasswordSystem = userPasswordSystem;
        this.userStatus = userStatus;
        this.firstLogin = firstLogin;
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

    public EmployeeStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(EmployeeStatus userStatus) {
        this.userStatus = userStatus;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
