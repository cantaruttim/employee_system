package br.com.cantarutti.data.auth;

public class LoginRequest {

    private String userName;
    private String userPassword;

    public LoginRequest() {}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
