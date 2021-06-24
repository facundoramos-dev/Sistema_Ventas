package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.repository.IEmployeeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@Service("employeeService")
public class EmployeeServiceImp implements IEmployeeService {
	
	List<Employee> employeeEncontrado = new ArrayList<Employee>(); 
	
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
		// Modificar employees
		Optional<Employee> employee = employeeRepository.findById(employeeNumber);
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employee =(List<Employee>) employeeRepository.findAll();
		return employee;
	}

	@Override
	public void eliminarEmployee(Long employeeNumber) {
		employeeRepository.deleteById(employeeNumber);	
	}

	@Override
	public List<Employee> obtenerEmployeeEncontrado() {
		return employeeEncontrado;
	}

	@Override
	public void agregarEmployeeEncontrado(Employee employee) {
		employeeEncontrado.add(employee);
	}

	@Override
	public void quitarEmployeeLista(Long employeeNumber) {
		for (int i=0; i < employeeEncontrado.size(); i++) {
			if(employeeEncontrado.get(i).getEmployeeNumber() == employeeNumber) {
				employeeEncontrado.remove(i);
			}
		}
	}

}
