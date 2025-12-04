package br.com.cantarutti.controller;

import br.com.cantarutti.data.employeeDTO.EmployeeDTO;
import br.com.cantarutti.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

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
            @PathVariable UUID id
    ) {
        EmployeeDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/v1/update/{id}/employee")
    public ResponseEntity<EmployeeDTO> update(
            @PathVariable UUID id,
            @RequestBody EmployeeDTO dto
    ) {
        EmployeeDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/v1/update/{id}/employee/location")
    public ResponseEntity<EmployeeDTO> updateLocation(
            @PathVariable UUID id,
            @RequestParam Double lat,
            @RequestParam Double lon
            ) {
        EmployeeDTO updated = service.updatedLocation(id, lat, lon);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/v1/delete/{id}/employee")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id
    ) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
