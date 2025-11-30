package br.com.cantarutti.repository;

import br.com.cantarutti.model.EmployeeFinanceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeFinanceInfoRepository extends JpaRepository<EmployeeFinanceInfo, UUID> { }
