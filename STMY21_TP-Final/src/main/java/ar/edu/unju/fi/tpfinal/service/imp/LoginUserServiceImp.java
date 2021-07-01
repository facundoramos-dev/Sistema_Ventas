package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.repository.IUserRepository;

@Service
public class LoginUserServiceImp implements UserDetailsService {
	@Autowired
	IUserRepository usuarioRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		ar.edu.unju.fi.tpfinal.model.User usuarioEncontrado = usuarioRepo.findByUsuario(username).orElseThrow(()-> new UsernameNotFoundException("Usuario inválido"));
		List<GrantedAuthority> perfiles = new ArrayList<>(); 
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipo());
		perfiles.add(grantedAuthority);
		
		UserDetails user = (UserDetails) new User(username, usuarioEncontrado.getPassword(), perfiles);
		return user;
	}

}
