package ar.edu.unju.fi.tpfinal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Long>{

	public Customer findByCustomerNumber(Long customerNumber);
	public Optional<Customer> findById(Long customerNumber);
	
}
