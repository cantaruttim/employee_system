package br.com.cantarutti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cantarutti.model.employee.EmployeeFinanceInfo;

import java.util.UUID;

public interface EmployeeFinanceInfoRepository extends JpaRepository<EmployeeFinanceInfo, UUID> { }
