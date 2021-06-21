package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Employee;

public interface IEmployeeService {

	public Employee getEmployee();
	
	//Obtener todas las Empleados 
	public void agregarEmployee(Employee employee);
	
	public Optional<Employee> getEmployeePorNumber(Long employeeNumber);
	
	public List<Employee> getEmployees();
	
	public void eliminarCliente(Long employeeNumber);
	
}
