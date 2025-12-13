package br.com.cantarutti;

import br.com.cantarutti.model.department.EmployeeCoordination;

public class Main {
    public static void main(String[] args) {

        EmployeeCoordination ec = new EmployeeCoordination();
        System.out.print(ec.defaultPassword("5898"));
    }
}
