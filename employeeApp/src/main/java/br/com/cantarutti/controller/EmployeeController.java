package br.com.cantarutti.controller;

import br.com.cantarutti.data.EmployeeDTO;
import br.com.cantarutti.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok(saved);
    }

}
