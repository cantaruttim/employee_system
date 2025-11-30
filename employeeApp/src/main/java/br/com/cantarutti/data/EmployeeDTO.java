package br.com.cantarutti.data;

import br.com.cantarutti.model.EmployeeAddress;
import br.com.cantarutti.model.EmployeeFinanceInfo;

import java.time.LocalDate;


public class EmployeeDTO {

    private String registrationNumber;
    private String name;
    private LocalDate dateContract;
    private EmployeeAddress address;
    private EmployeeFinanceInfo financeInfo;

    public EmployeeDTO(){}

    public EmployeeDTO(
            String registrationNumber,
            String name,
            LocalDate dateContract,
            EmployeeAddress address,
            EmployeeFinanceInfo financeInfo
    ) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.dateContract = dateContract;
        this.address = address;
        this.financeInfo = financeInfo;
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
}
