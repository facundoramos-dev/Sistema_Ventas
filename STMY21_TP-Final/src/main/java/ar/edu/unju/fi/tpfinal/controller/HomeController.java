package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/inicio","/","/login","/home", "/index","/login?error=true"})
	public String homeGetPage(Model model) {
		return "home";
	}
}
