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

import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	@Qualifier("productLineService")
	private IProductLineService productLineService;
	
	@GetMapping("/product/nuevo")
	public String getProductPage(Model model) {
		if(productLineService.getProductLines().size()!=0) {
			model.addAttribute("product", productService.getProduct());
			model.addAttribute("productLines", productLineService.getProductLines());
			return ("nuevo-product");
		}else {
			return("redirect:/product/error");
		}
	}
	
	@GetMapping("/product/error")
	public String getProductErrorPage(Model model) {
		return("error-producto");
	}
	
	@PostMapping("/product/guardar")
	public ModelAndView agregarProduct(@Valid @ModelAttribute("product") Product product, BindingResult resulValidacion) {
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-product");
			modelView.addObject("product",product);
			modelView.addObject("productLines", productLineService.getProductLines());
			System.out.println("ERROR");
			return modelView;
		}else {//no se encuentran errores
			System.out.println("SIRVE");
			modelView = new ModelAndView("redirect:/product/listado");
			product.setProductLine(productLineService.getProductLinePorCodigo(product.getProductLine().getId()));
			productService.agregarProduct(product);
			return modelView;
		}
	}
	
	@GetMapping("/product/listado")
	public ModelAndView getProductPage() {
		ModelAndView modelView = new ModelAndView("listado-product");
		modelView.addObject("products", productService.getProducts());
		return modelView;
	}
	
	@GetMapping("/product/editar/{id}")
	public ModelAndView getProductEditPage(@PathVariable(value="id")Long productCode ) {
		ModelAndView modelView = new ModelAndView("nuevo-product");
		Optional<Product> product = productService.getProductPorCodigoId(productCode);
		modelView.addObject("productLines", productLineService.getProductLines());
		modelView.addObject("product",product);
		return modelView;
	}
	
	@GetMapping("/product/eliminar/{id}")
	public ModelAndView getProductDeletePage(@PathVariable(value="id")Long productCode ) {
		ModelAndView modelView = new ModelAndView("redirect:/product/listado");
		productService.eliminarProduct(productCode);
		return modelView;
	}
}