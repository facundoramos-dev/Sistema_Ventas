package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.repository.IEmployeeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@Service("employeeService")
public class EmployeeServiceImp implements IEmployeeService {
	
	private static final Log LOGGER = LogFactory.getLog(EmployeeServiceImp.class);

	
	List<Employee> employeeEncontrado = new ArrayList<Employee>(); 
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Autowired
	Employee employee;
	
	@Override
	public Employee getEmployee() {
		LOGGER.info("METHOD: getEmployee - devuelve un objeto Employee");
		return employee;
	}

	@Override
	public void agregarEmployee(Employee employee) {
		LOGGER.info("METHOD: agregarEmployee - Objeto Employee agregado");
		employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeePorNumber(Long employeeNumber) {
		LOGGER.info("METHOD: getEmployeePorNumber - busca y devuelve un objeto Employee por su numero de empleado");
		// Modificar employees
		Optional<Employee> employee = employeeRepository.findById(employeeNumber);
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		LOGGER.info("METHOD: getEmployees - devuelve una lista de Employee");
		List<Employee> employees =(List<Employee>) employeeRepository.findAll();
		return employees;
	}

	@Override
	public void eliminarEmployee(Long employeeNumber) {
		LOGGER.info("METHOD: eliminarEmployee - Eliminado un objeto Employee" );
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
