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

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Controller
public class CustomerController {
	
	@Autowired
	@Qualifier("customerService")
	private ICustomerService customerService;
	
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("paymentService")
	private IPaymentService paymentService;
	
	@GetMapping("/customer/nuevo")
	public String getCustomerPage(Model model) {
		model.addAttribute("customer",customerService.getCustomer());
		model.addAttribute("employees", employeeService.getEmployees());
		return ("nuevo-customer");
	}	
	
	@PostMapping("/customer/guardar")
	public ModelAndView agregarCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult resulValidacion) {
		ModelAndView modelView;
		System.out.println("Customer_Number: "+customer.getCustomerNumber());
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-customer");
			modelView.addObject("customer",customer);
			modelView.addObject("employees", employeeService.getEmployees());
		}else {//no se encuentran errores
			modelView = new ModelAndView("redirect:/customer/listado"); //lista de customer
			customer.setEmployee(employeeService.getEmployeePorNumber(customer.getEmployee().getEmployeeNumber()));
			if(customer.getEmployee()==null) {
				customer.setCreditLimit(0);
			}
			customerService.agregarCustomer(customer);
		}
		return modelView;
	}	
	
	@GetMapping("/customer/listado")
	public ModelAndView getCustomerPage() {
		ModelAndView modelView = new ModelAndView("customers");
		modelView.addObject("customers", customerService.getCustomers());
		return modelView;
	}
	
	@GetMapping("/customer/editar/{id}")
	public ModelAndView getCustomerEditPage(@PathVariable(value="id")Long customerNumber) {
		ModelAndView modelView = new ModelAndView("nuevo-customer");
		Optional<Customer> customer =  customerService.getCustomerPorCustomerNum(customerNumber);
		modelView.addObject("customer",customer);
		modelView.addObject("employees", employeeService.getEmployees());
		return modelView;
	}
	
	@GetMapping("/customer/eliminar/{id}")
	public ModelAndView getCustomerDeletePage(@PathVariable(value="id")Long customerNumber) {
		ModelAndView modelView = new ModelAndView("redirect:/customer/listado");
		customerService.eliminarCustomer(customerNumber);
		return modelView;
	}
	
}
