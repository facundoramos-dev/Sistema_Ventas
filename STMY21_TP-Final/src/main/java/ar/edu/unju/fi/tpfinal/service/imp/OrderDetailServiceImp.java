package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailId;
import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;

@Service("orderDetailService")
public class OrderDetailServiceImp implements IOrderDetailService {

	@Autowired
	IOrderDetailRepository orderDetailRepository;

	@Autowired
	OrderDetail orderDetail;
	
	@Override
	public OrderDetail getOrderDetail() {
		// TODO Auto-generated method stub
		OrderDetailId detailId=new OrderDetailId();
		orderDetail.setId(detailId);
		return orderDetail;
	}

	@Override
	public List<OrderDetail> getOrderDetails() {
		// TODO Auto-generated method stub
		List<OrderDetail> orderDetails =(List<OrderDetail>) orderDetailRepository.findAll();
		return orderDetails;
	}

	@Override
	public void agregarOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		orderDetailRepository.save(orderDetail);
	}

	@Override
	public void agregarOrderDetailEncontrado(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		List<OrderDetail> orderDetailEncontrado = new ArrayList<OrderDetail>(); 
		orderDetailEncontrado.add(orderDetail);
	}

	@Override
	public void eliminarOrderDetail(OrderDetailId id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public java.util.Optional<OrderDetail> getOrderDetailPorId(OrderDetailId id) {
		java.util.Optional<OrderDetail> order = orderDetailRepository.findById(id);
		return order;
	}

	@Override
	public OrderDetail getOrdeDetailPorOrderNumber(Long orderNumber) {
		// TODO Auto-generated method stub
		OrderDetail orderDetail = orderDetailRepository.findByIdOrderNumberOrderNumber(orderNumber);
		return orderDetail;
	}

	@Override
	public void eliminarOrderDetailPorOrderNumber(Long orderNumber) {
		orderDetailRepository.delete(getOrdeDetailPorOrderNumber(orderNumber));
	}

	@Override
	public List<OrderDetail> obtenerCompras(List<Product> productos,Order order) {
		List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
		OrderDetail orderDe = getOrderDetail();
		short orderLineNumber=0;
		for(int i=0;i<productos.size();i++) {
			orderLineNumber++;
			orderDe.setOrderLineNumber(orderLineNumber);
			orderDe.getId().setOrderNumber(order);
			orderDe.getId().setProductCode(productos.get(i));
			orderDetail.add(orderDe);
		}
		return orderDetail;
	}

}
