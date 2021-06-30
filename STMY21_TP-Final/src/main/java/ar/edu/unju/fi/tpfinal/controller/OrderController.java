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

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Controller
public class OrderController {

	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	
	@Autowired
	@Qualifier("customerService")
	private ICustomerService customerService;
	
	@GetMapping("/order/nuevo")
	public String getOrderPage(Model model) {
		System.out.println("VA QUERIENDO");
		model.addAttribute("order",orderService.getOrder());
		//model.addAttribute("customers",customerService.getCustomers());
		return ("nuevo-order");
	}	
	
	@PostMapping("/order/guardar")
	public ModelAndView agregarOrder(@Valid @ModelAttribute("order") Order order, BindingResult resulValidacion) {
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			System.out.println("CON Errores");
			modelView = new ModelAndView("nuevo-order");
			modelView.addObject("order",orderService.getOrder());
			modelView.addObject("customers",customerService.getCustomers());
			return modelView;
		}else {//no se encuentran errores
			System.out.println("SIN Errores");
			modelView = new ModelAndView("redirect:/order/listado"); //lista de order
			//order.setCustomer1(customerService.getCustomerPorNumber(order.getCustomer1().getCustomerNumber()));
			orderService.agregarOrder(order);
			return modelView;
		}
	}
	
	@GetMapping("/order/listado")
	public ModelAndView getOrderPage() {
		ModelAndView modelView = new ModelAndView("orders");
		modelView.addObject("orders", orderService.getOrders());
		return modelView;
	}
	
	@GetMapping("/order/editar/{id}")
	public ModelAndView getOrderEditPage(@PathVariable(value="id")Long orderNumber) {
		ModelAndView modelView = new ModelAndView("nuevo-order");
		Optional<Order> order =  orderService.getOrderPorOrderNumber(orderNumber);
		modelView.addObject("order",order);
		modelView.addObject("customers",customerService.getCustomers());
		return modelView;
	}
	
	@GetMapping("/order/eliminar/{id}")
	public ModelAndView getOrderDeletePage(@PathVariable(value="id")Long orderNumber) {
		ModelAndView modelView = new ModelAndView("redirect:/order/listado");
		orderService.eliminarOrder(orderNumber);
		return modelView;
	}
}
