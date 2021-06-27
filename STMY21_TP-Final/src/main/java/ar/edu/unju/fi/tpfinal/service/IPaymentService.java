package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;


public interface IPaymentService{

	public Payment getPayment();
	
	public void agregarPayment(Payment payment);
	
	//Obtener todas las oficinas
	public List<Payment> getPayments();
	
	public Payment getPaymentPorNumero(PaymentId id);
	
	public void eliminarPayment(Payment id);
	
	public List<Payment> obtenerPaymentEncontrado();
	
	public void agregarPaymentEncontrado(Payment payment);
	
	public void quitarPaymentLista(Long checknumber);
	
	
}
