package br.com.cantarutti.service;

import br.com.cantarutti.config.mapper.EmployeeMapper;
import br.com.cantarutti.data.EmployeeDTO;
import br.com.cantarutti.model.Employee;
import br.com.cantarutti.model.EmployeeAddress;
import br.com.cantarutti.model.EmployeeFinanceInfo;
import br.com.cantarutti.repository.EmployeeAddressRepository;
import br.com.cantarutti.repository.EmployeeFinanceInfoRepository;
import br.com.cantarutti.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final EmployeeAddressRepository addressRepo;
    private final EmployeeFinanceInfoRepository financeRepo;

    public Employee createEmployee(EmployeeDTO dto) {

        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setRegistrationNumber(dto.getRegistrationNumber());
        employee.setName(dto.getName());
        employee.setDateContract(dto.getDateContract());

        EmployeeAddress address = new EmployeeAddress();
        address.setAddress(dto.getAddress().getAddress());
        address.setZipCode(dto.getAddress().getZipCode());
        address.setCity(dto.getAddress().getCity());

        EmployeeFinanceInfo finance = new EmployeeFinanceInfo();
        finance.setRoleName(dto.getFinanceInfo().getRoleName());
        finance.setBaseSalary(dto.getFinanceInfo().getBaseSalary());

        employee.setAddress(address);
        employee.setFinanceInfo(finance);

        return employeeRepo.save(employee);
    }

    public EmployeeDTO save(EmployeeDTO dto) {
        Employee employee = EmployeeMapper.toEntity(dto);
        Employee saved = employeeRepo.save(employee);
        return EmployeeMapper.toDTO(saved);
    }


}
