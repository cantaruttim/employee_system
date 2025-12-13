package br.com.cantarutti.service;

import br.com.cantarutti.config.mapper.EmployeeMapper;
import br.com.cantarutti.data.employeeDTO.EmployeeDTO;
import br.com.cantarutti.model.employee.Employee;
import br.com.cantarutti.model.employee.EmployeeAddress;
import br.com.cantarutti.model.employee.EmployeeFinanceInfo;
import br.com.cantarutti.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // -------------------------------------------------------------
    // UPDATE ONLY LOCATION
    // -------------------------------------------------------------
    public EmployeeDTO updatedLocation(String id, Double lat, Double lon) {

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));

        employee.setLat(lat);
        employee.setLon(lon);

        Employee updated = employeeRepo.save(employee);
        return EmployeeMapper.toDTO(updated);
    }


    // -------------------------------------------------------------
    // CREATE
    // -------------------------------------------------------------
    public EmployeeDTO save(EmployeeDTO dto) {
        Employee employee = EmployeeMapper.toEntity(dto);

        employee.setId(null); // Mongo irá criar ObjectId automaticamente

        Employee saved = employeeRepo.save(employee);
        return EmployeeMapper.toDTO(saved);
    }

    // -------------------------------------------------------------
    // LIST ALL
    // -------------------------------------------------------------
    public List<EmployeeDTO> listAll() {
        return employeeRepo.findAll()
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    // -------------------------------------------------------------
    // FIND BY ID
    // -------------------------------------------------------------
    public EmployeeDTO findById(String id) {

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));

        return EmployeeMapper.toDTO(employee);
    }

    // -------------------------------------------------------------
    // UPDATE
    // -------------------------------------------------------------
    public EmployeeDTO update(String id, EmployeeDTO dto) {

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));

        // Dados básicos
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setRegistrationNumber(dto.getRegistrationNumber());
        employee.setDateContract(dto.getDateContract());
        employee.setDepartmentLocated(dto.getDepartmentLocated());
        employee.setLevelPosition(dto.getLevelPosition());
        employee.setStatusEmployee(dto.getStatusEmployee());

        // Address
        EmployeeAddress address = employee.getAddress();
        var addressDTO = dto.getAddress();
        address.setAddress(addressDTO.getAddress());
        address.setCity(addressDTO.getCity());
        address.setZipCode(addressDTO.getZipCode());

        // Finance
        EmployeeFinanceInfo finance = employee.getFinanceInfo();
        var financeDTO = dto.getFinanceInfo();
        finance.setBaseSalary(financeDTO.getBaseSalary());
        finance.setRoleName(financeDTO.getRoleName());

        employeeRepo.save(employee);

        return EmployeeMapper.toDTO(employee);
    }

    // -------------------------------------------------------------
    // DELETE (agora só remove o documento principal)
    // -------------------------------------------------------------
    public void delete(String id) {

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));

        employeeRepo.delete(employee);
    }

    // -------------------------------------------------------------
    // CREATE MANUAL
    // -------------------------------------------------------------
    public Employee createEmployee(EmployeeDTO dto) {

        Employee employee = new Employee();
        employee.setId(null); // Mongo cria ID

        employee.setRegistrationNumber(dto.getRegistrationNumber());
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setDateContract(dto.getDateContract());

        // Address
        EmployeeAddress address = new EmployeeAddress(
                dto.getAddress().getAddress(),
                dto.getAddress().getZipCode(),
                dto.getAddress().getCity()
        );

        // Finance
        EmployeeFinanceInfo finance = new EmployeeFinanceInfo(
                dto.getFinanceInfo().getRoleName(),
                dto.getFinanceInfo().getBaseSalary()
        );

        employee.setAddress(address);
        employee.setFinanceInfo(finance);

        return employeeRepo.save(employee);
    }
}
