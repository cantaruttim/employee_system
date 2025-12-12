package br.com.cantarutti.repository.employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.cantarutti.model.employee.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> { }
