package br.com.cantarutti.model.employee;

import br.com.cantarutti.model.enums.EmployeeStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "tb_employee")
public class Employee {

    private String id;  // MongoDB usa String (ObjectId como padrão)

    private String registrationNumber;
    private String name;
    private LocalDate dateContract;

    private String departmentLocated;
    private String levelPosition;

    private EmployeeStatus statusEmployee;

    // Agora documentos internos embutidos (MongoDB não suporta @OneToOne)
    private EmployeeAddress address;

    private EmployeeFinanceInfo financeInfo;

    // GeoLocation
    @Field("lat")
    private Double lat;

    @Field("lon")
    private Double lon;

    public Employee() {}

    public Employee(
            String id,
            String registrationNumber,
            String name,
            LocalDate dateContract,
            EmployeeAddress address,
            EmployeeFinanceInfo financeInfo,
            Double lat,
            Double lon
    ) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.dateContract = dateContract;
        this.address = address;
        this.financeInfo = financeInfo;
        this.lat = lat;
        this.lon = lon;
    }

    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getLevelPosition() {
        return levelPosition;
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

    public EmployeeAddress getAddress() {
        return address;
    }

    public String getDepartmentLocated() {
        return departmentLocated;
    }

    public void setDepartmentLocated(String departmentLocated) {
        this.departmentLocated = departmentLocated;
    }

    public EmployeeStatus getStatusEmployee() {
        return statusEmployee;
    }

    public void setStatusEmployee(EmployeeStatus statusEmployee) {
        this.statusEmployee = statusEmployee;
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

}
