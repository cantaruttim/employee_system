package br.com.cantarutti.controller;

import br.com.cantarutti.data.EmployeeDTO;
import br.com.cantarutti.model.Employee;
import br.com.cantarutti.repository.EmployeeAddressRepository;
import br.com.cantarutti.repository.EmployeeFinanceInfoRepository;
import br.com.cantarutti.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    // return all employee data from other classes

    @Autowired
    private EmployeeRepository EmployeeRespository;

    @Autowired
    private EmployeeAddressRepository addressRepository;

    @Autowired
    private EmployeeFinanceInfoRepository financeRepository;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @RequestBody EmployeeDTO dto
    ) {
        // Persistency of address
        EmployeeAddressRepository savedAdress = addressRepository.save(dto.getAddress());

        // Persistency of Finance information
        EmployeeFinanceInfoRepository savedFinance = financeRepository.save(dto.getFinanceInfo());

        Employee employee = new Employee();
        employee.setRegistrationNumber(dto.getRegistrationNumber());
        employee.setName(dto.getName());
        employee.setDateContract(dto.getDateContract());
        employee.setAddress(savedAddress);
        employee.setFinanceInfo(savedFinanceInfo);

        // Persistency of Employee
        Employee savedEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(saveEmployee);
    }

}
