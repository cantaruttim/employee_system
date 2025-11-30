package br.com.cantarutti.data;


import java.time.LocalDate;
import java.util.UUID;


public class EmployeeDTO {

    private UUID id;
    private String registrationNumber;
    private String name;
    private LocalDate dateContract;
    private EmployeeAddressDTO address;
    private EmployeeFinanceInfoDTO financeInfo;

    public EmployeeDTO() {};


    public EmployeeDTO(UUID id, String registrationNumber, String name, LocalDate dateContract, EmployeeAddressDTO address, EmployeeFinanceInfoDTO financeInfo) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.dateContract = dateContract;
        this.address = address;
        this.financeInfo = financeInfo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
}
