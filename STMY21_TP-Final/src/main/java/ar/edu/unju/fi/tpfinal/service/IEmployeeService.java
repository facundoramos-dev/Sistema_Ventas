package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Employee;

public interface IEmployeeService {

	public Employee getEmployee();
	

	public void agregarEmployee(Employee employee);
	
	public Optional<Employee> getEmployeePorEmployeeNumber(Long employeeNumber);
	
	public List<Employee> getEmployees();
	
	public void eliminarEmployee(Long employeeNumber);
	
	public List<Employee> obtenerEmployeeEncontrado();
	
	public void agregarEmployeeEncontrado(Employee employee);
	
	public void quitarEmployeeLista(Long employeeNumber);
	
	public Employee getEmployeePorNumber(Long employeeNumber);
	
	public void eliminarRelaciones(Long employee);

}
