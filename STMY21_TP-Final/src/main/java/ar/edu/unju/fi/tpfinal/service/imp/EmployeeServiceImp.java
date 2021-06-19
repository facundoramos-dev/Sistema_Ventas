package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tpfinal.repository.IEmployeeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@Service("employeeService")
public class EmployeeServiceImp implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository employeeRepository;
}
