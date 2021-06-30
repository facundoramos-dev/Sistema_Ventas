package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;


public interface IPaymentService{

	public Payment getPayment();
	
	public void agregarPayment(Payment payment);
	
	//Obtener todas las oficinas
	public List<Payment> getPayments();
	
	public Optional<Payment> encontrarPaymentPorNumero(PaymentId id);
	
	public void eliminarPayment(PaymentId id);
	
	public List<Payment> obtenerPaymentEncontrado();
	
	public void agregarPaymentEncontrado(Payment payment);
	
	public void quitarPaymentLista(Long checknumber);
	
	public Payment getPaymentPorCustomerNumber(Long customerNumber);
	
	public void eliminarPaymentPorCstomerNumber(Long customerNumber);
	
}
