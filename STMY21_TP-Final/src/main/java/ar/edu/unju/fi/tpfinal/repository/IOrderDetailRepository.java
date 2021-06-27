package ar.edu.unju.fi.tpfinal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailId;


public interface IOrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailId>{

	public Optional<OrderDetail> findById (OrderDetailId id);
}
