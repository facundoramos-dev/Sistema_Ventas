package ar.edu.unju.fi.tpfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.fi.tpfinal.model.User;
import ar.edu.unju.fi.tpfinal.service.IUserService;

@SpringBootApplication
public class Stmy21TpFinalApplication implements CommandLineRunner {
	
	@Autowired
	IUserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(Stmy21TpFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user= new User();
		user.setPassword("admin");
		user.setTipo("ADMINISTRADOR");
		user.setUsuario("admin");
		user.setId(Long.valueOf(1234));
		userService.guardarUsuario(user);
	}
}

