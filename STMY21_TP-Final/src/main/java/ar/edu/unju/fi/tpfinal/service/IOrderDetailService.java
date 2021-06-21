package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;

public interface IOrderDetailService {
	
	public OrderDetail getOrderDetail();
	
	//Obtener todas las OrderDetail
	public List<OrderDetail> getOrderDetails();
	
	public void agregarOrderDetail (OrderDetail orderDetail);
	
	public void agregarOrderDetailEncontrado(OrderDetail orderDetail);
	
	/*public void eliminarOrderDetail();
	
	public Optional<OrderDetail> getOfficePorCodigo();
	*/
	
}
