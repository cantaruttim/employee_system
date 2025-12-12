package br.com.cantarutti.controller;

import br.com.cantarutti.data.employeeDTO.EmployeeDTO;
import br.com.cantarutti.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/v1/employees")
    public ResponseEntity<EmployeeDTO> create(
            @RequestBody EmployeeDTO dto
    ) {
        dto.setId(null);
        EmployeeDTO saved = service.save(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/v1/list_all/employees")
    public ResponseEntity<List<EmployeeDTO>> listAll() {
        List<EmployeeDTO> list = service.listAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/v1/list/{id}/employee")
    public ResponseEntity<EmployeeDTO> getById(
            @PathVariable String id
    ) {
        EmployeeDTO dto = service.findById(String.valueOf(UUID.fromString(id)));
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/v1/update/{id}/employee")
    public ResponseEntity<EmployeeDTO> update(
            @PathVariable String id,
            @RequestBody EmployeeDTO dto
    ) {
        EmployeeDTO updated = service.update(String.valueOf(UUID.fromString(id)), dto);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/v1/update/{id}/employee/location")
    public ResponseEntity<EmployeeDTO> updateLocation(
            @PathVariable String id,
            @RequestParam Double lat,
            @RequestParam Double lon
            ) {
        EmployeeDTO updated = service.updatedLocation(String.valueOf(UUID.fromString(id)), lat, lon);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/v1/delete/{id}/employee")
    public ResponseEntity<Void> delete(
            @PathVariable String id
    ) {
        service.delete(String.valueOf(UUID.fromString(id)));
        return ResponseEntity.noContent().build();
    }

}
