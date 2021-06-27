package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Service("paymentService")
public class PaymentServiceImp implements IPaymentService {
	private static final Log LOGGER = LogFactory.getLog(PaymentServiceImp.class);
	
	List<Payment> paymentEncontrado = new ArrayList<Payment>(); 
	
	@Autowired
	private IPaymentRepository paymentRepository;

	@Autowired
	Payment payment;
	
	@Override
	public Payment getPayment() {
		LOGGER.info("METHOD: getPayment - devuelve un objeto Payment");
		return payment;
	}

	@Override
	public List<Payment> getPayments() {
		LOGGER.info("METHOD: getPayments - devuelve un listado de pagos");
		List<Payment>payments = (List<Payment>) paymentRepository.findAll();
		return payments;
	}

	@Override
	public void agregarPayment(Payment payment) {
		LOGGER.info("METHOD: agregarPayment - agrega un objeto Payment");
		paymentRepository.save(payment);
	}

	@Override
	public void agregarPaymentEncontrado(Payment payment) {
		
		paymentEncontrado.add(payment);
		
	}

	@Override
	public void eliminarPayment(Payment id) {
		LOGGER.info("METHOD: eliminarPayment - objeto Payment eliminado");
		paymentRepository.deleteById(payment.getId());
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
	public Payment getPaymentPorNumero(PaymentId id) {
		LOGGER.info("METHOD: getPaymentPorNumero - busca y devuelve un objeto Payment por su id compuesta");
		payment = paymentRepository.findByid(id);
		return payment; 
	}
}
