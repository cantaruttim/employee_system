package br.com.cantarutti.controller;

import br.com.cantarutti.data.EmployeeDTO;
import br.com.cantarutti.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    // return all employee data from other classes

    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(
            @RequestBody EmployeeDTO dto
    ) {
        EmployeeDTO saved = service.save(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> listAll() {
        List<EmployeeDTO> list = service.listAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(
            @PathVariable UUID id
    ) {
        EmployeeDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable UUID id,
                                              @RequestBody EmployeeDTO dto) {
        EmployeeDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
