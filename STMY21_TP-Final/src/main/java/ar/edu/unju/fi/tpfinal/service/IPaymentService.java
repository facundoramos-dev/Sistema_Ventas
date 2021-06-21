package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Payment;


public interface IPaymentService{

	public Payment getPayment();
	
	//Obtener todas las oficinas
	public List<Payment> getPayments();
	
	public void agregarPayment(Payment payment);
	
	public void agregarPaymentEncontrado(Payment payment);
	
	public void eliminarPayment(Long checkNumber);
	
	public Optional<Payment> getPaymentPorNumero(Long checkNumber);
}
