package br.com.cantarutti.repository;

import br.com.cantarutti.model.EmployeeAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, UUID> { }
