package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.repository.IOrderRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Service("orderService")
public class OrderServiceImp implements IOrderService {

	@Autowired
	IOrderRepository orderRepository;

	@Override
	public Order getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderPorNumber(Long orderNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarOrderEncontrado(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarOrder(Long orderNumber) {
		// TODO Auto-generated method stub
		
	}
	
}
