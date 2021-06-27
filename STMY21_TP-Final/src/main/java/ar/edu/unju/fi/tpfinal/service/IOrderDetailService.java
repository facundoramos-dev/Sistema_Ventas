package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailId;

public interface IOrderDetailService {
	
	public OrderDetail getOrderDetail();
	
	//Obtener todas las OrderDetail
	public List<OrderDetail> getOrderDetails();
	
	public void agregarOrderDetail (OrderDetail orderDetail);
	
	public void agregarOrderDetailEncontrado(OrderDetail orderDetail);
	
	public void eliminarOrderDetail(OrderDetailId id);
	
	public Optional<OrderDetail> getOrderDetailPorId(OrderDetailId id);
	
	
}
