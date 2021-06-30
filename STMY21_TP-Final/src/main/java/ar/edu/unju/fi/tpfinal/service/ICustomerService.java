package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Customer;

/**
 * 
 * Clase que permite declarar los metodos 
 * 
 */
public interface ICustomerService {

	/**
	 * Obtener Cliente
	 * @return Customer
	 */
	public Customer getCustomer();
	
	/**
	 * Permite obtener todos los Clientes guardados en la base de datos, 
	 * @return Lista de clientes
	 */
	public List<Customer> getCustomers();

	/**
	 * Permite guardar un cliente en la base de datos
	 * @param customer
	 */
	public void agregarCustomer(Customer customer);

	/**
	 * Permite eliminar un cliente de la base de datos
	 * @param customerNumber
	 */
	public void eliminarCustomer(Long customerNumber);

	/**
	 * Permite obtener un Cliente por su nro de cliente
	 * @param customerNumber
	 * @return Optional<Customer>
	 */
	public Optional<Customer> getCustomerPorCustomerNum(Long customerNumber);

		
	
	/* Metodos auxiliares */
	
	public List<Customer> obtenerCustomerEncontrado();
	
	public void agregarCustomerEncontrado(Customer customer);
	
	public void quitarCustomerLista(Long customerNumber);

	public Customer getCustomerPorNumber(Long customerNumber);
	
}
