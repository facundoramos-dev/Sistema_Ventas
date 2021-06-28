package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Customer;

public interface ICustomerService {

	public Customer getCustomer();
	
	//Obtener todas las Clientes
	public void agregarCustomer(Customer customer);
	
	public Optional<Customer> getCustomerPorCustomerNum(Long customerNumber);
	
	public List<Customer> getCustomers();
	
	public void eliminarCustomer(Long customerNumber);
	
	public List<Customer> obtenerCustomerEncontrado();
	
	public void agregarCustomerEncontrado(Customer customer);
	
	public void quitarCustomerLista(Long id);
	
	public Customer getCustomerPorNumber(Long customerNumber);

	
}
