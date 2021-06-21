package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Service("paymentService")
public class PaymentServiceImp implements IPaymentService {

	@Autowired
	IPaymentRepository paymentRepository;

	@Override
	public Payment getPayment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> getPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarPayment(Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarPaymentEncontrado(Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPayment() {
		// TODO Auto-generated method stub
		
	}
}
