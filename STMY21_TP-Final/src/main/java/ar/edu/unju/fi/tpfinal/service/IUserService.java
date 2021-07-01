package ar.edu.unju.fi.tpfinal.service;

import ar.edu.unju.fi.tpfinal.model.User;

public interface IUserService {
	public void guardarUsuario(User user);
	public User getUsuario(String nombre);
}
