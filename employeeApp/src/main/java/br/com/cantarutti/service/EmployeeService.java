package br.com.cantarutti.service;

import br.com.cantarutti.config.mapper.EmployeeMapper;
import br.com.cantarutti.data.employeeDTO.EmployeeDTO;
import br.com.cantarutti.model.employee.Employee;
import br.com.cantarutti.model.employee.EmployeeAddress;
import br.com.cantarutti.model.employee.EmployeeFinanceInfo;
import br.com.cantarutti.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final EmployeeAddressRepository addressRepo;
    private final EmployeeFinanceInfoRepository financeRepo;


    public EmployeeDTO updatedLocation(UUID id, Double lat, Double lon) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Employee not found!")
                );

        employee.setLat(lat);
        employee.setLon(lon);

        Employee updated = employeeRepo.save(employee);
        return EmployeeMapper.toDTO(updated);
    }


    // HTTP - CONTROLLER

    // -------------------------------------------------------------
    // CREATE
    // -------------------------------------------------------------
    public EmployeeDTO save(EmployeeDTO dto) {
        Employee employee = EmployeeMapper.toEntity(dto);
        employee.setId(null);
        Employee saved = employeeRepo.save(employee);
        return EmployeeMapper.toDTO(saved);
    }

    // -------------------------------------------------------------
    // LIST ALL
    // -------------------------------------------------------------
    public List<EmployeeDTO> listAll() {
        return employeeRepo
                .findAll()
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    // -------------------------------------------------------------
    // FIND BY ID
    // -------------------------------------------------------------
    public EmployeeDTO findById(UUID id) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));

        return EmployeeMapper.toDTO(employee);
    }

    // -------------------------------------------------------------
    // UPDATE
    // -------------------------------------------------------------
    public EmployeeDTO update(UUID id, EmployeeDTO dto) {

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));

        employee.setName(dto.getName());
        employee.setRegistrationNumber(dto.getRegistrationNumber());
        employee.setDateContract(dto.getDateContract());

        var address = employee.getAddress();
        var addressDTO = dto.getAddress();
        address.setAddress(addressDTO.getAddress());
        address.setCity(addressDTO.getCity());
        address.setZipCode(addressDTO.getZipCode());

        var finance = employee.getFinanceInfo();
        var financeDTO = dto.getFinanceInfo();
        finance.setBaseSalary(financeDTO.getBaseSalary());
        finance.setRoleName(financeDTO.getRoleName());

        addressRepo.save(address);
        financeRepo.save(finance);
        employeeRepo.save(employee);

        return EmployeeMapper.toDTO(employee);
    }

    // -------------------------------------------------------------
    // DELETE
    // -------------------------------------------------------------
    public void delete(UUID id) {

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));

        // Remove dependências primeiro
        addressRepo.delete((EmployeeAddress) employee.getAddress());
        financeRepo.delete((EmployeeFinanceInfo) employee.getFinanceInfo());

        // Depois remove o employee
        employeeRepo.delete(employee);
    }


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



}
