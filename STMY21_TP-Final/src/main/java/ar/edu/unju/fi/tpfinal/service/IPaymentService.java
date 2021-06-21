package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Payment;


public interface IPaymentService{

	public Payment getPayment();
	
	//Obtener todas las oficinas
	public List<Payment> getPayments();
	
	public void agregarPayment(Payment payment);
	
	public void agregarPaymentEncontrado(Payment payment);
	
	public void eliminarPayment(); 
}
