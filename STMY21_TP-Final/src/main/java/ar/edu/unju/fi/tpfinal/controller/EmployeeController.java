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

@Controller
public class EmployeeController {
	
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
	@GetMapping("/employee/nuevo")
	public String getEmployeePage(Model model) {
		model.addAttribute("employee",employeeService.getEmployee());
		return ("nuevo-employee");
	}	
	
	@PostMapping("/employee/guardar")
	public ModelAndView agregarEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult resulValidacion) {
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-employee");
			modelView.addObject("employee",employee);
			return modelView;
		}else {//no se encuentran errores
			modelView = new ModelAndView("redirect:/employee/listado"); //lista de employee
			employeeService.agregarEmployee(employee);
			return modelView;
		}
	}
	
	@GetMapping("/employee/listado")
	public ModelAndView getEmployeePage() {
		ModelAndView modelView = new ModelAndView("employees");
		modelView.addObject("employees", employeeService.getEmployee());
		return modelView;
	}
	
	@GetMapping("/employee/editar/{id}")
	public ModelAndView getEmployeeEditPage(@PathVariable(value="id")Long employeeNumber) {
		ModelAndView modelView = new ModelAndView("nuevo-customer");
		Optional<Employee> employee =  employeeService.getEmployeePorEmployeeNumber(employeeNumber);
		modelView.addObject("employee",employee);
		return modelView;
	}
	
	@GetMapping("/employee/eliminar/{id}")
	public ModelAndView getEmployeeDeletePage(@PathVariable(value="id")Long employeeNumber) {
		ModelAndView modelView = new ModelAndView("redirect:/employee/listado");
		employeeService.eliminarEmployee(employeeNumber);
		return modelView;
	}
}
