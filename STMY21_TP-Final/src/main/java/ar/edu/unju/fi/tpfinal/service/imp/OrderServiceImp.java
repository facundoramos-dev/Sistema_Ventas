package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.repository.IOrderRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Service("orderService")
public class OrderServiceImp implements IOrderService {
	
	List<Order> orderEncontrado = new ArrayList<Order>(); 
	
	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	Order order;
	
	@Override
	public Order getOrder() {
		return order;
	}

	@Override
	public List<Order> getOrders() {
		List<Order> orders =(List<Order>) orderRepository.findAll();
		return orders;
	}

	@Override
	public void agregarOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public void agregarOrderEncontrado(Order order) {
		List<Order> OrderEncontrado = new ArrayList<Order>(); 
		OrderEncontrado.add(order);
	}

	@Override
	public void eliminarOrder(Long orderNumber) {
		orderRepository.deleteById(orderNumber);
	}

	@Override
	public Optional<Order> getOrderPorNumber(Long orderNumber) {
		Optional<Order> orders = orderRepository.findById(orderNumber);
		return orders;
	}

	@Override
	public List<Order> obtenerOrderEncontrado() {
		return orderEncontrado;
	}

	@Override
	public void quitarOrderLista(Long orderNumber) {
		for (int i=0; i < orderEncontrado.size(); i++) {
			if(orderEncontrado.get(i).getOrderNumber() == orderNumber) {
				orderEncontrado.remove(i);
			}
		}
		
	}
	
}
