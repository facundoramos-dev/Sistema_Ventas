package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.repository.IEmployeeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@Service("employeeService")
public class EmployeeServiceImp implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	public Employee getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeePorNumber(Long employeeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCliente(Long employeeNumber) {
		// TODO Auto-generated method stub
		
	}
}
