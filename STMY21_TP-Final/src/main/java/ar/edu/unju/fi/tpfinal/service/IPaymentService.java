package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Payment;


public interface IPaymentService{

	public Payment getPayment();
	
	public void agregarPayment(Payment payment);
	
	//Obtener todas las oficinas
	public List<Payment> getPayments();
	
	public Payment getPaymentPorNumero(Long checkNumber);
	
	public void eliminarPayment(Payment id);
	
	public List<Payment> obtenerPaymentEncontrado();
	
	public void agregarPaymentEncontrado(Payment payment);
	
	public void quitarPaymentLista(Long checknumber);
	
	
}
