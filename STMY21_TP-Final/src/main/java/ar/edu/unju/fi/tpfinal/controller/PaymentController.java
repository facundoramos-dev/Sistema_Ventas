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
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Controller
public class PaymentController {
	
	@Autowired
	@Qualifier("paymentService")
	private IPaymentService paymentService;
	
	@Autowired
	@Qualifier("customerService")
	private ICustomerService customerService;
	
	@GetMapping("/payment/nuevo/")
	public String getEmployeePage(Model model){
		System.out.println("ABRIR PAGO");
		model.addAttribute("payment",paymentService.getPayment());
		model.addAttribute("customers",customerService.getCustomers());
		return "nuevo-payment";
	}	
	
	@PostMapping("/payment/guardar")
	public ModelAndView agregarPayment(@Valid @ModelAttribute("payment") Payment payment, BindingResult resulValidacion) {
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			System.out.println("ERROR");
			modelView = new ModelAndView("nuevo-payment");
			modelView.addObject("payment",payment);
			modelView.addObject("customers",customerService.getCustomers());
		}else {//no se encuentran errores
			System.out.println("SIN ERROR");
			modelView = new ModelAndView("redirect:/payment/listado");
			payment.setCustomer(customerService.getCustomerPorNumber(payment.getCustomer().getCustomerNumber()));
			paymentService.agregarPayment(payment);
		}
		return modelView;
	}
	
	@GetMapping("/payment/listado")
	public ModelAndView getPaymentPage() {
		System.out.println("LISTAA CORRECTAMNETE");
		ModelAndView modelView = new ModelAndView("listado-payment");
		modelView.addObject("payments", paymentService.getPayments());
		return modelView;
	}
	
	@GetMapping("/payment/editar/{id}")
		public ModelAndView getPaymentEditPage(@PathVariable(value="id")String id) {
		System.out.println("EDITAAA");
		ModelAndView modelView = new ModelAndView("nuevo-payment");
		Optional<Payment> payment =  paymentService.getPaymentPorcheckNum(id);
		modelView.addObject("payment",payment);
		modelView.addObject("customers",customerService.getCustomers());
		return modelView;
	}
	
	@GetMapping("/payment/eliminar/{id}")
	public ModelAndView getPaymentDeletePage(@PathVariable(value="id")String id) {
		System.out.println("BORRAA");
		ModelAndView modelView = new ModelAndView("redirect:/payment/listado");
		paymentService.eliminarPayment(id);
		return modelView;
	}
}
