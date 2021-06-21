package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;

public interface IPaymentRepository extends CrudRepository<Payment, PaymentId>{

	List<Payment>findByCustomerCustomerNumber(String customerName);
	
	List<Payment>findByPaymentCheckNumber(Long checkNumber);
	
}
