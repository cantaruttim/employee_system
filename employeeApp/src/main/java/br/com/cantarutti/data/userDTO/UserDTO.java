package br.com.cantarutti.data.userDTO;

import br.com.cantarutti.enums.EmployeeStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class UserDTO {

    private String id;
    private String userNameSystem;
    private String userPasswordSystem;
    private EmployeeStatus userStatus;
    private boolean firstLogin;
    private String employeeId;


    public UserDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
