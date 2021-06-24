package ar.edu.unju.fi.tpfinal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrderRepository extends CrudRepository<Order, Long>{

	public Optional<Order> findByOrderNumber(Long orderNumber);
}
