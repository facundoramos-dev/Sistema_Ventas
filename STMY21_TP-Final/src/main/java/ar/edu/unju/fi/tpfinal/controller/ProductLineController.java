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

import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

@Controller
public class ProductLineController {
	
	@Autowired
	@Qualifier("productLineService")
	private IProductLineService productLineService;
	
	@GetMapping("/productLine/nuevo")
	public String getProductLinePage(Model model) {
		model.addAttribute("productLine",productLineService.getProductLine());
		return ("nuevo-productLine");
	}	
	
	@PostMapping("/productLine/guardar")
	public ModelAndView agregarProductLine(@Valid @ModelAttribute("productLine") ProductLine productLine, BindingResult resulValidacion) {
		//ModelAndView modelView = new ModelAndView("payment");
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-productLine");
			modelView.addObject("productLine",productLine);
			return modelView;
		}else {//no se encuentran errores
			modelView = new ModelAndView("redirect:/productLine/listado"); //lista de employee
			productLineService.agregarProductLine(productLine);
			return modelView;
		}
	}
	
	@GetMapping("/productLine/listado")
	public ModelAndView getProductLinePage() {
		ModelAndView modelView = new ModelAndView("productLines");
		modelView.addObject("productLines", productLineService.getProductLine());
		return modelView;
	}
	
	/*@GetMapping("/payment/editar/{id}")
	public ModelAndView getPaymentEditPage(@PathVariable(value="id")Long ) {
		ModelAndView modelView = new ModelAndView("nuevo-payment");
		Optional<Payment> payment =  productLineService.getProductLineServicePorNumero();
		modelView.addObject("payment",payment);
		return modelView;
	}
	
	@GetMapping("/payment/eliminar/{id}")
	public ModelAndView getPaymentDeletePage(@PathVariable(value="id")Long ) {
		ModelAndView modelView = new ModelAndView("redirect:/productLineService/listado");
		productLineService.eliminarPayment(checkNumber);
		return modelView;
	}*/
}
