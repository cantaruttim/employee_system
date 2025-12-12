package br.com.cantarutti.data.employeeDTO;


import br.com.cantarutti.model.employee.EmployeeAddress;
import br.com.cantarutti.model.employee.EmployeeFinanceInfo;
import br.com.cantarutti.model.enums.EmployeeStatus;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

public class EmployeeDTO {

    private String id;  // MongoDB usa String (ObjectId como padrão)

    private String registrationNumber;
    private String name;
    private LocalDate dateContract;

    private String departmentLocated;
    private String levelPosition;

    private EmployeeStatus statusEmployee;

    private EmployeeAddress address;

    private EmployeeFinanceInfo financeInfo;

    // GeoLocation
    private Double lat;

    private Double lon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateContract() {
        return dateContract;
    }

    public void setDateContract(LocalDate dateContract) {
        this.dateContract = dateContract;
    }

    public String getDepartmentLocated() {
        return departmentLocated;
    }

    public void setDepartmentLocated(String departmentLocated) {
        this.departmentLocated = departmentLocated;
    }

    public String getLevelPosition() {
        return levelPosition;
    }

    public void setLevelPosition(String levelPosition) {
        this.levelPosition = levelPosition;
    }

    public EmployeeStatus getStatusEmployee() {
        return statusEmployee;
    }

    public void setStatusEmployee(EmployeeStatus statusEmployee) {
        this.statusEmployee = statusEmployee;
    }

    public EmployeeAddress getAddress() {
        return address;
    }

    public void setAddress(EmployeeAddress address) {
        this.address = address;
    }

    public EmployeeFinanceInfo getFinanceInfo() {
        return financeInfo;
    }

    public void setFinanceInfo(EmployeeFinanceInfo financeInfo) {
        this.financeInfo = financeInfo;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
