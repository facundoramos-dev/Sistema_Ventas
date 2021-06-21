package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Service("paymentService")
public class PaymentServiceImp implements IPaymentService {

	@Autowired
	IPaymentRepository paymentRepository;

	@Autowired
	Payment payment;
	
	@Override
	public Payment getPayment() {
		// TODO Auto-generated method stub
		return payment;
	}

	@Override
	public List<Payment> getPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarPayment(Payment payment) {
		// TODO Auto-generated method stub
		paymentRepository.save(payment);
	}

	@Override
	public void agregarPaymentEncontrado(Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPayment(Long checkNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Payment> getPaymentPorNumero(Long checkNumber) {
		// TODO Auto-generated method stub
		/* List<Payment> payments = paymentRepository.findByPaymentCheckNumber(checkNumber);
		return payments; */
		return null;
	}
}
