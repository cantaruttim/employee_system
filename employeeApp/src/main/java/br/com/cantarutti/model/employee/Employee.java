package br.com.cantarutti.model.employee;

import br.com.cantarutti.enums.EmployeeStatus;
import br.com.cantarutti.model.department.EmployeeCoordination;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "tb_employee")
public class Employee {

    @Id
    private String id;

    private String registrationNumber;
    private String employeeName;
    private LocalDate dateContract;

    private String departmentLocated;
    private String levelPosition;

    private EmployeeStatus statusEmployee;

    private EmployeeAddress address;
    private EmployeeFinanceInfo financeInfo;
    private EmployeeCoordination employeeCoordination;

    // GeoLocation
    @Field("lat")
    private Double lat;

    @Field("lon")
    private Double lon;

    public Employee() {}

    public Employee(
            String id,
            String registrationNumber,
            String employeeName,
            LocalDate dateContract,
            String departmentLocated,
            String levelPosition,
            EmployeeStatus statusEmployee,
            EmployeeAddress address,
            EmployeeFinanceInfo financeInfo,
            EmployeeCoordination employeeCoordination,
            Double lat,
            Double lon
    ) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.employeeName = employeeName;
        this.dateContract = dateContract;
        this.departmentLocated = departmentLocated;
        this.levelPosition = levelPosition;
        this.statusEmployee = statusEmployee;
        this.address = address;
        this.financeInfo = financeInfo;
        this.employeeCoordination = employeeCoordination;
        this.lat = lat;
        this.lon = lon;
    }

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
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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
        return this.statusEmployee;
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

    public EmployeeCoordination getEmployeeCoordination() {
        return employeeCoordination;
    }

    public void setEmployeeCoordination(EmployeeCoordination employeeCoordination) {
        this.employeeCoordination = employeeCoordination;
    }
}
