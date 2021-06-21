package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.repository.IEmployeeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@Service("employeeService")
public class EmployeeServiceImp implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Autowired
	Employee employee;
	
	@Override
	public Employee getEmployee() {
		return employee;
	}

	@Override
	public void agregarEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeePorNumber(Long employeeNumber) {
		// TODO Auto-generated method stub
		// Modificar employees
		Optional<Employee> employees = employeeRepository.findById(employeeNumber);
		return employees;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees =(List<Employee>) employeeRepository.findAll();
		return employees;
	}

	@Override
	public void eliminarCliente(Long employeeNumber) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(employeeNumber);
	}

}
