package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrderService {
	
	public Order getOrder();
	
	//public Order getOrderPorNumber(Long orderNumber);
	
	//Obtener todas las oficinas
	public List<Order> getOrders();
	
	public void agregarOrder(Order order);
	
	public void agregarOrderEncontrado(Order order);
	
	public void eliminarOrder(Long orderNumber);

	public Optional<Order> getOrderPorNumber(Long orderNumber);
}
