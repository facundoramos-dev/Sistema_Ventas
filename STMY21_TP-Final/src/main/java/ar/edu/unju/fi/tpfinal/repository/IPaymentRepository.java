package ar.edu.unju.fi.tpfinal.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;

public interface IPaymentRepository extends JpaRepository<Payment , PaymentId>{
	
	public Optional<Payment> findById(PaymentId Id);
}
