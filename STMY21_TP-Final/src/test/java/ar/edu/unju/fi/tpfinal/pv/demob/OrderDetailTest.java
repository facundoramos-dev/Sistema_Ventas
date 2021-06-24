package ar.edu.unju.fi.tpfinal.pv.demob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailRepository;

@SpringBootTest
public class OrderDetailTest {

	
	@Autowired
	IOrderDetailRepository orderDetailRepository;
	
	
	void  testGuardarOrderDetail() {
		OrderDetail orderDetail = new OrderDetail();
		
	}
	
}
