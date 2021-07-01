package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailId;
import ar.edu.unju.fi.tpfinal.model.Product;

public interface IOrderDetailService {
	
	public OrderDetail getOrderDetail();
	
	//Obtener todas las OrderDetail
	public List<OrderDetail> getOrderDetails();
	
	public void agregarOrderDetail (OrderDetail orderDetail);
	
	public void agregarOrderDetailEncontrado(OrderDetail orderDetail);
	
	public void eliminarOrderDetail(OrderDetailId id);
	
	public Optional<OrderDetail> getOrderDetailPorId(OrderDetailId id);
	
	public OrderDetail getOrdeDetailPorOrderNumber(Long orderNumber);
	
	public void eliminarOrderDetailPorOrderNumber(Long orderNumber);

	public List<OrderDetail> obtenerCompras(List<Product> productos, Order order);

}
