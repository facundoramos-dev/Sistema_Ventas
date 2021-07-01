package ar.edu.unju.fi.tpfinal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.tpfinal.model.Payment;

public interface IPaymentRepository extends JpaRepository<Payment , String>{
	
}
