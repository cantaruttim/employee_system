package br.com.cantarutti.config.mapper;

import br.com.cantarutti.data.EmployeeAdressDTO;
import br.com.cantarutti.data.EmployeeDTO;
import br.com.cantarutti.data.EmployeeFinanceInfoDTO;
import br.com.cantarutti.model.Employee;
import br.com.cantarutti.model.EmployeeAddress;
import br.com.cantarutti.model.EmployeeFinanceInfo;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeDTO dto) {

        if (dto == null) return null;

        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setRegistrationNumber(dto.getRegistrationNumber());
        employee.setName(dto.getName());
        employee.setDateContract(dto.getDateContract());

        // Address
        if (dto.getAddress() != null) {
            EmployeeAddress address = new EmployeeAddress();
            address.setAddress(dto.getAddress().getAddress());
            address.setZipCode(dto.getAddress().getZipCode());
            address.setCity(dto.getAddress().getCity());
            employee.setAddress(address);
        }

        // Finance info
        if (dto.getFinanceInfo() != null) {
            EmployeeFinanceInfo finance = new EmployeeFinanceInfo();
            finance.setRoleName(dto.getFinanceInfo().getRoleName());
            finance.setBaseSalary(dto.getFinanceInfo().getBaseSalary());
            employee.setFinanceInfo(finance);
        }

        return employee;
    }

    public static EmployeeDTO toDTO(Employee employee) {

        if (employee == null) return null;

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setRegistrationNumber(employee.getRegistrationNumber());
        dto.setName(employee.getName());
        dto.setDateContract(employee.getDateContract());

        if (employee.getAddress() != null) {
            EmployeeAdressDTO addrDTO = new EmployeeAdressDTO();
            addrDTO.setAddress(employee.getAddress().getAddress());
            addrDTO.setZipCode(employee.getAddress().getZipCode());
            addrDTO.setCity(employee.getAddress().getCity());
            addrDTO.setAddress(String.valueOf(addrDTO));
        }

        if (employee.getFinanceInfo() != null) {
            EmployeeFinanceInfoDTO finDTO = new EmployeeFinanceInfoDTO();
            finDTO.setRoleName(employee.getFinanceInfo().getRoleName());
            finDTO.setBaseSalary(employee.getFinanceInfo().getBaseSalary());
            dto.setFinanceInfo(finDTO);
        }

        return dto;
    }


}
