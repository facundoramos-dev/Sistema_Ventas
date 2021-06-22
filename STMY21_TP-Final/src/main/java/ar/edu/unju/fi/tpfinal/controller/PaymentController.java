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

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Controller
public class PaymentController {
	
	@Autowired
	@Qualifier("paymentService")
	private IPaymentService paymentService;
	
	@GetMapping("/payment/nuevo")
	public String getPaymentPage(Model model) {
		model.addAttribute("payment",paymentService.getPayment());
		return ("nuevo-payment");
	}	
	
	@PostMapping("/payment/guardar")
	public ModelAndView agregarPayment(@Valid @ModelAttribute("payment") Payment payment, BindingResult resulValidacion) {
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-payment");
			modelView.addObject("payment",payment);
			return modelView;
		}else {//no se encuentran errores
			modelView = new ModelAndView("redirect:/payment/listado"); //lista de employee
			paymentService.agregarPayment(payment);
			return modelView;
		}
	}
	
	@GetMapping("/payment/listado")
	public ModelAndView getPaymentPage() {
		ModelAndView modelView = new ModelAndView("payments");
		modelView.addObject("payments", paymentService.getPayment());
		return modelView;
	}
	
	@GetMapping("/payment/editar/{id}")
	public ModelAndView getPaymentEditPage(@PathVariable(value="id")Long checkNumber) {
		ModelAndView modelView = new ModelAndView("nuevo-payment");
		Optional<Payment> payment =  paymentService.getPaymentPorNumero(checkNumber);
		modelView.addObject("payment",payment);
		return modelView;
	}
	
	@GetMapping("/payment/eliminar/{id}")
	public ModelAndView getPaymentDeletePage(@PathVariable(value="id")Long checkNumber) {
		ModelAndView modelView = new ModelAndView("redirect:/payment/listado");
		paymentService.eliminarPayment(checkNumber);
		return modelView;
	}
}
