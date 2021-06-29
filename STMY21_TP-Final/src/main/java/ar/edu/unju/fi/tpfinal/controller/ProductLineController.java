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
		ModelAndView modelView = new ModelAndView("listado-productLine");
		modelView.addObject("productLine", productLineService.getProductLines());
		return modelView;
	}
	
	
	@GetMapping("/productLine/editar/{id}")
	public ModelAndView getProductLineEditPage(@PathVariable(value="id")Long id ) {
		ModelAndView modelView = new ModelAndView("nuevo");
	/*	ModelAndView modelView = new ModelAndView("nuevo-productLine"); */
		Optional<ProductLine> productLineE =  productLineService.getProductLinePorCodigo(id);
		modelView.addObject("productLine",productLineE);
		return modelView;
	}
	
	@GetMapping("/productLine/eliminar/{id}")
	public ModelAndView getProductLinetDeletePage(@PathVariable(value="id")Long id ) {
		ModelAndView modelView = new ModelAndView("redirect:/productLine/listado");
		productLineService.eliminarProductLine(id);
		return modelView;
	}
}
