package ar.edu.unju.fi.tpfinal.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Controller
public class EmployeeController {
	
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("officeService")
	private IOfficeService officeService;
	
	@GetMapping("/employee/nuevo")
	public String getEmployeePage(Model model) {
		if(officeService.getOffices()!=null) {
			model.addAttribute("employee",employeeService.getEmployee());
			model.addAttribute("offices", officeService.getOffices());
			model.addAttribute("employees",employeeService.getEmployees());
			return ("nuevo-employee");
		}
		return("redirect:/employee/error");
	}	
	
	@GetMapping("/employee/error")
	public String getEmployeeErrorPage() {
		return("error-employee");
	}
	
	@PostMapping("/employee/guardar")
	public ModelAndView agregarEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult resulValidacion) {
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-employee");
			modelView.addObject("employee",employee);
			modelView.addObject("offices", officeService.getOffices());
			modelView.addObject("employees",employeeService.getEmployees());
		}else {//no se encuentran errores
			modelView = new ModelAndView("redirect:/employee/listado"); //lista de employee
			employee.setOffice(officeService.getOfficeCodigo(employee.getOffice().getOfficeCode()));
			employee.setEmployee1(employeeService.getEmployeePorNumber(employee.getEmployee1().getEmployeeNumber()));
			employeeService.agregarEmployee(employee);
		}
		return modelView;
	}
	
	@GetMapping("/employee/listado")
	public ModelAndView getEmployeePage() {
		ModelAndView modelView = new ModelAndView("employees");
		modelView.addObject("employees", employeeService.getEmployees());
		return modelView;
	}
	
	@GetMapping("/employee/editar/{id}")
	public ModelAndView getEmployeeEditPage(@PathVariable(value="id")Long employeeNumber) {
		ModelAndView modelView = new ModelAndView("nuevo-employee");
		Optional<Employee> employee =  employeeService.getEmployeePorEmployeeNumber(employeeNumber);
		modelView.addObject("employee",employee);
		modelView.addObject("offices", officeService.getOffices());
		modelView.addObject("employees",employeeService.getEmployees());
		return modelView;
	}
	
	@GetMapping("/employee/eliminar/{id}")
	public ModelAndView getEmployeeDeletePage(@PathVariable(value="id")Long employeeNumber) {
		ModelAndView modelView = new ModelAndView("redirect:/employee/listado");
		employeeService.eliminarRelaciones(employeeNumber);
		employeeService.eliminarEmployee(employeeNumber);
		return modelView;
	}
	
}
