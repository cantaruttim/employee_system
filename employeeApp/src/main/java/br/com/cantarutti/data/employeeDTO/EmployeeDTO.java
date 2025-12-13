package br.com.cantarutti.data.employeeDTO;
import br.com.cantarutti.enums.EmployeeStatus;

import java.time.LocalDate;

public class EmployeeDTO {

    private String id;
    private String registrationNumber;
    private String employeeName;
    private LocalDate dateContract;

    private String departmentLocated;
    private String levelPosition;

    private EmployeeStatus statusEmployee;
    private EmployeeAddressDTO address;
    private EmployeeFinanceInfoDTO financeInfo;
    private EmployeeCoordinationDTO employeeCoordinationDTO;

    private Double lat;
    private Double lon;

    public EmployeeDTO() {}

    public EmployeeDTO(
            String id,
            String registrationNumber,
            String employeeName,
            LocalDate dateContract,
            String departmentLocated,
            String levelPosition,
            EmployeeStatus statusEmployee,
            EmployeeAddressDTO address,
            EmployeeFinanceInfoDTO financeInfo
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
    }

    public void EmployeeFinanceInfoDTO() {}

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

    public String getEmployeeName() {
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
        return statusEmployee;
    }

    public void setStatusEmployee(EmployeeStatus statusEmployee) {
        this.statusEmployee = statusEmployee;
    }

    public EmployeeAddressDTO getAddress() {
        return address;
    }

    public void setAddress(EmployeeAddressDTO address) {
        this.address = address;
    }

    public EmployeeFinanceInfoDTO getFinanceInfo() {
        return financeInfo;
    }

    public void setFinanceInfo(EmployeeFinanceInfoDTO financeInfo) {
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

    public EmployeeCoordinationDTO getEmployeeCoordination() {
        return employeeCoordinationDTO;
    }

    public void setEmployeeCoordinationDTO(EmployeeCoordinationDTO employeeCoordinationDTO) {
        this.employeeCoordinationDTO = employeeCoordinationDTO;
    }

}
