package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;

@Service("orderDetailService")
public class OrderDetailServiceImp implements IOrderDetailService {
	
	private static final Log LOGGER = LogFactory.getLog(OrderDetailServiceImp.class);

	@Autowired
	IOrderDetailRepository orderDetailRepository;

	@Autowired
	OrderDetail orderDetail;
	
	@Override
	public OrderDetail getOrderDetail() {
		LOGGER.info("METHOD: getOrderDetail - devuelve un objeto OrderDetail");
		return orderDetail;
	}

	@Override
	public List<OrderDetail> getOrderDetails() {
		LOGGER.info("METHOD: getOrderDetails - devuelve una lista de OrderDetail");
		List<OrderDetail> orderDetails =(List<OrderDetail>) orderDetailRepository.findAll();
		return orderDetails;
	}

	@Override
	public void agregarOrderDetail(OrderDetail orderDetail) {
		LOGGER.info("METHOD: agregarOrderDetail - Un objeto OrderDetail agregado");
		orderDetailRepository.save(orderDetail);
	}

	@Override
	public void agregarOrderDetailEncontrado(OrderDetail orderDetail) {
		List<OrderDetail> orderDetailEncontrado = new ArrayList<OrderDetail>(); 
		orderDetailEncontrado.add(orderDetail);
	}
	
}
