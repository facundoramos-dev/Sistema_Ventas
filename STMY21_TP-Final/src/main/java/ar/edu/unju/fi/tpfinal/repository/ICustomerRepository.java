package ar.edu.unju.fi.tpfinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tpfinal.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long>{

	public Customer findByCustomerNumber(Long customerNumber);
	
	public Optional<Customer> findById(Long customerNumber);
	
}
