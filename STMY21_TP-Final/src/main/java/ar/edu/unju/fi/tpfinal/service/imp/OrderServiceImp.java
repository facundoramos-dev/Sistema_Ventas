package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.repository.IOrderRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Service("orderService")
public class OrderServiceImp implements IOrderService {

	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	Order order;
	
	@Override
	public Order getOrder() {
		// TODO Auto-generated method stub
		return order;
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		List<Order> orders =(List<Order>) orderRepository.findAll();
		return orders;
	}

	@Override
	public void agregarOrder(Order order) {
		// TODO Auto-generated method stub
		orderRepository.save(order);
	}

	@Override
	public void agregarOrderEncontrado(Order order) {
		// TODO Auto-generated method stub
		List<Order> OrderEncontrado = new ArrayList<Order>(); 
		OrderEncontrado.add(order);
	}

	@Override
	public void eliminarOrder(Long orderNumber) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(orderNumber);
	}

	@Override
	public Optional<Order> getOrderPorNumber(Long orderNumber) {
		// TODO Auto-generated method stub
		Optional<Order> orders = orderRepository.findById(orderNumber);
		return orders;
	}
	
}
