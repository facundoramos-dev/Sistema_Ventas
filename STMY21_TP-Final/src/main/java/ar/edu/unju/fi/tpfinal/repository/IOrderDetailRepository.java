package ar.edu.unju.fi.tpfinal.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailId;


public interface IOrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId>{

	public Optional<OrderDetail> findById (OrderDetailId id);
}
