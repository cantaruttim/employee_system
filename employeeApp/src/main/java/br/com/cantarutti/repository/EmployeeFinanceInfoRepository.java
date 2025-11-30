package br.com.cantarutti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeFinanceInfoRepository extends JpaRepository<EmployeeFinanceInfoRepository, UUID> { }
