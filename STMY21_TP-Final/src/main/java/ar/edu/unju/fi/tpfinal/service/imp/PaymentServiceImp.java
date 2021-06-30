package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Service("paymentService")
public class PaymentServiceImp implements IPaymentService {

	List<Payment> paymentEncontrado = new ArrayList<Payment>(); 
	
	@Autowired
	private IPaymentRepository paymentRepository;
	
	@Autowired
	private ICustomerService customerService;

	@Autowired
	Payment payment;
	
	@Override
	public Payment getPayment() {
		return payment;
	}

	@Override
	public List<Payment> getPayments() {
		List<Payment>payments = (List<Payment>) paymentRepository.findAll();
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
	public void eliminarPayment(PaymentId id) {
		//paymentRepository.deleteById(payment.getId());
	}

	

	@Override
	public List<Payment> obtenerPaymentEncontrado() {
		return paymentEncontrado;
	}

	@Override
	public void quitarPaymentLista(Long checkNumber) {
		for (int i=0; i < paymentEncontrado.size(); i++) {
			if( paymentEncontrado.get(i).getId().getCheckNumber() == checkNumber) {
				paymentEncontrado.remove(i);
			}
		}
	}

	@Override
	public Optional<Payment> encontrarPaymentPorNumero(PaymentId id) {
		//Optional<Payment> pago = paymentRepository.findById(id);
		return null;
	}

	@Override
	public Payment getPaymentPorCustomerNumber(Long customerNumber) {
		// TODO Auto-generated method stub
		Payment payment = paymentRepository.findByIdCustomerNumberCustomerNumber(customerNumber);
		return payment;
	}

	@Override
	public void eliminarPaymentPorCstomerNumber(Long customerNumber) {
		// TODO Auto-generated method stub
		PaymentId id = new PaymentId(customerService.getCustomerPorNumber(customerNumber));
		id.setCheckNumber(customerNumber);
		paymentRepository.deleteById(id);
	}

}
