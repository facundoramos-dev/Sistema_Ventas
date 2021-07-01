package ar.edu.unju.fi.tpfinal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;

@Controller
public class OrderDetailController {

	@Autowired
	@Qualifier("orderDetailService")
	private IOrderDetailService orderDetailService;
	
	@GetMapping("/orderDetail/nuevo")
	public String getOrderDetailPage(Model model) {
		model.addAttribute("orderDetail",orderDetailService.getOrderDetail());
		return ("nuevo-orderDetail");
	}	
	
	@PostMapping("/orderDetail/guardar")
	public ModelAndView agregarOrderDetail(@Valid @ModelAttribute("orderDetail") OrderDetail orderDetail, BindingResult resulValidacion) {
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-orderDetail");
			modelView.addObject("orderDetail",orderDetail);
			return modelView;
		}else {//no se encuentran errores
			modelView = new ModelAndView("redirect:/orderDetail/listado"); //lista de orderDetail
			orderDetailService.agregarOrderDetail(orderDetail);
			return modelView;
		}
	}
	
	@GetMapping("/orderDetail/listado")
	public ModelAndView getOrderDetailPage() {
		ModelAndView modelView = new ModelAndView("orderDetails");
		modelView.addObject("orderDetails", orderDetailService.getOrderDetails());
		return modelView;
	}
	
	/*@GetMapping("/orderDetail/editar/{id}")
	public ModelAndView getOrderEditPage(@PathVariable(value="id")Long ) {
		ModelAndView modelView = new ModelAndView("nuevo-orderDetail");
		Optional<OrderDetail> orderDetail =  orderDetailService;
		modelView.addObject("orderDetail",orderDetail);
		return modelView;
	}
	
	@GetMapping("/orderDetail/eliminar/{id}")
	public ModelAndView getOrderDeletePage(@PathVariable(value="id")Long ) {
		ModelAndView modelView = new ModelAndView("redirect:/orderDetail/listado");
		orderDetailService;
		return modelView;
	}*/
	
	@GetMapping("/detail/nuevo")
	public String getOrderDetailsPage(Model model) {
		model.addAttribute("orderDetail",orderDetailService.getOrderDetail());
		return ("nuevo-detail");
	}
	
}


