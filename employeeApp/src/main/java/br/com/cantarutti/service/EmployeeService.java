package br.com.cantarutti.service;

import br.com.cantarutti.data.EmployeeDTO;
import br.com.cantarutti.model.Employee;
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

        return null;
    }

}
