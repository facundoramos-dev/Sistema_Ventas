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

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Controller
public class OfficeController {
	
	@Autowired
	@Qualifier("officeService")
	private IOfficeService officeService;
	
	@GetMapping("/office/nuevo")
	public String getOfficePage(Model model) {
		model.addAttribute("office",officeService.getOffice());
		return ("nuevo-office");
	}	
	
	@PostMapping("/office/guardar")
	public ModelAndView agregarOffice(@Valid @ModelAttribute("office") Office office, BindingResult resulValidacion) {
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-office");
			modelView.addObject("office",office);
			return modelView;
		}else {//no se encuentran errores
			modelView = new ModelAndView("redirect:/office/listado"); //lista de office
			officeService.agregarOffice(office);
			return modelView;
		}
	}
	
	@GetMapping("/office/listado")
	public ModelAndView getOfficePage() {
		ModelAndView modelView = new ModelAndView("offices");
		modelView.addObject("offices", officeService.getOffice());
		return modelView;
	}
	
	@GetMapping("/office/editar/{id}")
	public ModelAndView getOfficeEditPage(@PathVariable(value="id")Long officeCode) {
		ModelAndView modelView = new ModelAndView("nuevo-office");
		Optional<Office> office =  officeService.getOfficePorCodigo(officeCode);
		modelView.addObject("office",office);
		return modelView;
	}
	
	@GetMapping("/office/eliminar/{id}")
	public ModelAndView getOfficeDeletePage(@PathVariable(value="id")Long officeCode) {
		ModelAndView modelView = new ModelAndView("redirect:/office/listado");
		officeService.eliminarOffice(officeCode);
		return modelView;
	}
}

