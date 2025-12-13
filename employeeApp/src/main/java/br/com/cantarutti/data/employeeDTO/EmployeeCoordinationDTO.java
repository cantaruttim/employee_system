package br.com.cantarutti.data.employeeDTO;

public class EmployeeCoordinationDTO {

    private String rolePositionName;
    private String employeeOnOficial;
    private String userNameSystem;
    private String userPasswordSystem;

    public EmployeeCoordinationDTO() {}

    public EmployeeCoordinationDTO(
            String rolePositionName,
            String employeeOnOficial,
            String userNameSystem,
            String userPasswordSystem
    ) {
        this.rolePositionName = rolePositionName;
        this.employeeOnOficial = employeeOnOficial;
        this.userNameSystem = userNameSystem;
        this.userPasswordSystem = userPasswordSystem;
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
