package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.repository.ICustomerRepository;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;

@Service("customerService")
public class CustomerServiceImp implements ICustomerService{

	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	Customer customer;

	@Override
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public void agregarCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers =(List<Customer>) customerRepository.findAll();
		return customers;
	}

	@Override
	public void eliminarCustomer(Long customerNumber) {
		customerRepository.deleteById(customerNumber);
	}

	@Override
	public Optional<Customer> getCustomerPorCustomerNum(Long customerNumber) {
		// Modificar cliente
		Optional<Customer> customers = customerRepository.findById(customerNumber);
		return customers;
	}
	
}
