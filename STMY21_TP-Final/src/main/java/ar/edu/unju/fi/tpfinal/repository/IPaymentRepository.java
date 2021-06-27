package ar.edu.unju.fi.tpfinal.repository;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;

public interface IPaymentRepository extends CrudRepository<Payment , PaymentId>{
	
	//public List<Payment> findbyIdCustomerNumber(Customer customerNumber);
	
	//public List<Payment> findbyIdCheckNumber(Long checkNumber);
	
	public Payment findByid(PaymentId id);
	
}
