package br.com.cantarutti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cantarutti.model.employee.EmployeeAddress;

import java.util.UUID;

public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, UUID> { }
