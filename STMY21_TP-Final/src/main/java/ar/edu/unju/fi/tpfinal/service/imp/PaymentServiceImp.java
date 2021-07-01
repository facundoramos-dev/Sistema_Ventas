package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Service("paymentService")
public class PaymentServiceImp implements IPaymentService {

	private List<Payment> paymentEncontrado = new ArrayList<Payment>(); 
	
	@Autowired
	private IPaymentRepository paymentRepository;

	@Autowired
	Payment payment;
	
	@Override
	public Payment getPayment() {
		return payment;
	}

	@Override
	public List<Payment> getPayments() {
		List<Payment> payments = (List<Payment>) paymentRepository.findAll();
		return payments;
	}

	@Override
	public void agregarPayment(Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	public void agregarPaymentEncontrado(Payment payment) {
		paymentEncontrado.add(payment);
		
	}

	@Override
	public void eliminarPayment(String id) {
		paymentRepository.deleteById(id);
	}

	

	@Override
	public List<Payment> obtenerPaymentEncontrado() {
		return paymentEncontrado;
	}

	@Override
	public void quitarPaymentLista(String id) {
		for (int i=0; i < paymentEncontrado.size(); i++) {
			if( paymentEncontrado.get(i).getCheckNumber() == id) {
				paymentEncontrado.remove(i);
			}
		}
	}

	@Override
	public Optional<Payment> getPaymentPorcheckNum(String id) {
		Optional<Payment> pago = paymentRepository.findById(id);
		return pago;
	}
	

}
