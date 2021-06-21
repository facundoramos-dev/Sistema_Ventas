package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrderRepository extends CrudRepository<Order, Long>{

	public Order findByOrderNumber(Long orderNumber);
}
