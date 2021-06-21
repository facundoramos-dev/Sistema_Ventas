package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Employee;


public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

	public Employee findByEmployeeNumber(Long employeeNumber);
}
