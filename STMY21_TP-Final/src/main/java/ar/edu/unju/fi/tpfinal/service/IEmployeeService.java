package ar.edu.unju.fi.tpfinal.service;

import ar.edu.unju.fi.tpfinal.model.Employee;

public interface IEmployeeService {

	public Employee getEmployee();
	
	public Employee getEmployeePorNumber(Long employeeNumber);
	
	public void agregarEmployee(Employee employee);
	
	public void eliminarCliente(Long employeeNumber);
	
}
