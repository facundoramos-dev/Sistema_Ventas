package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrderService {
	
	public Order getOrder();
	
	//Obtener todas las oficinas
	public void agregarOrder(Order order);

	public Optional<Order> getOrderPorOrderNumber(Long orderNumber);
	
	public List<Order> getOrders();
	
	public void eliminarOrder(Long orderNumber);
	
	public List<Order> obtenerOrderEncontrado();
	
	public void agregarOrderEncontrado(Order order);
	
	public void quitarOrderLista(Long orderNumber);

	public Order getOrderPorNumber(Long orderNumber);

}
