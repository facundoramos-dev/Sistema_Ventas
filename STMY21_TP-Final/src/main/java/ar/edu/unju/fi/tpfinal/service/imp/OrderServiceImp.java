package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.repository.IOrderRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Service("orderService")
public class OrderServiceImp implements IOrderService {
	
	private static final Log LOGGER = LogFactory.getLog(OrderServiceImp.class);
	
	List<Order> orderEncontrado = new ArrayList<Order>(); 
	
	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	Order order;
	
	@Override
	public Order getOrder() {
		LOGGER.info("METHOD: getOrder - devuelve un objeto Order");
		return order;
	}

	@Override
	public List<Order> getOrders() {
		LOGGER.info("METHOD: getOrders - devuelve un listado de ordenes");
		List<Order> orders =(List<Order>) orderRepository.findAll();
		return orders;
	}

	@Override
	public void agregarOrder(Order order) {
		LOGGER.info("METHOD: agregarOrder - agrega un nuevo objeto Order");
		orderRepository.save(order);
	}

	@Override
	public void agregarOrderEncontrado(Order order) {

		List<Order> OrderEncontrado = new ArrayList<Order>(); 
		OrderEncontrado.add(order);
	}

	@Override
	public void eliminarOrder(Long orderNumber) {
		LOGGER.info("METHOD: EliminarOrder - elimina un objeto Order");
		orderRepository.deleteById(orderNumber);
	}

	@Override
	public Optional<Order> getOrderPorNumber(Long orderNumber) {
		LOGGER.info("METHOD: getOrderPorNumber - busca y devuelve un objeto Order por su numero de orden");
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
