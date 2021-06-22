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
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Controller
public class OrderController {

	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	
	@GetMapping("/order/nuevo")
	public String getOrderPage(Model model) {
		model.addAttribute("order",orderService.getOrder());
		return ("nuevo-order");
	}	
	
	@PostMapping("/order/guardar")
	public ModelAndView agregarOrder(@Valid @ModelAttribute("order") Order order, BindingResult resulValidacion) {
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-order");
			modelView.addObject("order",order);
			return modelView;
		}else {//no se encuentran errores
			modelView = new ModelAndView("redirect:/order/listado"); //lista de order
			orderService.agregarOrder(order);
			return modelView;
		}
	}
	
	@GetMapping("/order/listado")
	public ModelAndView getOrderPage() {
		ModelAndView modelView = new ModelAndView("orders");
		modelView.addObject("orders", orderService.getOrder());
		return modelView;
	}
	
	@GetMapping("/order/editar/{id}")
	public ModelAndView getOrderEditPage(@PathVariable(value="id")Long orderNumber) {
		ModelAndView modelView = new ModelAndView("nuevo-order");
		Optional<Order> order =  orderService.getOrderPorNumber(orderNumber);
		modelView.addObject("order",order);
		return modelView;
	}
	
	@GetMapping("/order/eliminar/{id}")
	public ModelAndView getOrderDeletePage(@PathVariable(value="id")Long orderNumber) {
		ModelAndView modelView = new ModelAndView("redirect:/order/listado");
		orderService.eliminarOrder(orderNumber);
		return modelView;
	}
}

