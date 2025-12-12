package br.com.cantarutti.config.mapper;

import br.com.cantarutti.data.employeeDTO.EmployeeAddressDTO;
import br.com.cantarutti.data.employeeDTO.EmployeeDTO;
import br.com.cantarutti.data.employeeDTO.EmployeeFinanceInfoDTO;
import br.com.cantarutti.model.employee.Employee;
import br.com.cantarutti.model.employee.EmployeeAddress;
import br.com.cantarutti.model.employee.EmployeeFinanceInfo;

public class EmployeeMapper {

    // ======================================================
    // DTO → Entity
    // ======================================================
    public static Employee toEntity(EmployeeDTO dto) {

        if (dto == null) return null;

        Employee employee = new Employee();

        employee.setId(dto.getId());
        employee.setRegistrationNumber(dto.getRegistrationNumber());
        employee.setName(dto.getEmployeeName());
        employee.setDateContract(dto.getDateContract());
        employee.setLat(dto.getLat());
        employee.setLon(dto.getLon());

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

    // ======================================================
    // Entity → DTO
    // ======================================================
    public static EmployeeDTO toDTO(Employee employee) {

        if (employee == null) return null;

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setRegistrationNumber(employee.getRegistrationNumber());
        dto.setEmployeeName(employee.getName());
        dto.setDateContract(employee.getDateContract());
        dto.setLat(employee.getLat());
        dto.setLon(employee.getLon());

        // Address
        if (employee.getAddress() != null) {
            EmployeeAddressDTO addrDTO = new EmployeeAddressDTO();
            addrDTO.setAddress(employee.getAddress().getAddress());
            addrDTO.setZipCode(employee.getAddress().getZipCode());
            addrDTO.setCity(employee.getAddress().getCity());

            dto.setAddress(addrDTO);
        }

        // Finance info
        if (employee.getFinanceInfo() != null) {
            EmployeeFinanceInfoDTO finDTO = new EmployeeFinanceInfoDTO();
            finDTO.setRoleName(employee.getFinanceInfo().getRoleName());
            finDTO.setBaseSalary(employee.getFinanceInfo().getBaseSalary());

            dto.setFinanceInfo(finDTO);
        }

        return dto;
    }
}
