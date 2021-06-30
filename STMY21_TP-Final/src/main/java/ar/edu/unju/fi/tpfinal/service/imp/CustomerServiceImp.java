package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.repository.ICustomerRepository;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;

@Service("customerService")
public class CustomerServiceImp implements ICustomerService{

	/**
	 * Constante LOGGER que permite ver lo que ocurre en el sistema , al implementarlo dentro de los distintos metodos
	 */
	private static final Log LOGGER = LogFactory.getLog(CustomerServiceImp.class);
	
	List<Customer> customerEncontrado = new ArrayList<Customer>();
	
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private Customer customer;

	@Override
	public Customer getCustomer() {
		LOGGER.info("METHOD: getCustomer -  objeto Customer obtenido ");
		return this.customer;
	}

	@Override
	public void agregarCustomer(Customer customer) {
		LOGGER.info("METHOD: agregarCustomer -  objeto Customer guardado en base de datos ");
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		LOGGER.info("METHOD: getCustomers -  objetos Customers obtenidos ");
		List<Customer> customers =(List<Customer>) customerRepository.findAll();
		return customers;
	}

	@Override
	public void eliminarCustomer(Long customerNumber) {
		LOGGER.info("METHOD: eliminarCustomer -  objeto Customer eliminado ");
		customerRepository.deleteById(customerNumber);
	}

	@Override
	public Optional<Customer> getCustomerPorCustomerNum(Long customerNumber) {
		LOGGER.info("METHOD: getCustomerPorCustomerNum - devuelve un objeto Customer de acuerdo a su numero de id ");
		Optional<Customer> customer = customerRepository.findById(customerNumber);
		return customer;
	}

	
	/**
	 * Auxiliares
	 * 
	 */
	
	@Override
	public List<Customer> obtenerCustomerEncontrado() {
		return customerEncontrado;
	}

	@Override
	public void agregarCustomerEncontrado(Customer customer) {
		List<Customer> customerEncontrado = new ArrayList<Customer>(); 
		customerEncontrado.add(customer);
	}

	@Override
	public void quitarCustomerLista(Long customerNumber) {
		for (int i=0; i < customerEncontrado.size();i++) {
			if(customerEncontrado.get(i).getCustomerNumber() == customerNumber ) {
				customerEncontrado.remove(i); 
			}
		}
	}

	@Override
	public Customer getCustomerPorNumber(Long customerNumber) {
		// Obtener Customer
		Customer customer= customerRepository.findByCustomerNumber(customerNumber);
		return customer;
	}
	
}
