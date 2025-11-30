package br.com.cantarutti.controller;

import br.com.cantarutti.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    // return all employee data from other classes

    private final EmployeeService service;



}
