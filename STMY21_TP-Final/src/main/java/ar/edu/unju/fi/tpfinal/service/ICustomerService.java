package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Customer;

public interface ICustomerService {

	public Customer getCustomer();
	
	//Obtener todas las Clientes
	public List<Customer> getCustomers();
	
	public void agregarCustomer(Customer customer);
	
	public void eliminarCustomer(Long customerNumber);
	
	public Optional<Customer> getCustomerPorCustomerNum(Long customerNumber);
	
	public List<Customer> obtenerCustomerEncontrado();
	
	public void agregarCustomerEncontrado(Customer customer);
	
	public void quitarCustomerLista(Long customerNumber);
	
	public Customer getCustomerPorNumber(Long customerNumber);

	
}
