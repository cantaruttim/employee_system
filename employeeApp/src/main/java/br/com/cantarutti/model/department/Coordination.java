package br.com.cantarutti.model.department;

import br.com.cantarutti.model.employee.Employee;

public class Coordination extends Employee {
    // represent the Coordination of the respective Employee after has been posted
    // think of a better class name
    private String levelPosition = 'N10';
    private String userNameSystem;
    private String userPasswordSystem;

    public String getLevelPosition() {
      return levelPosition;
    }

    public String userNameSystem() {
      return userNameSystem;
    }

    public String userPasswordSystem() {
      return userPasswordSystem;
    }



}
