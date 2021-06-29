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
	public Optional<Employee> getEmployeePorEmployeeNumber(Long employeeNumber) {
		// Modificar employees
		Optional<Employee> employee = employeeRepository.findById(employeeNumber);
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees =(List<Employee>) employeeRepository.findAll();
		return employees;
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

	@Override
	public Employee getEmployeePorNumber(Long employeeNumber) {
		// Obtener Office
		Employee employee= employeeRepository.findByEmployeeNumber(employeeNumber);
		return employee;
	}

	@Override
	public void eliminarRelaciones(Long employee) {
		List<Employee> empleadosList = getEmployees();
		if(empleadosList.size()!=0) {
			for(int i=0;i<empleadosList.size();i++) {
				if(empleadosList.get(i).getEmployee1()!=null) {
					if(empleadosList.get(i).getEmployee1().getEmployeeNumber()==employee) {
						empleadosList.get(i).setEmployee1(null);
						agregarEmployee(empleadosList.get(i));
					}
				}
				
			}
		}
	}

}
