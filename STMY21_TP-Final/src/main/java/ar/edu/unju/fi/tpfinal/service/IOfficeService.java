package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Office;

public interface IOfficeService {

	public Office getOffice();
	
	//Obtener todas las oficinas
	public List<Office> getOffices();
	
	public void agregarOffice(Office office);
	
	public void eliminarOffice(Long officeCode);
	
	public Optional<Office> getOfficePorCodigo(Long officeCode);
	
	public List<Office> obtenerOfficeEncontrado();
	
	public void agregarOfficeEncontrado(Office office);
	
	public void quitarOfficeLista(Long officeCode);
	
	public Office getOfficeCodigo(Long officeCode);
}
