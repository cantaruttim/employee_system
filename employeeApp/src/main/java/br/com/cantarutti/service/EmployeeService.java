package br.com.cantarutti.service;

import br.com.cantarutti.config.mapper.EmployeeMapper;
import br.com.cantarutti.data.employeeDTO.EmployeeDTO;
import br.com.cantarutti.model.employee.Employee;
import br.com.cantarutti.model.employee.EmployeeAddress;
import br.com.cantarutti.model.employee.EmployeeFinanceInfo;
import br.com.cantarutti.repository.employee.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // -------------------------------------------------------------
    // CREATE
    // -------------------------------------------------------------
    public EmployeeDTO save(EmployeeDTO dto) {

        Employee employee = EmployeeMapper.toEntity(dto);
        employee.setId(null); // Mongo gera o ID

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
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Employee not found: " + id
                        )
                );

        return EmployeeMapper.toDTO(employee);
    }

    // -------------------------------------------------------------
    // UPDATE
    // -------------------------------------------------------------
    public EmployeeDTO update(String id, EmployeeDTO dto) {

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Employee not found: " + id
                        )
                );

        // Dados básicos
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setRegistrationNumber(dto.getRegistrationNumber());
        employee.setDateContract(dto.getDateContract());
        employee.setDepartmentLocated(dto.getDepartmentLocated());
        employee.setLevelPosition(dto.getLevelPosition());
        employee.setStatusEmployee(dto.getStatusEmployee());

        // Address (garante não-null)
        if (employee.getAddress() == null) {
            employee.setAddress(new EmployeeAddress());
        }

        if (dto.getAddress() != null) {
            employee.getAddress().setAddress(dto.getAddress().getAddress());
            employee.getAddress().setCity(dto.getAddress().getCity());
            employee.getAddress().setZipCode(dto.getAddress().getZipCode());
        }

        // Finance (garante não-null)
        if (employee.getFinanceInfo() == null) {
            employee.setFinanceInfo(new EmployeeFinanceInfo());
        }

        if (dto.getFinanceInfo() != null) {
            employee.getFinanceInfo().setBaseSalary(dto.getFinanceInfo().getBaseSalary());
            employee.getFinanceInfo().setRoleName(dto.getFinanceInfo().getRoleName());
        }

        Employee updated = employeeRepo.save(employee);
        return EmployeeMapper.toDTO(updated);
    }

    // -------------------------------------------------------------
    // UPDATE ONLY LOCATION
    // -------------------------------------------------------------
    public EmployeeDTO updatedLocation(String id, Double lat, Double lon) {

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Employee not found: " + id
                        )
                );

        employee.setLat(lat);
        employee.setLon(lon);

        Employee updated = employeeRepo.save(employee);
        return EmployeeMapper.toDTO(updated);
    }

    // -------------------------------------------------------------
    // DELETE
    // -------------------------------------------------------------
    public void delete(String id) {

        if (!employeeRepo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Employee not found: " + id
            );
        }

        employeeRepo.deleteById(id);
    }
}

