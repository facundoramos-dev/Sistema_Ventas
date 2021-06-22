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

@Controller
public class CustomerController {
	
	@Autowired
	@Qualifier("customerService")
	private ICustomerService customerService;
	
	@GetMapping("/customer/nuevo")
	public String getCustomerPage(Model model) {
		model.addAttribute("customer",customerService.getCustomer());
		System.out.print("ASDSE");
		return ("nuevo-customer");
	}	
	
	@PostMapping("/customer/guardar")
	public ModelAndView agregarCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult resulValidacion) {
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-customer");
			modelView.addObject("customer",customer);
			return modelView;
		}else {//no se encuentran errores
			modelView = new ModelAndView("redirect:/customer/listado"); //lista de customer
			customerService.agregarCustomer(customer);
			return modelView;
		}
	}
	
	@GetMapping("/customer/listado")
	public ModelAndView getCustomerPage() {
		ModelAndView modelView = new ModelAndView("customers");
		modelView.addObject("customers", customerService.getCustomer());
		return modelView;
	}
	
	@GetMapping("/customer/editar/{id}")
	public ModelAndView getCustomerEditPage(@PathVariable(value="id")Long customerNumber) {
		ModelAndView modelView = new ModelAndView("nuevo-customer");
		Optional<Customer> customer =  customerService.getCustomerPorCustomerNum(customerNumber);
		modelView.addObject("customer",customer);
		return modelView;
	}
	
	@GetMapping("/customer/eliminar/{id}")
	public ModelAndView getCustomerDeletePage(@PathVariable(value="id")Long customerNumber) {
		ModelAndView modelView = new ModelAndView("redirect:/customer/listado");
		customerService.eliminarCustomer(customerNumber);
		return modelView;
	}
	
}
