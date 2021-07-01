package ar.edu.unju.fi.tpfinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tpfinal.model.User;


public interface IUserRepository extends JpaRepository<User, Long> {
	public Optional< User> findByUsuario(String usuario);
}
