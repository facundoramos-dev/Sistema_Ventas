package ar.edu.unju.fi.tpfinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tpfinal.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

	
	/**
	 * Permite buscar un empleado por su numero de empleado
	 * @param employeeNumber
	 * @return Objeto Empleado
	 */
	public Employee findByEmployeeNumber(Long employeeNumber);
	
	//public Optional<Employee> findById(Long employeeNumber);

}
