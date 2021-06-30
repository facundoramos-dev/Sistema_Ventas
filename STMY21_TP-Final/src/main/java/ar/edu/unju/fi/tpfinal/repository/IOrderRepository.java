package ar.edu.unju.fi.tpfinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrderRepository extends JpaRepository<Order, Long>{

	
	/**
	 * Encuentra un objeto Orden por su numero de Orden
	 * @param orderNumber
	 * @return Objeto Orden
	 */
	public Order findByOrderNumber(Long orderNumber);
	
	//public Optional<Order> findById(Long orderNumber);
}
