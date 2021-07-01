package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.User;
import ar.edu.unju.fi.tpfinal.repository.IUserRepository;
import ar.edu.unju.fi.tpfinal.service.IUserService;

@Service
public class UserServiceImp implements IUserService {
	
	@Autowired
	private IUserRepository usuarioRepo;
	
	@Override
	public void guardarUsuario(User user) {
		String pw = user.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		user.setPassword(bCryptPasswordEncoder.encode(pw));
		usuarioRepo.save(user);

	}

	@Override
	public User getUsuario(String user) {
		
		return null;
	}
}
